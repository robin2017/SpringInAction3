package com.robin.other;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAdvice1 {
    public static void main(String[] args) {
        String configPath = "wait-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        System.out.println(waiter.getClass().getName());
        waiter.greetTo("John");
    }
}