package com.springbook.view.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.view.controller.Controller;

public class InsertBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String view = "";
		if(id==null||"".equals(id)){
			view =  "login.do";
		}else {
			view = "insertBoard";
		}
		return view;
	}

}
