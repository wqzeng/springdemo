/**
 * 
 */
package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author moke
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping(value = "/userlist")
	public String bankList(HttpServletRequest request) {
        Date date=new Date();
		request.setAttribute("username", "wqzeng");
		return "user/userlist";
	}
}
