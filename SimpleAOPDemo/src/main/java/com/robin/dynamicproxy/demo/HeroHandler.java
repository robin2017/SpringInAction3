package com.robin.dynamicproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by robin on 2017/7/30.
 */

public class HeroHandler
        implements InvocationHandler{
    private Object hero;
    private Object poet;
    public HeroHandler(Object hero,
                       Object poet){
        this.hero=hero;
        this.poet=poet;
    }
    //第一个参数没用，被成变替代了
    public Object invoke(Object proxy,
                         Method method,
                         Object[] args)
            throws Throwable {
        ((Poet)poet).openRecord();
        Object obj=method.invoke(hero,args);
        ((Poet)poet).closeRecord();
        return obj;
    }
}
