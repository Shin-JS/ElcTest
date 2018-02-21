package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


public class GetBoardController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		System.out.println("글 상세 처리");
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("id");
		String view = "";
		if(id==null||"".equals(id)){
			mav.setViewName("login.do");
		}else {
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq)); //순번입력
			BoardDAO dao = new BoardDAO();
			vo = dao.getBoard(vo.getSeq()); //객체저장
			
			session.setAttribute("board", vo);
			mav.addObject("board", vo);
			mav.setViewName("getBoard");
		}
		return mav;
	}

}
