package com.robin.sf5advice.beforeadvice_xml;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/7/30.
 */
public class PoetBeforeAdvice
        implements MethodBeforeAdvice {
    private Poet poet;
    public PoetBeforeAdvice(Poet poet){
        this.poet=poet;
    }
    public void before(Method method,
                       Object[] objects,
                       Object o)
            throws Throwable {
        poet.openRecord();
    }
}
