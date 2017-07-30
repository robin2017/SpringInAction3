package com.robin.xml.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by robin on 2017/7/27.
 */
public class Client {
    public static void main(String[] args){

        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("hero_poet.xml");
        Hero hero=(Hero)applicationContext.getBean("hero");
        hero.saveBeauty();
        hero.helpPool();
    }
}
