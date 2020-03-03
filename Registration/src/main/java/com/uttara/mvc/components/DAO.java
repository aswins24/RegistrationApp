package com.uttara.mvc.components;

import java.util.List;

public interface DAO {

	public String insert(RegBean bean);
	public String update(String email, RegBean bean);
	public String delete(String email);
	public List<Register> getUsers();
	public Register getUserInfo(String email);
	public Register getUserInfo (String email, String pass);
	public Long insert(RegisterBean bean);
	public Register_2 getUser(String email);
}
