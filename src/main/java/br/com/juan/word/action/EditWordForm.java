package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Correction;
import br.com.juan.word.model.Word;

public class EditWordForm implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Correction correction = banco.getCorrectionById(id);
		
		request.setAttribute("correction", correction);
		
		return "forward:EditWord.jsp";
	}

}
