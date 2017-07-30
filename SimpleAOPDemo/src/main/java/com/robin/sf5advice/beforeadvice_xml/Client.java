package com.robin.sf5advice.beforeadvice_xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by robin on 2017/7/30.
 */
public class Client {
    public static void main(String[] args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("before_advice.xml");
        //这里是面向接口编程
        HeroInterface hero=(HeroInterface)applicationContext.getBean("hero");

        hero.helpPool();
        hero.saveBeauty();
    }
}
