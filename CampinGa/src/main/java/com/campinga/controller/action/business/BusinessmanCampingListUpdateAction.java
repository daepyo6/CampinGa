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
		    String path = context.getRealPath("campingImage");
		    MultipartRequest multi = new MultipartRequest(
		    		request, path, 5*1024*1024, "UTF-8",	 new DefaultFileRenamePolicy() );			
		    bmvo.setBseq(Integer.parseInt(multi.getParameter("bseq")));
		    bmvo.setCname(multi.getParameter("cname"));
		    
		    String caddress1 = multi.getParameter("caddress1");
			String[] sido = {"","서울시","부산시","대구광역시","인천광역시","광주광역시","대전광역시","울산광역시","강원도","경기도","경상남도","경상북도","전라남도","전라북도","제주도","충청남도","충청북도"};
			caddress1 = sido[Integer.parseInt(caddress1)];
			bmvo.setCaddress1(caddress1);
			bmvo.setCaddress2(multi.getParameter("caddress2"));
			bmvo.setCaddress3(multi.getParameter("caddress3"));
		    
			bmvo.setContent(multi.getParameter("content"));
			bmvo.setCategory(multi.getParameter("category"));
			
			String [] fac = multi.getParameterValues("facilities");
			String facilities = String.join(", ", fac);
			bmvo.setFacilities(facilities);
			String newImg = multi.getFilesystemName("newimg");
			String oldImg = multi.getParameter("oldimg");
			if(newImg!=null) 
				bmvo.setImage(newImg);
			else
				bmvo.setImage(oldImg);
			
			BusinessmanDao bdao = BusinessmanDao.getInstance();
			bdao.updateCampingList(bmvo);
			url = url + "&bseq=" + bmvo.getBseq();
		}
		response.sendRedirect(url);
	}

}
