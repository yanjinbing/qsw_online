package cn.edu.bjut.gct.web;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspApplicationContext;
import javax.servlet.jsp.JspFactory;

import org.springframework.web.servlet.DispatcherServlet;

@SuppressWarnings("serial")
public class DispatcherServletEx extends DispatcherServlet {

	protected void initFrameworkServlet() throws ServletException {
		// 注册nodeELResolver
		JspApplicationContext jac = JspFactory.getDefaultFactory().getJspApplicationContext(getServletContext());
		jac.addELResolver(getWebApplicationContext().getBean(SolrDocumentListResolver.class));
		
	}
}
