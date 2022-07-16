package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.word.model.User;

public class Home implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userLogin");
		
		String role = user.getRole().toUpperCase();
		if(role.equals("TEACHER")) {
			return "forward:teacherHome.jsp";
		}else if(role.equals("STUDENT")) {
			return "forward:studentHome.jsp";
		}
		return null;
	}

}
