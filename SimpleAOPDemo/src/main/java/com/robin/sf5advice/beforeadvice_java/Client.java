package com.robin.sf5advice.beforeadvice_java;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by robin on 2017/7/30.
 */
public class Client {
    public static void main(String[] args){
        //建立代理工厂
        ProxyFactory proxyFactory=new ProxyFactory();
        //代理工厂中添加目标类和切面类
        proxyFactory.setTarget(new Hero());
        proxyFactory.addAdvice(new PoetBeforeAdvice(new Poet()));
        proxyFactory.addAdvice(new PoetAfterAdvice(new Poet()));
        proxyFactory.addAdvice(new PoetAroundAdvice(new Poet()));

        //运行
        Hero hero=(Hero)proxyFactory.getProxy();
        hero.helpPool();
        hero.saveBeauty();
    }
}
