package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *   CNO     NOT NULL NUMBER(2)     
	TITLE   NOT NULL VARCHAR2(100) 
	SUBJECT NOT NULL VARCHAR2(200) 
	POSTER  NOT NULL VARCHAR2(260)
 */
@Getter
@Setter
public class CategoryVO {
   private int cno;
   private String title,subject;
}
