package com.sist.vo;
/*
 *   ID      NOT NULL VARCHAR2(20)  
PWD     NOT NULL VARCHAR2(500) 
NAME    NOT NULL VARCHAR2(51)  
SEX              VARCHAR2(20)  
REGDATE          DATE             
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MemberVO {
   private String id,pwd,sex,name,msg;
   private Date regdate;
}
