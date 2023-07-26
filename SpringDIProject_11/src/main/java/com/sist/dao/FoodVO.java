package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *   FNO         NOT NULL NUMBER         
CNO                  NUMBER         
NAME        NOT NULL VARCHAR2(100)  
SCORE                NUMBER(2,1)    
ADDRESS     NOT NULL VARCHAR2(300)  
PHONE       NOT NULL VARCHAR2(20)   
TYPE        NOT NULL VARCHAR2(30)   
PRICE                VARCHAR2(30)   
PARKING              VARCHAR2(30)   
TIME                 VARCHAR2(300)  
MENU                 CLOB        
 */
@Getter
@Setter
public class FoodVO {
  private int fno,cno;
  private String name,address,phone,type,price,parking,time,menu;
  private double score;
}
