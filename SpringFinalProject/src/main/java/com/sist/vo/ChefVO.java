package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  CHEF      NOT NULL VARCHAR2(500) 
POSTER    NOT NULL VARCHAR2(260) 
MEM_CONT1          VARCHAR2(100) 
MEM_CONT2          VARCHAR2(100) 
MEM_CONT3          VARCHAR2(100) 
MEM_CONT4          VARCHAR2(100) 

 */
@Getter
@Setter
public class ChefVO {
   private String chef,poster,mem_cont1,mem_cont2,mem_cont3,mem_cont4;
}
