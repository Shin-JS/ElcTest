package com.springbook.view.board;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class DeleteBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		System.out.println("글 삭제 처리");
		String seq = request.getParameter("seq");
		int result = -1;
		BoardDAO dao = new BoardDAO();
		result = dao.deleteBoard(Integer.parseInt(seq));
		PrintWriter out;
		try {
			out = response.getWriter();
			if(result>0){
				view = "getBoardList.do";
			}else{
				out.print("<script>");
				out.print("alert('삭제 실패!');");
				out.print("history.back();");
				out.print("</script>");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return view;
	}

}
