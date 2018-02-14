package com.springbook.biz.common;
//POJO객체
public class AfterAdvice {
	public void finallyLog() {
		System.out.println("[사후처리 로그]비즈니스 로직 수행후 무조건 동작");
	}
	
}
