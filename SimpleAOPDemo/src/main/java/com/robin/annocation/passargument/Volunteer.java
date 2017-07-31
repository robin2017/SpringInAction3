package com.robin.annocation.passargument;

public class Volunteer implements Thinker {
  private String thoughts;

  public void thinkOfSomething(String thoughts) {
    System.out.println("志愿者开始思考 :"+thoughts);
    this.thoughts = thoughts;
  }
}