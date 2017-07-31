package com.robin.annocation.beforeafteraround;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by robin on 2017/7/27.
 */

@Aspect
public class Poet {

    @Pointcut("execution(* com.robin.annocation.beforeafteraround.Hero.saveBeauty(..)) ||" +
            " execution(* com.robin.annocation.beforeafteraround.Hero.helpPool(..))")
    public void doGoodPointcut(){}

    @Before("doGoodPointcut()")
    public void openRecord(){
        System.out.println("打开日记本来记录你的善行");
    }

    @AfterReturning("doGoodPointcut()")
    public void closeRecord(){
        System.out.println("英雄，你将名垂青史了");
    }

    @Around("doGoodPointcut()")
    public void record(ProceedingJoinPoint joinPoint){
        System.out.println("打开日记本来记录你的善行");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("英雄，你将名垂青史了");
    }
}
