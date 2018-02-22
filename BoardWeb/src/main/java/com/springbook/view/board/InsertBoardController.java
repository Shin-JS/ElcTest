package com.springbook.view.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class InsertBoardController /*implements Controller*/ {
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {*/
	
	@RequestMapping(value="insertBoard.do")
	public ModelAndView insertBoard(HttpServletRequest request) {
		System.out.println("글 등록 처리");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ModelAndView mav = new ModelAndView();
		
		String view = "";
		if(id==null||"".equals(id)){
			mav.setViewName("redirect:login.do");
		}else {
			mav.setViewName("insertBoard");
		}
		return mav;
		
	}

}
