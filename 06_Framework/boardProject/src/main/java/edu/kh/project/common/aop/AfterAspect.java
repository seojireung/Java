package edu.kh.project.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {
	
	private Logger logger = LoggerFactory.getLogger(AfterAspect.class);
	
	@Order(3) // 순서, 하나의 타겟에 대한 여러 advice 수행 시 순서 지정
	@After("CommonPointcut.serviceImplPointcut()") 
	public void afterLog() {
		logger.info("------------------------------------------\n\n");
	}

}
