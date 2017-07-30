package com.robin.sf5advice.beforeadvice_java;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by robin on 2017/7/30.
 */
public class PoetAroundAdvice
        implements MethodInterceptor {
    private Poet poet;
    public PoetAroundAdvice(Poet poet){
        this.poet=poet;
    }
    public Object invoke(MethodInvocation methodInvocation)
            throws Throwable {
        poet.openRecord();
        Object object=methodInvocation.proceed();
        poet.closeRecord();
        return object;
    }
}
