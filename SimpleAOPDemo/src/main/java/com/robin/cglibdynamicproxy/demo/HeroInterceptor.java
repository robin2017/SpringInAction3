package com.robin.cglibdynamicproxy.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by robin on 2017/7/30.
 */

public class HeroInterceptor
        implements MethodInterceptor{
    private Object poet;
    public HeroInterceptor(Object poet){
        this.poet=poet;
    }
    private Enhancer enhancer=new Enhancer();
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o,
                            Method method,
                            Object[] objects,
                            MethodProxy methodProxy)
            throws Throwable {
        ((Poet)poet).openRecord();
        Object obj=methodProxy.invokeSuper(o, objects);
        ((Poet)poet).closeRecord();
        return obj;
    }
}
