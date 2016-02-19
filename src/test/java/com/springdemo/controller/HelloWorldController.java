/**
 * 
 */
package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Travelsky
 *
 */
@org.springframework.stereotype.Controller
@RequestMapping("/helloworld")
public class HelloWorldController implements Controller {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 //1���ռ���������֤����  
	       //2���󶨲������������  
	       //3�������������ҵ��������ҵ����  
	       //4��ѡ����һ��ҳ��  
	       ModelAndView mv = new ModelAndView();  
	       //���ģ������ �����������POJO����  
	       mv.addObject("message", "Hello World!");  
	       //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
	       mv.setViewName("hello");  
	       return mv;  
	}

}
