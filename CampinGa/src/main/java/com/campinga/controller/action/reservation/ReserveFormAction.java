package com.campinga.controller.action.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dao.MemberDao;
import com.campinga.dto.CampingVO;
import com.campinga.dto.MemberVO;


public class ReserveFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/reserve/reserve.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int cseq = Integer.parseInt(request.getParameter("cseq"));
		CampingVO cvo = new CampingVO();
	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	// 회원정보
	    	MemberDao mdao = MemberDao.getInstance();
	    	mvo = mdao.getMember(mvo.getMid());
	    	
	    	// 캠핑장 + 방정보
	    	CampDao cdao = CampDao.getInstance();
	    	cvo = cdao.selectOneInfo(cseq);
	    }	    
	    request.setAttribute("loginUser", mvo);
	    request.setAttribute("campVO", cvo);
	    request.getRequestDispatcher(url).forward(request, response);
	}
	
}
