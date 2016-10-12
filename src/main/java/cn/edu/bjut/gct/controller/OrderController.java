package cn.edu.bjut.gct.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class OrderController {

	@RequestMapping("/buy.do")
	public String buy(){
		return "buy/buy";
	}

	@RequestMapping("/dobuy.do")
	public String doBuy(Model model, HttpSession session){

		String message, linkText, linkUrl;
		session.setAttribute("pay", 1);
		message = "支付成功";
		linkText = "进入首页";
		linkUrl = "index.do";
		
		model.addAttribute("message", message);
		model.addAttribute("linkText", linkText);
		model.addAttribute("linkUrl", linkUrl);
		
		return "sign/info";
	}
}
