package com.campinga.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;

import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.MemberVO;


public class UpdateQnaAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String url = "camp.do?command=CampDetail";
      HttpSession session = request.getSession();
      MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
      if( mvo == null) url = "camp.do?command=index"; 
      else {
         Camp_qnaVO qnaVo = new Camp_qnaVO();
         qnaVo.setQseq(Integer.parseInt(request.getParameter("qseq")));
         qnaVo.setMid(request.getParameter("mid"));
         qnaVo.setContent(request.getParameter("content"));
         Camp_qnaDao qnadao = Camp_qnaDao.getInstance();
         qnadao.updateQna(qnaVo);
      }
      response.sendRedirect(url);
   }

}