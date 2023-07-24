package com.sist.main3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
  private int habun;
  private String name;
  private int kor,eng,math;
  
  public void print()
  {
	  System.out.println("학번:"+habun);
	  System.out.println("이름:"+name);
	  System.out.println("국어:"+kor);
	  System.out.println("영어:"+eng);
	  System.out.println("수학:"+math);
	  System.out.println("총점:"+(kor+eng+math));
	  System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0);
  }
}
