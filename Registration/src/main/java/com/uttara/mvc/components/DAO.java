package com.uttara.mvc.components;

import java.util.List;

public interface DAO {

	public String insert(RegBean bean);
	public String update(String email, RegBean bean);
	public String delete(String email);
	public List<RegisterBean> getUsers();
	public RegisterBean getUserInfo(String email);
	public RegisterBean getUserInfo (String email, String pass);
}
