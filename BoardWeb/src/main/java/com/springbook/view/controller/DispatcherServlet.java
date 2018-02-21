package com.springbook.view.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	//DispatcherServlet 수정
	private HandleMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandleMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.클라이언트 요청 uri
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2.HandlerMapping에서 path 추출하여 해당 controller 검색
		Controller ctrl = handlerMapping.getController(path);
		
		//3. 검색된 controler 실행
		String viewName = ctrl.handleRequest(request, response);
		
		//4.viewResolver에 의한 화면 이동
		String view = null;
		if(!viewName.contains(".do")) {
			view  = viewResolver.getView(viewName);
		}else {
			view = viewName;
		}
		
		//5.이동
		response.sendRedirect(view);
		
	/*	//분기처리
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			//1. 사용자 정보
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB처리
			UserVO user = new UserVO();
			user.setId(id);
			user.setPassword(password);
			UserDAO dao = new UserDAO();
			UserVO user2 = dao.getUser(user);
			session = request.getSession();
			//3.화면이동
			if(user2!=null){
				session.setAttribute("id",user.getId());
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			//세션종료 처리
			session.invalidate();
			//로그인 화면으로 이동
			response.sendRedirect("login.do");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 폼 출력");
			response.sendRedirect("insertBoard.jsp");
		}else if(path.equals("/insertBoardProc.do")) {
			System.out.println("글 등록 처리");
			
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
			
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
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
			
			//3. 화면 이동
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			String seq = request.getParameter("seq");
			int result = -1;
			BoardDAO dao = new BoardDAO();
			result = dao.deleteBoard(Integer.parseInt(seq));
			PrintWriter out = response.getWriter();
			if(result>0){
				response.sendRedirect("getBoardList.do");
			}else{
				out.print("<script>");
				out.print("alert('삭제 실패!');");
				out.print("history.back();");
				out.print("</script>");
			}
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 처리");
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq)); //순번입력
			BoardDAO dao = new BoardDAO();
			vo = dao.getBoard(vo.getSeq()); //객체저장
			session.setAttribute("board", vo);
			response.sendRedirect("getBoard.jsp");
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 보기");
			String id = (String)session.getAttribute("id");
			if(id==null||"".equals(id)){
				response.sendRedirect("login.jsp");
			}
			//1.Board 정보 출력
			BoardDAO dao = new BoardDAO();
			BoardVO vo = new BoardVO();
			List<BoardVO> list = dao.getBoardList(vo);
			session.setAttribute("boardList", list);
			response.sendRedirect("getBoardList.jsp");
		}*/
	}
}
