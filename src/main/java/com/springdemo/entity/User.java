package com.springdemo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByMembershipUserId", query = "SELECT u FROM User u WHERE u.membershipUserId = :membershipUserId"),
    @NamedQuery(name = "User.findByBranchId", query = "SELECT u FROM User u WHERE u.branchId = :branchId"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByAlias", query = "SELECT u FROM User u WHERE u.alias = :alias"),
    @NamedQuery(name = "User.findByProperty1", query = "SELECT u FROM User u WHERE u.property1 = :property1"),
    @NamedQuery(name = "User.findByProperty2", query = "SELECT u FROM User u WHERE u.property2 = :property2"),
    @NamedQuery(name = "User.findByProperty3", query = "SELECT u FROM User u WHERE u.property3 = :property3"),
    @NamedQuery(name = "User.findByProperty4", query = "SELECT u FROM User u WHERE u.property4 = :property4"),
    @NamedQuery(name = "User.findByMemo", query = "SELECT u FROM User u WHERE u.memo = :memo"),
    @NamedQuery(name = "User.findByState", query = "SELECT u FROM User u WHERE u.state = :state"),
    @NamedQuery(name = "User.findByModifiedTime", query = "SELECT u FROM User u WHERE u.modifiedTime = :modifiedTime")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserId")
    private String userId;
    @Column(name = "MembershipUserId")
    private String membershipUserId;
    @Column(name = "BranchId")
    private String branchId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Alias")
    private String alias;
    @Column(name = "Property1")
    private String property1;
    @Column(name = "Property2")
    private String property2;
    @Column(name = "Property3")
    private String property3;
    @Column(name = "Property4")
    private String property4;
    @Column(name = "Memo")
    private String memo;
    @Column(name = "State")
    private String state;
    @Column(name = "ModifiedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
 
    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMembershipUserId() {
        return membershipUserId;
    }

    public void setMembershipUserId(String membershipUserId) {
        this.membershipUserId = membershipUserId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

    public String getProperty4() {
        return property4;
    }

    public void setProperty4(String property4) {
        this.property4 = property4;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.model.User[userId=" + userId + "]";
    }

}
