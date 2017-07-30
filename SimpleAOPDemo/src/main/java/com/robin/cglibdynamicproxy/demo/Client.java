package com.robin.cglibdynamicproxy.demo;

/**
 * Created by robin on 2017/7/30.
 */
public class Client {
    public static void main(String[] args){

        Hero hero=(Hero)(new HeroInterceptor(new Poet())).getProxy(Hero.class);
        hero.helpPool();
        hero.saveBeauty();
    }
}
