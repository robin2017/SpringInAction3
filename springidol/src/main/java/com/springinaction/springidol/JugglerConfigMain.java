package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by robin on 2017/7/25.
 */
public class JugglerConfigMain {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(SpringIdolConfig.class);
        Performer performer=applicationContext.getBean(Performer.class);
        performer.perform();
    }
}
