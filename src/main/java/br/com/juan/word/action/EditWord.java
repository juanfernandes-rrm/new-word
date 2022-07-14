package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Word;

public class EditWord implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String content = request.getParameter("word");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Word word = banco.getWordById(id);
		word.setContent(content);
		System.out.println("Chegou Action EditWord");
		
		return "redirect:controller?action=NewWordForm";
	}

}
