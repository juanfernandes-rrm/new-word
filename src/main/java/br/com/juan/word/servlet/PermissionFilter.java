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
	public static int vezPassou = 1;
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println(vezPassou++);
		System.out.println("Filter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userLogin");
		String action = request.getParameter("action");
		
		
		//suspeita de ao fazer upcast, perder o atributo
		
		boolean isUserLogin = (user!=null);
		System.out.println("User"+user);
		boolean isProtectedAction = !(action.equals("LoginForm") || action.equals("Login"));
		boolean isProtectedActionTeacher = (action.equals("NewWord") || action.equals("NewWordForm"));
		
		if(!isUserLogin && isProtectedAction) {
			response.sendRedirect("controller?action=LoginForm"); 
			return; 
		}
		
		if(isUserLogin) {
			if(user.getRole().toUpperCase().equals("TEACHER")) {
				if(isProtectedActionTeacher) {
					response.sendRedirect("controller?action=Home");
					return;
				}
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}
}
