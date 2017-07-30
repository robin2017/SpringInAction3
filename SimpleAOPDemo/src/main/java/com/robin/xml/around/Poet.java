package com.robin.xml.around;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by robin on 2017/7/27.
 */

public class Poet {
    public void openRecord(){
        System.out.println("打开日记本来记录你的善行");
    }
    public void closeRecord(){
        System.out.println("英雄，你将名垂青史了");
    }

    public void record(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("打开日记本来记录你的善行");
        joinPoint.proceed();
        System.out.println("英雄，你将名垂青史了");
    }
}
