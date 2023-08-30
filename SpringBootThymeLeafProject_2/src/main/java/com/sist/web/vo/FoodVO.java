package com.sist.web.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  FNO int 
	NAME text 
	SCORE double 
	ADDRESS text 
	TEL text 
	TYPE text 
	PRICE text 
	TIME text 
	PARKING text 
	MENU text 
	HIT int 
	POSTER text
 */
@Getter
@Setter
public class FoodVO {
   private int fno,hit;
   private double score;
   private String name,address,tel,type,price,time,parking,menu,poster;
}
