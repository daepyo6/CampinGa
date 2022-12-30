package com.campinga.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;


public class DeleteQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String qseq = request.getParameter("qseq");
	      
		  Camp_qnaDao qdao =  Camp_qnaDao.getInstance();
	      qdao.deleteQna( Integer.parseInt(qseq) );
	     
	      response.sendRedirect("camp.do?command=qnaView");

	}

}
