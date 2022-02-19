package com.example.library.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("local")
public class LoggingAspect {

    @Pointcut("this(org.springframework.data.repository.Repository)")
    public void jpaMethods() {}

    @Around("jpaMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Ex. time of " + pjp.getSignature().getName() + " = " + (endTime - start) + "ms");
        return proceed;
    }
}
