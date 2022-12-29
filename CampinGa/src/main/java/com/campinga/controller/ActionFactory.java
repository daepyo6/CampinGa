package com.campinga.controller;

import com.campinga.controller.action.Action;
import com.campinga.controller.action.IndexAction;
import com.campinga.controller.action.camping.CategoryAction;
import com.campinga.controller.action.member.IdCheckFormAction;
import com.campinga.controller.action.member.JoinAction;
import com.campinga.controller.action.member.JoinFormAction;
import com.campinga.controller.action.member.LoginAction;
import com.campinga.controller.action.member.LoginFormAction;
import com.campinga.controller.action.member.LogoutAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if( command.equals("index") ) ac = new IndexAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("category")) ac = new CategoryAction();
		
		return ac;
	}
	
}
