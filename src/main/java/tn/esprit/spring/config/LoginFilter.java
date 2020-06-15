package tn.esprit.spring.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.spring.controller.UsersController;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		UsersController Userscontroller = (UsersController)
		httpServletRequest.getSession().getAttribute("UsersController");
		if (Userscontroller!=null && Userscontroller.getAuthenticatedUser() != null &&
				Userscontroller.getLoggedIn()) { filterChain.doFilter(servletRequest, servletResponse);}
		else {httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
		"/signin.jsf");}

	}*/

}
