package com.sist.vo;
/*
 *  NO      NOT NULL NUMBER       
FNO              NUMBER       
ID               VARCHAR2(20) 
NAME    NOT NULL VARCHAR2(51) 
MSG     NOT NULL CLOB         
REGDATE          DATE  
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReplyVO {
  private int no,fno;
  private String id,name,msg,dbday;
  private Date regdate;
}
