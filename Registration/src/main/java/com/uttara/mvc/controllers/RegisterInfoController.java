package com.uttara.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.uttara.mvc.components.BusinessServiceInterface;
import com.uttara.mvc.components.RegisterBean;

@RestController
@CrossOrigin
public class RegisterInfoController {
    
	@Autowired
	BusinessServiceInterface service;
	
	@RequestMapping("/users")
	public String getUsers() {
		
		Gson gson = new Gson();
		List<RegisterBean> register = service.usersInfo();
	    return 	gson.toJson(register);
	
	}
}
