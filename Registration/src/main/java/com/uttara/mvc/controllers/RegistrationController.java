package com.uttara.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uttara.mvc.components.BusinessServiceInterface;
import com.uttara.mvc.components.Constants;
import com.uttara.mvc.components.LoginBean;
import com.uttara.mvc.components.RegBean;
import com.uttara.mvc.components.RegisterBean;

@Controller
public class RegistrationController {

	@Autowired
	BusinessServiceInterface service;
	
	@RequestMapping({"/","/home"})
	public String showHome()
	{
		System.out.println("in RAC->showHome()");
		return "Home";
	}
	
	@RequestMapping("/openRegisterView")
	public String showRegisterView(Model model)
	{
		System.out.println("in RAC->showRegisterView");
		
		RegBean bean = new RegBean();
		model.addAttribute("reg", bean);
		return "Register";
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute("reg") @Valid RegBean bean,BindingResult result,Model model)
	{
		System.out.println("in RAC->register() bean = "+bean);
		if(result.hasErrors())
		{
			System.out.println("in RAC->register() result of bean validation failed! result = "+result);
			return "Register";
		}
		else
		{
			//invoke service and ask it to store bean data to db
			if(service.userCheck(bean.getEmail())) {	
				
			String msg = service.register(bean);
			if(msg.equals(Constants.SUCCESS))
			{
				model.addAttribute("msg","Your registration has successfully completed!");
				return "Success";
			}
			else
			{
				model.addAttribute("errormsg", msg);
				return "Error";
			}
		} else {
			   model.addAttribute("errormsg", Constants.USER_EXISTS);
			   return "Error";
			
		}
	}
		
		
	}
	@RequestMapping("/openLoginView")
	public String showLogInView(Model model) {
		
		LoginBean bean = new LoginBean();
		model.addAttribute("log", bean);
		return "Login";
	}
	@RequestMapping("/login")
  public String logIn(@ModelAttribute("log") @Valid LoginBean bean, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "Login";
		} 
			
			RegisterBean rBean = service.Login(bean.getEmail(), bean.getPass());
			
			if(rBean != null) {
				
				model.addAttribute("msg", Constants.LOG_IN_SUCCESS +" "+rBean.getuName());
				return "Success";
			}
				model.addAttribute("errormsg",Constants.LOG_IN_FAILED );
				return "Login";
	}
}
