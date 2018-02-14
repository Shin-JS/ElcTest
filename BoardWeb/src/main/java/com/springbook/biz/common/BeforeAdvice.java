package com.springbook.biz.common;
//POJO객체
public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[사전 처리 로그]비즈니스 로직 수행전 동작");
	}
	
}
