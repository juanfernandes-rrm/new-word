package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Word;

public class NewWord implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = request.getParameter("word");
		System.out.println("Word = "+content);
		
		Word word = new Word();
		word.setContent(content);
		
		Banco banco = new Banco();
		banco.addWord(word);
		
		HttpSession session = request.getSession();
		session.setAttribute("listWords", Banco.getWords());
		
		
		return "redirect:controller?action=NewWordForm";
	}

}
