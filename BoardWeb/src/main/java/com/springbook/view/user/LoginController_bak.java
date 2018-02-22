package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//@Controller
public class LoginController_bak /*implements Controller*/ {
	HttpSession session;
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {*/
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
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
		ModelAndView mav = new ModelAndView();
		//3.화면이동
		if(user2!=null){
			session.setAttribute("id",user.getId());
			session.setAttribute("userName", user2.getName()); //mav에 담아도 크게 차이는 없음
			mav.setViewName("redirect:getBoardList.do");
		}else{
			mav.setViewName("login");
		}
		return mav;
	}
	//모델객체(UserVO)를 다른 이름으로 저장하기위한 어노테이션 @ModelAttribute
	//@ModelAttribute는 RequestMapping보다 먼저 실행됨
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public ModelAndView loginView(@ModelAttribute("u")UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("1234");
		//mav에 셋팅 안해줘도 알아서가더라....
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
}
