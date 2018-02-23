package com.springbook.view.board;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

/*@Controller*/
public class InsertBoardProcController /*implements Controller*/ {
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {*/
	@RequestMapping(value="insertBoardProc.do", method=RequestMethod.POST)
	public ModelAndView insertBoardProc(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String view = "";
		ModelAndView mav = new ModelAndView();
		System.out.println("글 등록 처리");
		String id = (String)session.getAttribute("id");
		if(id==null||"".equals(id)){
			mav.setViewName("redirect:login.do");
		}else {
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
				mav.setViewName("redirect:getBoardList.do");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return mav;
	}

}
