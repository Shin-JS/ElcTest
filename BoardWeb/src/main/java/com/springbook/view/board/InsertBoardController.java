package com.springbook.view.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class InsertBoardController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("id");
		String view = "";
		if(id==null||"".equals(id)){
			mav.setViewName("login.do");
		}else {
			mav.setViewName("insertBoard");
		}
		return mav;
	}

}
