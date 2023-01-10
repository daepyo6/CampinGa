package com.campinga.controller.action.reservation;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dao.MemberDao;
import com.campinga.dao.ReservationDao;
import com.campinga.dto.CampingVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReservationVO;

public class ReserveInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/reserve/reserve.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		ReservationVO rvo = new ReservationVO();
		
	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	// �������� ���
	    	rvo.setCseq(Integer.parseInt(request.getParameter("cseq")));
	    	rvo.setMid(request.getParameter("mid"));
	    	rvo.setPrice(Integer.parseInt(request.getParameter("price")));
	    	rvo.setPeople(Integer.parseInt(request.getParameter("people")));
	    	rvo.setChk_in(request.getParameter("chk_in"));
	    	rvo.setChk_out(request.getParameter("chk_out"));
	    	
	    	ReservationDao redao = ReservationDao.getInstance();
	    	redao.insertReservation(rvo);
	    }	    
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
