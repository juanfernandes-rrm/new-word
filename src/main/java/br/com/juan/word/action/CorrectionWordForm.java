package br.com.juan.word.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.juan.word.model.Banco;
import br.com.juan.word.model.Correction;
import br.com.juan.word.model.Teacher;
import br.com.juan.word.model.Word;

public class CorrectionWordForm implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("CorrectionWordForm");
		int idCorrection = Integer.parseInt(request.getParameter("idCorrection"));
		int idTeacher = Integer.parseInt(request.getParameter("idTeacher"));
		
		HttpSession session = request.getSession();
		
		Banco banco = new Banco();
		Correction correction = banco.getCorrectionById(idCorrection);
		Teacher teacher = (Teacher) banco.getUserById(idTeacher);
		correction.setTeacher(teacher);
		
		System.out.println("Correction "+correction);
		
		session.setAttribute("correction", correction);
		
		return "forward:correction.jsp";
	}

}
