package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
 *    a b c 
 *    => setA()
 *    aa bb cc  
 *    
 *    SELECT a as aa , b as bb , c as cc
 *    
 *    함수 => as 
 */
@Getter
@Setter
public class EmpVO {
  private int empno,sal,deptno,comm;
  private String ename,job,dbday,dbsal;
  private Date hiredate;
}
