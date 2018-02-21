package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		System.out.println("글 상세 처리");
		String id = (String)session.getAttribute("id");
		String view = "";
		if(id==null||"".equals(id)){
			view =  "login.do";
		}else {
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq)); //순번입력
			BoardDAO dao = new BoardDAO();
			vo = dao.getBoard(vo.getSeq()); //객체저장
			session.setAttribute("board", vo);
			view = "getBoard";
		}
		return view;
	}

}
