package com.springbook.view.board;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController /*implements Controller*/ {
	
/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {*/
	@RequestMapping(value="/deleteBoard.do") //getMethod가 기본(method=RequestMethod.GET)
	public ModelAndView deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		ModelAndView mav = new ModelAndView();
		System.out.println("글 삭제 처리");
		String id = (String)session.getAttribute("id");
		if(id==null||"".equals(id)){
			mav.setViewName("redirect:login.do");
		}else {
			String seq = request.getParameter("seq");
			int result = -1;
			BoardDAO dao = new BoardDAO();
			result = dao.deleteBoard(Integer.parseInt(seq));
			PrintWriter out;
			try {
				out = response.getWriter();
				if(result>0){
					mav.setViewName("redirect:getBoardList.do");
				}else{
					out.print("<script>");
					out.print("alert('삭제 실패!');");
					out.print("history.back();");
					out.print("</script>");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return mav;
	}

}
