package com.sist.main;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
// 데이터형 (사용자 정의) => 직접 사용 
/*
 *   스프링이 관리 
 *   => 컴포넌트 (기능) : DAO , Model , Manager , Service ....
 *   -------------------------------------------------------
 *   => VO,DTO,Bean => 컴포넌트가 아니라 사용자 정의 데이터형 
 *      ----------- 읽기 / 쓰기 
 */
public class EmpVO {
  private int empno,mgr,sal,deptno,comm;
  private String ename,job;
  private Date hiredate;
}
