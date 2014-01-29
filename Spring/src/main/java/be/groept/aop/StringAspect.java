package be.groept.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StringAspect {

	@Pointcut(value = "execution(* org.apache.commons.lang.StringUtils.upperCase(..))")
	public void containsWhitespace() {
	}

	@Around(value = "containsWhitespace()")
	public Object logger(ProceedingJoinPoint pjp) throws Throwable {
		return pjp.getArgs()[0];
		// return pjp.proceed();
	}

	public int getOrder() {
		return 1;
	}
}
