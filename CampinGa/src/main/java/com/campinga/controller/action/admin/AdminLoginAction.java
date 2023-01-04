package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.AdminDao;


public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminId = request.getParameter("adminId");
	    String adminPwd = request.getParameter("adminPwd");
	    
	    String url = "camp.do?command=adminLoginForm";  // 관리자 로그인창
	    
	    AdminDao adao = AdminDao.getInstance();
	    String adminUserPwd = adao.workerCheck( adminId );
	    
	    if( adminUserPwd == null ) 
	    	request.setAttribute("message", "아이디가 없습니다");
	    else if( !adminUserPwd.equals(adminPwd) ) 
	    	request.setAttribute("message", "비밀번호가 맞지 않습니다");
	    else if( adminUserPwd.equals(adminPwd) ) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginAdmin", adminId );
	    	url = "admin/header.jsp";
	    }
	    request.getRequestDispatcher(url).forward(request, response);

	}

}
