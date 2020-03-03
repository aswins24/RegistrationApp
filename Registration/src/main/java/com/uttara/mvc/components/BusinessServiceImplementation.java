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
		Register register = dao.getUserInfo(email);
		
		if(register != null)
			return false;
		
		return true;
	}
	
	public Register Login(String email, String pass) {
		
		return dao.getUserInfo(email, pass);
	}

	public List<Register> usersInfo() {

		return dao.getUsers();
	}

	public String register(RegisterBean bean) {

		Long id = null;
		id = dao.insert(bean);

		return id != null? Constants.SUCCESS: Constants.FAILURE;
	}
	
	public boolean userCheck(RegisterBean bean) {
		System.out.println("in Service Implementation -> userCheck() -> "+bean);
		Register_2 register = dao.getUser(bean.getEmail());
		return register != null? true : false;
	}
}

