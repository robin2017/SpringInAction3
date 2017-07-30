package com.robin.sf5advice.beforeadvice_java;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/7/30.
 */
public class PoetAfterAdvice
        implements AfterReturningAdvice {
    private Poet poet;
    PoetAfterAdvice(Poet poet){
        this.poet=poet;
    }
    public void afterReturning(Object o,
                               Method method,
                               Object[] objects,
                               Object o1) throws Throwable {
        poet.closeRecord();
    }
}
