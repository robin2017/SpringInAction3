package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by robin on 2017/7/22.
 */
public class JugglerMain {
    public static void main(String[] args) throws PerformanceException {
        int a= (int) Math.random();

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-juggler_auto.xml");
        //PoeticJuggler juggler=(PoeticJuggler)applicationContext.getBean("poeticDuke");
//        Stage stage=(Stage)applicationContext.getBean("theStage");
//        Auditorium auditorium=(Auditorium)applicationContext.getBean("auditorium");

        Performer performer=(Performer)applicationContext.getBean("kenny2");
        performer.perform();


//        Collection<City> collection=(Collection)applicationContext.getBean("cities");
//        for(City city:collection){
//            System.out.println(city.getPopulation());
//        }
//
//        Person person=(Person)applicationContext.getBean("person");
//        System.out.println(person.getName());
//        System.out.println(person.getCity().getName());
//       // juggler.perform();
//
//        BigCity bigCity=(BigCity)applicationContext.getBean("bigcity");
//        for(String city:bigCity.getCityName()){
//            System.out.println(city);
//        }

    }
}
