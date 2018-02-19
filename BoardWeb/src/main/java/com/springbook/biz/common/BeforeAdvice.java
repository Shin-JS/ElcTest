package com.springbook.biz.common;
//POJO객체

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class BeforeAdvice {
/*	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}*/
	/*@Before("allPointcut()")*/
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) { //실행메소드 정보얻기위한 객체: JoinPoint객체
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[BeforeAdvice 사전처리]" + method + "() 메소드 ARGS정보: " + args[0].toString());
	}
	
}
