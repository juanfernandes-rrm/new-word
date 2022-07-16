package br.com.juan.word.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.word.action.Acao;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String nomeDaClasse = "br.com.juan.word.action."+action;
		String path;
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
			Acao acao = (Acao)classe.newInstance();
			path = acao.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		
		String[] prefixAndPath = path.split(":");//[0] prefixo, [1] jsp
		
		if(prefixAndPath[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+prefixAndPath[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(prefixAndPath[1]);
		}
	}

}
