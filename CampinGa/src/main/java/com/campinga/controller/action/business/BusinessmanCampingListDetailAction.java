package com.campinga.controller.action.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;
import com.campinga.util.Paging;

public class BusinessmanCampingListDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "business/camping/campingListDetail.jsp";
		
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		if( bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			BusinessmanDao bdao = BusinessmanDao.getInstance();
			
			
			System.out.println(1);
			int page=1;
			if( request.getParameter("page")!= null ) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			} else if( session.getAttribute("page")!=null ) {
				page = (int) session.getAttribute("page"); 
			} else {
				session.removeAttribute("page");
			}
			
			
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			int count = bdao.getAllCount("camping", "bseq", bvo.getBseq() );
			paging.setTotalCount(count);
			
			ArrayList<CampingVO> list = bdao.selectCamping( paging, bvo.getBseq());
			
			request.setAttribute("campingList", list);
			request.setAttribute("paging", paging);
		}
		request.getRequestDispatcher(url).forward(request, response);
	} 

}
