package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by robin on 2017/7/26.
 */
public class InstrumentMain {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("spring-idol-around.xml");
        Performer performer=(Performer)applicationContext.getBean("eddie");
        performer.perform();
    }
}
