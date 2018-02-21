package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 보기");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String view = "";
		if(id==null||"".equals(id)){
			view = "login.do";
		}else {
			//1.Board 정보 출력
			BoardDAO dao = new BoardDAO();
			BoardVO vo = new BoardVO();
			List<BoardVO> list = dao.getBoardList(vo);
			session.setAttribute("boardList", list);
			view =  "getBoardList";
		}
		return view;
	}

}
