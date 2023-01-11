package com.campinga.controller;

import com.campinga.controller.action.Action;
import com.campinga.controller.action.ContractFormAction;
import com.campinga.controller.action.IndexAction;
import com.campinga.controller.action.NoticeDetailAction;
import com.campinga.controller.action.NoticeListAction;
import com.campinga.controller.action.admin.AdminAction;
import com.campinga.controller.action.admin.AdminCampingDeleteAction;
import com.campinga.controller.action.admin.AdminCampingListAction;
import com.campinga.controller.action.admin.AdminLoginAction;
import com.campinga.controller.action.admin.AdminLoginFormAction;
import com.campinga.controller.action.admin.AdminLogoutAction;
import com.campinga.controller.action.admin.AdminMemberDeleteAction;
import com.campinga.controller.action.admin.AdminMemberListAction;
import com.campinga.controller.action.admin.AdminNoticeDeleteAction;
import com.campinga.controller.action.admin.AdminNoticeDetailAction;
import com.campinga.controller.action.admin.AdminNoticeListAction;
import com.campinga.controller.action.admin.AdminNoticeUpdateAction;
import com.campinga.controller.action.admin.AdminNoticeUpdateFormAction;
import com.campinga.controller.action.admin.AdminNoticeWriteAction;
import com.campinga.controller.action.admin.AdminNoticeWriteFormAction;
import com.campinga.controller.action.admin.AdminRestListAction;
import com.campinga.controller.action.admin.AdminReviewDeleteAction;
import com.campinga.controller.action.admin.AdminReviewListAction;
import com.campinga.controller.action.business.BusinessJoinAction;
import com.campinga.controller.action.business.BusinessmanCampingListDetailAction;
import com.campinga.controller.action.business.BusinessmanCampingListAction;
import com.campinga.controller.action.business.BusinessmanCampingListUpdateAction;
import com.campinga.controller.action.business.BusinessmanCampingtListInsertAction;
import com.campinga.controller.action.business.BusinessmanEditFormAction;
import com.campinga.controller.action.business.BusinessmanMypageAction;
import com.campinga.controller.action.business.BusinessmanRestListAction;
import com.campinga.controller.action.business.CampingQnaAction;
import com.campinga.controller.action.business.CampingQnaFormAction;
import com.campinga.controller.action.business.CampingQnaRepSaveAction;
import com.campinga.controller.action.business.CampingRoomInfoAction;
import com.campinga.controller.action.business.DeleteBusinessmanAction;
import com.campinga.controller.action.business.DeleteCampingRoomListAction;
import com.campinga.controller.action.business.InsertCampingRoomListAction;
import com.campinga.controller.action.business.UpdateBusinessInfoAction;
import com.campinga.controller.action.business.UpdateCampingRoomListAction;
import com.campinga.controller.action.camping.CampDetailAction;
import com.campinga.controller.action.camping.CategoryAction;
import com.campinga.controller.action.camping.MainSearchAction;
import com.campinga.controller.action.camping.SearchResultAction;
import com.campinga.controller.action.favorites.AddFavoritesAction;
import com.campinga.controller.action.member.IdCheckFormAction;
import com.campinga.controller.action.member.JoinAction;
import com.campinga.controller.action.member.JoinFormAction;
import com.campinga.controller.action.member.LoginAction;
import com.campinga.controller.action.member.LoginFormAction;
import com.campinga.controller.action.member.LogoutAction;
import com.campinga.controller.action.mypage.CancelReservateAction;
import com.campinga.controller.action.mypage.DeleteFavoritesAction;
import com.campinga.controller.action.mypage.DeleteMemberAction;
import com.campinga.controller.action.mypage.EditFormAction;
import com.campinga.controller.action.mypage.MypageAction;
import com.campinga.controller.action.mypage.UpdateUserInfoAction;
import com.campinga.controller.action.qna.DeleteQnaAction;
import com.campinga.controller.action.qna.InsertQnaAction;
import com.campinga.controller.action.qna.QnaViewAction;
import com.campinga.controller.action.qna.UpdateQnaAction;
import com.campinga.controller.action.reservation.ReserveFormAction;
import com.campinga.controller.action.reservation.ReserveInsertAction;
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
		else if(command.equals("noticeList")) ac = new NoticeListAction();
		else if(command.equals("noticeDetail")) ac = new NoticeDetailAction();
		
		// camping action
		else if(command.equals("category")) ac = new CategoryAction();
	    else if(command.equals("searchResult")) ac = new SearchResultAction();
	    else if(command.equals("campDetail")) ac = new CampDetailAction();
	    else if(command.equals("mainSearch")) ac = new MainSearchAction();
		
		// reservation action
	    else if(command.equals("reserveForm")) ac = new ReserveFormAction();
	    else if(command.equals("reserveInsert")) ac = new ReserveInsertAction();
		
		// mypage action
		else if(command.equals("mypage")) ac = new MypageAction();
		else if(command.equals("editForm")) ac = new EditFormAction();
		else if(command.equals("updateUserInfo")) ac = new UpdateUserInfoAction();
		else if(command.equals("deleteMember")) ac = new DeleteMemberAction();
		else if(command.equals("cancelReservate")) ac = new CancelReservateAction();
		else if(command.equals("deleteFavorites")) ac = new DeleteFavoritesAction();
		
		// favorites action
		else if(command.equals("addFavorites")) ac = new AddFavoritesAction();
		else if(command.equals("deleteFavorites")) ac = new DeleteFavoritesAction();
		
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
	    else if(command.equals("contractForm")) ac = new ContractFormAction();
	    else if(command.equals("businessmanEditForm")) ac = new BusinessmanEditFormAction();
	    else if(command.equals("businessmanMypage")) ac = new BusinessmanMypageAction();
	    else if(command.equals("businessmanRestList")) ac = new BusinessmanRestListAction();
	    else if(command.equals("deleteBusinessman")) ac = new DeleteBusinessmanAction();
	    else if(command.equals("updateBusinessInfo")) ac = new UpdateBusinessInfoAction();
	    else if(command.equals("businessmanCampingList")) ac = new BusinessmanCampingListAction();
	    else if(command.equals("businessmanCampingListDetail")) ac = new BusinessmanCampingListDetailAction();
	    else if(command.equals("businessmanCampingListUpdate")) ac = new BusinessmanCampingListUpdateAction();
	    else if(command.equals("businessmanCampingListInsert")) ac = new BusinessmanCampingtListInsertAction();
		
	    else if(command.equals("campingQnaRepSave")) ac = new CampingQnaRepSaveAction();
	    else if(command.equals("campingQnaForm")) ac = new CampingQnaFormAction();
	    else if(command.equals("campingQna")) ac = new CampingQnaAction();
	    else if(command.equals("campingQnaRepSave")) ac = new CampingQnaRepSaveAction();
		
	    else if(command.equals("campingRoomInfo")) ac = new CampingRoomInfoAction();
	    else if(command.equals("insertCampingRoomList")) ac = new InsertCampingRoomListAction();
	    else if(command.equals("updateCampingRoomList")) ac = new UpdateCampingRoomListAction();
	    else if(command.equals("deleteCampingRoomList")) ac = new DeleteCampingRoomListAction();
		
		// admin action
	    else if(command.equals("admin")) ac = new AdminAction();
		else if(command.equals("adminLoginForm")) ac = new AdminLoginFormAction();
	    else if(command.equals("adminLogin")) ac = new AdminLoginAction();
	    else if(command.equals("adminLogout")) ac = new AdminLogoutAction();
		
	    else if(command.equals("adminMemberList")) ac = new AdminMemberListAction();
	    else if(command.equals("adminMemberDelete")) ac = new AdminMemberDeleteAction();
		
	    else if(command.equals("adminReviewList")) ac = new AdminReviewListAction();		
	    else if(command.equals("adminReviewDelete")) ac = new AdminReviewDeleteAction();
		
	    else if(command.equals("adminRestList")) ac = new AdminRestListAction();
		
	    else if(command.equals("adminNoticeList")) ac = new AdminNoticeListAction();
	    else if(command.equals("adminNoticeDetail")) ac = new AdminNoticeDetailAction();
	    else if(command.equals("adminNoticeUpdateForm")) ac = new AdminNoticeUpdateFormAction();
	    else if(command.equals("adminNoticeUpdate")) ac = new AdminNoticeUpdateAction();
	    else if(command.equals("adminNoticeWriteForm")) ac = new AdminNoticeWriteFormAction();
	    else if(command.equals("adminNoticeWrite")) ac = new AdminNoticeWriteAction();
	    else if(command.equals("adminNoticeDelete")) ac = new AdminNoticeDeleteAction();
	      
	    else if(command.equals("adminCampingList")) ac = new AdminCampingListAction();
	    else if(command.equals("adminCampingDelete")) ac = new AdminCampingDeleteAction();

		return ac;
	}
	
}
