package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dto.BusinessmanVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BusinessmanCampingListUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "camp.do?command=businessmanCampingList";

		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		
		if( bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			BusinessmanVO bmvo = new BusinessmanVO();
			ServletContext context = session.getServletContext();
		    String path = context.getRealPath("images");
		    MultipartRequest multi = new MultipartRequest(
		    		request, path, 5*1024*1024, "UTF-8",	 new DefaultFileRenamePolicy() );			
		    bmvo.setBseq(Integer.parseInt(multi.getParameter("bseq")));
			bmvo.setContent(multi.getParameter("content"));
			bmvo.setCategory(multi.getParameter("category"));
			bmvo.setFacilities(multi.getParameter("facilities"));
			bmvo.setImage(multi.getFilesystemName("image"));
			
			BusinessmanDao bdao = BusinessmanDao.getInstance();
			bdao.updateCampingList(bmvo);
			url = url + "&bseq=" + bmvo.getBseq();
		}
		response.sendRedirect(url);
	}

}
