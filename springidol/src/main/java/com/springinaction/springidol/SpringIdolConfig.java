package com.springinaction.springidol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdolConfig {
  @Bean
  public Instrument saxophone(){
    return new Saxophone();
  }
  @Bean
  public Performer kenny() {
    Instrumentalist kenny = new Instrumentalist();
    kenny.setSong("Jingle Bells");
    kenny.setInstrument(saxophone());
    return kenny;
  }
}
