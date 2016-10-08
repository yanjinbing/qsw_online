package cn.edu.bjut.gct.controller;

import org.springframework.stereotype.Controller;

@Controller 
public class UserController {
	
	/**
	 * 登录
	 * @return
	 */
	public String signIn(){
		return "signin";
	}
	
	/**
	 * 注册
	 * @return
	 */
	public String signUp(){
		return "signup";
	}

}
