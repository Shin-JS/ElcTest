package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//POJO객체
@Service
@Aspect
public class AroundAdvice {
/*	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE]: 비즈니스 메소드 수행 전 처리할 내용");
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER]: 비즈니스 메소드 수행 후 처리할 내용");
		return returnObj;
	}*/
	//advice가 적용되는 지점(method)
/*	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}*/
	
	/*@Around("allPointcut()")*//*around Advice가 메소드를 간접 실행시키기 위해 ProceedingJoinPoint를 매개변수로 받고 매개변수로 받은 
							ProceedingJoinPoint의 proceed()메소드로 간접 실행*/
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		String method = pjp.getSignature().getName();
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.stop();
		System.out.println("[Around Advice]"+method + "() 메소드 수행에 걸린 시간: " + stopWatch.getTotalTimeMillis() + "ms");
		return returnObj;
	}
}
