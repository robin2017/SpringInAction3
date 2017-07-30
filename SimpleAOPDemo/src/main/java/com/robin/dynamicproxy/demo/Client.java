package com.robin.dynamicproxy.demo;

import java.lang.reflect.Proxy;

/**
 * Created by robin on 2017/7/30.
 */
public class Client {
    public static void main(String[] args){

        HeroInterface hero=(HeroInterface) Proxy.newProxyInstance(
                HeroInterface.class.getClassLoader(),
                new Class[]{HeroInterface.class},
                new HeroHandler(new Hero(),new Poet()));
        hero.helpPool();
        hero.saveBeauty();

    }
}
