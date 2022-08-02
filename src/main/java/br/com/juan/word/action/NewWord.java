package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Correction;
import br.com.juan.word.model.Word;

public class NewWord implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = request.getParameter("word");
		String phrase = request.getParameter("phrase");
		
		Word word = new Word();
		word.setContent(content);
		word.setPhrase(phrase);
		Correction correction = new Correction(word);
		
		Banco banco = new Banco();
		banco.addWord(word);
		banco.addCorrection(correction);
		
		HttpSession session = request.getSession();
		session.setAttribute("listCorrections", Banco.getCorrections());
		
		
		return "redirect:controller?action=NewWordForm";
	}

}
