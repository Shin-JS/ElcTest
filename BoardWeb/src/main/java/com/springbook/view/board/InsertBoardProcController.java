package com.springbook.view.board;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class InsertBoardProcController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		System.out.println("글 등록 처리");
		try {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(vo);
			view = "getBoardList.do";
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		return view;
	}

}
