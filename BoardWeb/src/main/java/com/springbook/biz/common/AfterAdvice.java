package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//POJO객체
@Service
@Aspect
public class AfterAdvice {
	/*public void finallyLog() {
		System.out.println("[사후처리 로그]비즈니스 로직 수행후 무조건 동작");
	}*/
	
/*	외부 pointcut(pointcutcommon)참조를 위해 주석처리
 * @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}*/
	
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[사후처리 로그]비즈니스 로직 수행후 무조건 동작");
	}
}
