package com.campinga.controller.action.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dto.MemberVO;


public class ReserveFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/reserve/reserve.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}
	
}
