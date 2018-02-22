package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController /*implements Controller*/ {
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {*/
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(HttpServletRequest request) {
		System.out.println("글 목록 보기");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String view = "";
		if(id==null||"".equals(id)){
			mav.setViewName("redirect:login.do");
			
		}else {
			//1.Board 정보 출력
			BoardDAO dao = new BoardDAO();
			BoardVO vo = new BoardVO();
			List<BoardVO> list = dao.getBoardList(vo);
			mav.addObject("boardList",list);
			mav.setViewName("getBoardList");
		}
		return mav;
	}

}
