package com.sist.main2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
   private int hakbun;
   private String name,sex;
   
   public void init()
   {
 	  System.out.println("====== 학생 정보 =====");
   }
   public void print()
   {
 	  System.out.println("학번:"+hakbun);
 	  System.out.println("이름:"+name);
 	  System.out.println("성별:"+sex);
   }
}
