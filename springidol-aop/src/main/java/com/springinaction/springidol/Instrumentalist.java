package com.springinaction.springidol;

public class Instrumentalist implements Performer {
  private Instrument instrument;
  public Instrument getInstrument() {
    return instrument;
  }
  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }
  public void perform() throws PerformanceException {
    instrument.play();
  }
  public void introduce(){
    System.out.println("hello ,everybody,my name is robin");
  }
}
