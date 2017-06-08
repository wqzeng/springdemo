package com.springdemo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author moke
 */
public class HibernateDao extends HibernateDaoSupport {
    public HibernateDao() {

    }

    /*
    private Class modelClass = null;
    protected Class getModelClass() {
        if (modelClass == null) {
            modelClass = GenericsUtil.getGenericClass(getClass());
        }
        return modelClass;
    }
     *
     */

    @Resource(name="sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    public void add(Object model) {
        this.getHibernateTemplate().save(model);
    }

    public void update(Object model) {
        this.getHibernateTemplate().update(model);
    }

    public void delete(Object model) {
        this.getHibernateTemplate().delete(model);
    }

    /*
    public <T> T getByKey(Object value) throws java.lang.NoSuchMethodException {
        Class type = GenericsUtil.getReturnType(HibernateUtil.class.getMethod("getByKey", String.class));
        return (T)getByKey(type, value);
    }
     *
     */

    public Object getByKey(Class type, Object value) throws java.lang.NoSuchMethodException {
        String expression = type.getSimpleName() + "Id=?";
        List list = query(type, expression, new Object[] { value }, "");
        if (list != null &&
                list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public List getAll(Class type, String sort) throws java.lang.NoSuchMethodException {
        return getAllPaged(type, sort, 0, 0);
    }

    public List getAllPaged(Class type, String sort, int pageSize, int skip) throws java.lang.NoSuchMethodException {
        return queryPaged(type, "", null, sort, pageSize, skip);
    }

    public int getCount(Class type) throws java.lang.NoSuchMethodException {
        return getAll(type, "").size();
    }

    public List query(Class type, String expression, Object[] values, String sort) throws java.lang.NoSuchMethodException {
        return queryPaged(type, expression, values, sort, 0, 0);
    }

    public List queryPaged(Class type, final String expression, final Object[] values, final String sort, final int pageSize, final int skip) throws java.lang.NoSuchMethodException {
        final String name = type.getSimpleName();
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public List doInHibernate(Session session) {
                StringBuffer sb = new StringBuffer();
                sb.append("from ");
                sb.append(name);
                if (expression.length() > 0) {
                    sb.append(" where ");
                    sb.append(expression);
                }
                if (sort.length() > 0) {
                    sb.append(" order by ");
                    sb.append(sort);
                }
                Query query = session.createQuery(sb.toString());

                if (values != null) {
                    for (int i = 0; i < values.length; i++) {
                        query.setParameter(i, values[i]);
                    }
                }

                if (skip > 0)
                    query.setFirstResult(skip);
                if (pageSize > 0)
                    query.setMaxResults(pageSize);

                return query.list();
            }
        });
    }

    public int queryCount(Class type, String expression, Object[] values) throws java.lang.NoSuchMethodException {
        return query(type, expression, values, "").size();
    }
}
