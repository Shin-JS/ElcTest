package com.springbook.view.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//Controller클래스의 메소드들을 하나로 통합 후 Component Annotation을 주석처리하여 원래의 POJO 클래스로 변환처리함 
//@Controller
public class BoardController_bak {
	//글 등록
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
	
	//글 수정
	@RequestMapping(value="/updateBoard.do")
	public ModelAndView updateBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		String view = "";
		String id = (String)session.getAttribute("id");
		if(id==null||"".equals(id)){
			mav.setViewName("redirect:login.do");
		}else {
			System.out.println("글 수정 처리");
			try {
				request.setCharacterEncoding("utf-8");
				//1. 파라미터 받기
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String seq = request.getParameter("seq");
				
				//2. DB연동처리
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setSeq(Integer.parseInt(seq));
				
				BoardDAO dao = new BoardDAO();
				dao.updateBoard(vo);
				view = "getBoardList.do";
				mav.setViewName("redirect:getBoardList.do");
			} catch (UnsupportedEncodingException e) {
				System.out.println(e.getMessage());
			}
		}
		//3. 화면 이동
		return mav;
	}
	
	//글 삭제
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
	
	//글 상세조회
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("글 상세 처리");
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("id");
		if(id==null||"".equals(id)){
			mav.setViewName("redirect:login.do");
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
	
	//글 목록 검색
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
