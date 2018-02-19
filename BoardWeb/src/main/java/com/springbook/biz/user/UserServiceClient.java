package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		//1.Spring 컨테이너 구동
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("annotationContext.xml");
		//2.Spring컨테이너로부터 UserServiceImpl객체 lookup
		UserService us = (UserService) ctx.getBean("userService");
		
		//3. 로그인 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("1234");
		
		UserVO user = us.getUser(vo);
		if(user!=null) {
			System.out.println(user.getName()+"님 환영합니다.");
			System.out.println(user);
		}else {
			System.out.println("누구냐 넌?");
		}
		
		//4. 사용자 추가 테스트
		vo.setId("ddochi");
		vo.setPassword("duly");
		vo.setName("또치");
		vo.setRole("guest");
		user = us.setUser(vo);
		System.out.println(user);
		
		//4.Spring 컨테이너 종료
		ctx.close();
	}
}
