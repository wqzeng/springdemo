/**
 * 
 */
package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Travelsky
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "/userlist.action")
	public String bankList(HttpServletRequest request) {
		request.setAttribute("username", "ÔøÎ°Ç¿");
		return "user/userlist";
	}
}
