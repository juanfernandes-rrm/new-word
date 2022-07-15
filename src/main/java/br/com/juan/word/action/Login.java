package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.User;

public class Login implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = Banco.searchUser(username, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userLogin", user);
			return "redirect:controller?action=NewWordForm";
		}else {
			return "redirect:controller?action=LoginForm";
		}
	}

}
