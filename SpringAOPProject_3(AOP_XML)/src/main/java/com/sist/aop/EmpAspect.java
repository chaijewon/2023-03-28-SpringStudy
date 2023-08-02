package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 *   1. Before 
 *   2. After 
 *   ------------
 *   3. Around
 *   4. After-Returning
 *   5. After-Throwing
 *   
 */
import java.util.*;
import com.sist.dao.*;
public class EmpAspect {
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   System.out.println("Around Call.. try시작 , try종료");
	   /*
	    *    try
	    *    {
	    *       ----------------- 여기서 처리
	    *       핵심 코딩 
	    *       ----------------- 여기서 처리
	    *    }
	    */
	   Object obj=null;
	   long start=0,end=0;
	   start=System.currentTimeMillis();// 시작점 
	   System.out.println("사용자가 호출한 메소드명:"+jp.getSignature().getName());
	   obj=jp.proceed(); // 메소드 호출 => invoke()
	   end=System.currentTimeMillis();// 종료점 
	   System.out.println("수행시간:"+(end-start));
	   return obj;
   }
   // 정상 수행시에 리턴값을 받아서 처리 
   public void afterReturning(Object obj) throws Throwable
   {
	   System.out.println("afterReturning Call.. 정상수행");
	   List<EmpVO> list=(List<EmpVO>)obj;
	   for(EmpVO vo:list)
	   {
		   System.out.println(vo.getEmpno()+" "
				   +vo.getEname()+" "
				   +vo.getJob()+" "
				   +vo.getDbday()+" "
				   +vo.getSal());
	   }
   }
   // catch절 수행시 
   public void afterThrowing(Throwable ex) throws Throwable
   {
	   System.out.println("afterThrowing Call...");
	   ex.printStackTrace();
   }
}
