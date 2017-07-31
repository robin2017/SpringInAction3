package com.robin.annocation.passargument;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by robin on 2017/7/27.
 */
public class Client {
    public static void main(String[] args){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("sneaky-magician-annocation.xml");
        Thinker thinker=(Thinker)applicationContext.getBean("volunteer");
        MindReader mindReader=(MindReader)applicationContext.getBean("magician");
        thinker.thinkOfSomething("我要下台去");
        System.out.println(mindReader.getThoughts());
    }
}
