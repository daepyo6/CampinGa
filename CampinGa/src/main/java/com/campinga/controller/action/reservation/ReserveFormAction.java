package com.campinga.controller.action.reservation;

import java.io.IOException;
import java.util.ArrayList;

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
	    	
	    	// 방예약 정보
	    	ReservationDao redao = ReservationDao.getInstance();
	    	ArrayList<ReservationVO> reserveDateList = redao.selectReserveCheckDate(cseq);
	    	request.setAttribute("reDateList", reserveDateList);
	    	for (ReservationVO revo : reserveDateList) {
				System.out.println(revo.getChk_in() + " "+ revo.getChk_out());
			}
	    }	    
	    request.setAttribute("loginUser", mvo);
	    request.setAttribute("campVO", cvo);
	    request.getRequestDispatcher(url).forward(request, response);
	}
	
}
