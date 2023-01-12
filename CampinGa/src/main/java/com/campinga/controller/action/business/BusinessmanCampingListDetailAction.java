package com.campinga.controller.action.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dto.BusinessmanVO;
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
			
			if( request.getParameter("start")!=null ) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			int page = 1;
			if( request.getParameter("page")!=null) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", Integer.parseInt( request.getParameter("page") ) );
			}else if( session.getAttribute("page")!=null ) {
				page = (Integer)session.getAttribute("page");
			} else {
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);
			paging.setPage(page);
			
			int bseq = bdao.getBseq(bvo.getBid());
			
			int count = bdao.getAllCount("businessman", "bseq", bseq);
			paging.setTotalCount(count);
			
			BusinessmanVO campingList = bdao.selectOne(bseq);
			
			request.setAttribute("BusinessmanVO", campingList);
			request.setAttribute("paging", paging);
		}
		HashMap<String, String> cateMap = new HashMap<String, String>();
		cateMap.put("¿ÀÅäÄ·ÇÎ", "auto");
		cateMap.put("Ä·ÇÎ", "camping");
		cateMap.put("Ä«¶ó¹Ý", "caravane");
		cateMap.put("Ä·ÇÁ´Ð", "campnic");
		
		request.setAttribute("cateMap", cateMap);
		request.getRequestDispatcher(url).forward(request, response);
	} 

}
