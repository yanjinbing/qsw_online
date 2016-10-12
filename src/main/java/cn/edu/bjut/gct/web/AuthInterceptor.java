package cn.edu.bjut.gct.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String[] excludeUrls = new String[]{"/signin","dosignin", "signup", "dosignup", "signout"};
		String[] needPayUrls = new String[]{"/detail"};

		HttpSession session = request.getSession();				
		String curUrl = request.getRequestURL().toString();
				
		for (String url : excludeUrls) {
			if(curUrl.contains(url)){
				return true;
			}
		}
		
		if (session.getAttribute("username") == null) {
			response.sendRedirect(request.getContextPath() + "/signin.do");
		}
		for (String url : needPayUrls) {
			if(curUrl.contains(url)){
				if(session.getAttribute("pay") == null){
					response.sendRedirect(request.getContextPath()+"/buy.do");
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
