package br.com.juan.word.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.word.model.User;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter("/controller")
public class PermissionFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Filter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userLogin");
		
		String action = request.getParameter("action");
		
		boolean isUserLogin = (user!=null);
		boolean isProtectedAction = !(action.equals("LoginForm") || action.equals("Login"));
		
		if(!isUserLogin && isProtectedAction) {
			response.sendRedirect("controller?action=LoginForm");
			System.out.println("Filter: controller?action=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}
}
