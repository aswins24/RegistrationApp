package com.uttara.mvc.components;

import java.util.List;

public interface BusinessServiceInterface {

	public String register(RegBean bean);
	
	public boolean userCheck(String email);
	
	public RegisterBean Login(String email, String pass);
	
	public List<RegisterBean> usersInfo();
	
}
