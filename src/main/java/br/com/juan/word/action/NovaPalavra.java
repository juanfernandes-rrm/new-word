package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.model.Banco;
import br.com.juan.model.Palavra;

public class NovaPalavra implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = request.getParameter("palavra");
		System.out.println("Palavra = "+content);
		
		Palavra palavra = new Palavra();
		palavra.setContent(content);
		
		Banco banco = new Banco();
		banco.adicionaPalavra(palavra);
		
		HttpSession session = request.getSession();
		session.setAttribute("listaPalavras", banco.getPalavras());
		
		
		return "redirect:controller?action=NovaPalavraForm";
	}

}
