package com.sist.main2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
  private String id,name,sex;
  public void init()
  {
	  System.out.println("====== 회원 정보 =====");
  }
  public void print()
  {
	  System.out.println("ID:"+id);
	  System.out.println("이름:"+name);
	  System.out.println("성별:"+sex);
  }
}
