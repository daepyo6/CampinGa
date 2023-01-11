package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dao.CampDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateCampingRoomAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=campingRoomList";
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		
		if(bvo == null){
			url = "camp.do?command=loginForm";
		} else {	
			CampingVO cvo = new CampingVO();
		    String path =  session.getServletContext().getRealPath("campingImage");
		    
			MultipartRequest multi = new MultipartRequest(
					request, path, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		    cvo.setCseq( Integer.parseInt( multi.getParameter("cseq")));
		    cvo.setC_class( multi.getParameter("c_class") );
		    cvo.setC_content( multi.getParameter("c_content"));
		    cvo.setPrice( Integer.parseInt( multi.getParameter("price")));
		    cvo.setMin_people( Integer.parseInt( multi.getParameter("min_people")));
		    cvo.setMax_people( Integer.parseInt( multi.getParameter("max_people")));
		    if(multi.getFilesystemName("c_image") == null) {
		    	cvo.setC_image( multi.getFilesystemName("oldc_image"));
		    } else {
		    	cvo.setC_image( multi.getFilesystemName("c_image"));
		    }
		    
		    CampDao cdao = CampDao.getInstance();
		    cdao.updateCampingRoom(cvo);
		}
		response.sendRedirect(url);

	}

}
