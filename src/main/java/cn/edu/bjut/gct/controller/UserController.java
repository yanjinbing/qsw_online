package cn.edu.bjut.gct.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.bjut.gct.service.UserMgrService;
import cn.edu.bjut.gct.model.User;

@Controller 
public class UserController {

	@Autowired
	private UserMgrService userService;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/signin.do")
	public String signIn(){
		return "sign/signin";
	}

	@RequestMapping("/dosignin.do")
	public String doSignIn(Model model, HttpSession session, String name, String pass){

		String message, linkText, linkUrl;
		if (!userService.Login(name, pass)) {
			message = "用户名/密码错误";
			linkText = "返回";
			linkUrl = "signin.do";
		} else {
			session.setAttribute("username", name);
			message = "登录成功";
			linkText = "进入首页";
			linkUrl = "index.do";
		}
		model.addAttribute("message", message);
		model.addAttribute("linkText", linkText);
		model.addAttribute("linkUrl", linkUrl);
		
		return "sign/info";
	}
	
	@RequestMapping("/signout.do")
	public String SignOut(Model model, HttpSession session){

		session.setAttribute("username", null);
		session.setAttribute("pay", null);

		return "index";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/signup.do")
	public String signUp(){
		return "sign/signup";
	}
	
	@RequestMapping("/dosignup.do")
	public String doSignUp(Model model, String name, String pass, String mail){
		
		String message, linkText, linkUrl;
		if (userService.IsUserExist(name)) {
			message = "用户名已存在";
			linkText = "返回";
			linkUrl = "signup.do";
		} else {
			User user = new User(name, pass, mail);
			userService.AddUser(user);
			
			message = "注册成功";
			linkText = "进入首页";
			linkUrl = "index.do";
		}
		model.addAttribute("message", message);
		model.addAttribute("linkText", linkText);
		model.addAttribute("linkUrl", linkUrl);
		
		return "sign/info";
	}
}
