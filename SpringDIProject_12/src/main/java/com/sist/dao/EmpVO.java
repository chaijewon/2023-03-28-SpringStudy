package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
  private int empno,sal,comm,deptno;
  private String ename,job;
  private Date hiredate;
}
