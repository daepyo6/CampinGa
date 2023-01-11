package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;

public class AdminCampingDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "camp.do?command=adminCampingList";
		
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "camp.do?command=admin"; 
		}else {
			String [] bseqArr = request.getParameterValues("bseq");
			CampDao cdao = CampDao.getInstance();
			for( String bseq : bseqArr ) {
				cdao.deleteBusinessman( Integer.parseInt(bseq) );
		     }
		request.getRequestDispatcher(url).forward(request, response);

		}
	}

}
