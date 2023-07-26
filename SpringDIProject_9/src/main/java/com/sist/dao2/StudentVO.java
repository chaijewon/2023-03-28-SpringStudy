package com.sist.dao2;

import lombok.Getter;
import lombok.Setter;

/*
 *   HAKBUN NOT NULL NUMBER       
	NAME   NOT NULL VARCHAR2(51) 
	KOR             NUMBER       
	ENG             NUMBER       
	MATH            NUMBER
 */
@Getter
@Setter
public class StudentVO {
  private int hakbun,kor,eng,math;
  private String name;
}
