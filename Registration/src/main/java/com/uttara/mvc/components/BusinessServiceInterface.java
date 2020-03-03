package com.uttara.mvc.components;

import java.util.List;

public interface BusinessServiceInterface {

	public String register(RegBean bean);
	
	public boolean userCheck(String email);
	
	public Register Login(String email, String pass);
	
	public List<Register> usersInfo();
	
	public String register(RegisterBean bean);
	
	public boolean userCheck(RegisterBean bean);
	
}
