package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//POJO객체
@Service
@Aspect
public class AfterReturningAdvice {
	/*public void afterLog() {
		System.out.println("[사후 처리]비즈니스 로직 수행 후 동작");
	}*/
/*	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {}*/
	//실행되는 메소드 정보와 메소드 실행후의 결과 객체를 받기위한 매개변수 설정
	/*@AfterReturning(pointcut="getPointcut()", returning="returnObj")*/
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후처리]" + method + "() 메소드 리턴값: " + returnObj.toString());
	}
}
