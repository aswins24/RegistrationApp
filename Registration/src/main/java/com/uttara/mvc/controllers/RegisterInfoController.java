package com.uttara.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.uttara.mvc.components.BusinessServiceInterface;
import com.uttara.mvc.components.Constants;
import com.uttara.mvc.components.Register;
import com.uttara.mvc.components.RegisterBean;

@RestController
@CrossOrigin
public class RegisterInfoController {
    
	@Autowired
	BusinessServiceInterface service;
	
	@RequestMapping("/users")
	public String getUsers() {
		
		Gson gson = new Gson();
		List<Register> register = service.usersInfo();
	    return 	gson.toJson(register);
	
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@RequestBody RegisterBean bean) {
		Gson gson = new Gson();
		String msg;
		if(!service.userCheck(bean)) {
		  msg	= service.register(bean);
		} else {
			msg = Constants.USER_EXISTS;
		}
		return gson.toJson(msg);
	}
}
