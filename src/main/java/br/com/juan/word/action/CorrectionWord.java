package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Correction;
import br.com.juan.word.model.Teacher;
import br.com.juan.word.model.Word;

public class CorrectionWord implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String comment = request.getParameter("comment");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Correction correction = banco.getCorrectionById(id);
		correction.setComment(comment);
		System.out.println("Correction ANTES = "+correction);

		//talvez atualizar o objeto no banco com comentario
		//banco.addCorrection(correction);
		System.out.println("Correction Depois = "+correction);
		
		return "forward:teacherHome.jsp";
	}

}
