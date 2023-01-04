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
	    
	    String url = "camp.do?command=adminLoginForm";  // ������ �α���â
	    
	    AdminDao adao = AdminDao.getInstance();
	    String adminUserPwd = adao.workerCheck( adminId );
	    
	    if( adminUserPwd == null ) 
	    	request.setAttribute("message", "���̵� �����ϴ�");
	    else if( !adminUserPwd.equals(adminPwd) ) 
	    	request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�");
	    else if( adminUserPwd.equals(adminPwd) ) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginAdmin", adminId );
	    	url = "admin/header.jsp";
	    }
	    request.getRequestDispatcher(url).forward(request, response);

	}

}
