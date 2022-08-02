package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Correction;
import br.com.juan.word.model.Word;

public class EditWord implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String content = request.getParameter("word");
		String phrase = request.getParameter("phrase");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Correction correction = banco.getCorrectionById(id);
		Word word = correction.getWord();
		word.setContent(content);
		word.setPhrase(phrase);
		
		return "redirect:controller?action=NewWordForm";
	}

}
