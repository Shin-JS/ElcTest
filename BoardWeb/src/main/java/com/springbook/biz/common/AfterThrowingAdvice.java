package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//POJO객체
@Service
@Aspect
public class AfterThrowingAdvice {
	/*public void exceptionLog() {
		System.out.println("[예외 처리]비즈니스 로직 수행중 예외 발생시 동작");
	}*/
/*	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}*/
	//실행메소드 정보를 얻기위한 객체 JoinPoint객체, 예외정보를 얻기위한 예외객체
	//throws Exception으로 예외가 넘어왔을때 처리
	/*@AfterThrowing(pointcut="allPointcut()",throwing="exceptObj")*/
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()",throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println(method+"() 메소드 수행 중 예외발생");
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적절한 값 입력");
		}
	}
	
}
