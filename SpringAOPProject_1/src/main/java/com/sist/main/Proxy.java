package com.sist.main;

public class Proxy {
  private Sawon sawon;
  public Proxy(Sawon sawon)
  {
	  this.sawon=sawon;
  }
  public void display()
  {
	  System.out.println("Before : 먼저처리");
	  sawon.display();
	  System.out.println("After : 나중처리");
  }
}
