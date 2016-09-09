package edu.sample;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.ClassUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Slf4j
public class LoggingAspect {
	
	@Around("execution(* *..service.*Service.*(..))")
    public Object logDuration(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = null;
		String methodName = null;
		Object object;
		long duration;
		
		duration = System.currentTimeMillis();
		object = joinPoint.proceed();
		duration = System.currentTimeMillis() - duration;
        className = ClassUtils.getShortClassName(joinPoint.getTarget().getClass().getName());
        methodName = MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName();
        
        log.info("[logDuration: className, methodName, duration]={},{},{}", className, methodName, duration);        
        
        return object;
    }
}
