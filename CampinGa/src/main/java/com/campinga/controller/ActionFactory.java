package com.campinga.controller;

import com.campinga.controller.action.Action;
import com.campinga.controller.action.ContractFormAction;
import com.campinga.controller.action.IndexAction;
import com.campinga.controller.action.admin.AdminLoginAction;
import com.campinga.controller.action.admin.AdminLoginFormAction;
import com.campinga.controller.action.admin.AdminLogoutAction;
import com.campinga.controller.action.business.BusinessJoinAction;
import com.campinga.controller.action.camping.CampDetailAction;
import com.campinga.controller.action.camping.CategoryAction;
import com.campinga.controller.action.camping.SearchResultAction;
import com.campinga.controller.action.member.IdCheckFormAction;
import com.campinga.controller.action.member.JoinAction;
import com.campinga.controller.action.member.JoinFormAction;
import com.campinga.controller.action.member.LoginAction;
import com.campinga.controller.action.member.LoginFormAction;
import com.campinga.controller.action.member.LogoutAction;
import com.campinga.controller.action.mypage.MypageAction;
import com.campinga.controller.action.qna.DeleteQnaAction;
import com.campinga.controller.action.qna.InsertQnaAction;
import com.campinga.controller.action.qna.QnaViewAction;
import com.campinga.controller.action.qna.UpdateQnaAction;
import com.campinga.controller.action.review.DeleteReviewAction;
import com.campinga.controller.action.review.InsertReviewAction;
import com.campinga.controller.action.review.ReviewFormAction;
import com.campinga.controller.action.review.UpdateReviewAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if( command.equals("index") ) ac = new IndexAction();
		else if(command.equals("contractForm")) ac = new ContractFormAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		
		// camping action
		else if(command.equals("category")) ac = new CategoryAction();
	    else if(command.equals("searchResult")) ac = new SearchResultAction();
	    else if(command.equals("campDetail")) ac = new CampDetailAction();
		
		// mypage action
		else if(command.equals("mypage")) ac = new MypageAction();
		
		// review action
		else if(command.equals("reviewForm")) ac = new ReviewFormAction();
		else if(command.equals("insertReview")) ac = new InsertReviewAction();
		else if(command.equals("updateReview")) ac = new UpdateReviewAction();
		else if(command.equals("deleteReview")) ac = new DeleteReviewAction();
		
		// qna action
		else if(command.equals("qnaView")) ac = new QnaViewAction();
		else if(command.equals("insertQna")) ac = new InsertQnaAction();
		else if(command.equals("updateQna")) ac = new UpdateQnaAction();
		else if(command.equals("deleteQna")) ac = new DeleteQnaAction();
		
		// business action
	    else if(command.equals("businessJoin")) ac = new BusinessJoinAction();
		
		// admin action
		else if(command.equals("adminLoginForm")) ac = new AdminLoginFormAction();
	    else if(command.equals("adminLogin")) ac = new AdminLoginAction();
	    else if(command.equals("adminLogout")) ac = new AdminLogoutAction();
	
		return ac;
	}
	
}
