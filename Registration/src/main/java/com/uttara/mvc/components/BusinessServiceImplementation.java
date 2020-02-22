package com.uttara.mvc.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class BusinessServiceImplementation implements BusinessServiceInterface {

	@Autowired
	private DAO dao;
	
	public String register(RegBean bean) {
		
		System.out.println("in BSI->register() bean = "+bean);
		//impl storing bean data to db;
		
		System.out.println("inserting data = "+dao.insert(bean));
		
		return Constants.SUCCESS;
	}
	
	public boolean userCheck(String email) {
		RegisterBean register = dao.getUserInfo(email);
		
		if(register != null)
			return false;
		
		return true;
	}
	
	public RegisterBean Login(String email, String pass) {
		
		return dao.getUserInfo(email, pass);
	}

public List<RegisterBean> usersInfo() {

		return dao.getUsers();
	}
}

