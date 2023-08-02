package com.sist.aop;
/*
 *    언제 어디서 호출할지 여부 확인 
 *    1. 시점  => pointcut => 메소드
 *    2. 호출위치 => joinpoint
 *       @Before  : try시작전에 호출 
 *       @After : finally 
 *       @Around : 위 아래 => 로그파일 (시작 , 끝 시간에 체크) , 트랜잭션 처리 
 *       @After-Throwing : catch(오류발생)
 *       @After-Returning : 정상 수행 
 *       -----------------------------
 *       @Transactional
 *       public String display()
 *       {
 *           try
 *           {
 *               @Before
 *               ------------------------- @Around => conn.setAutoCommit(false)
 *               --- 핵심 코딩 (INSERT)
 *               ------------------------- conn.commit()
 *           }catch(Exception ex)
 *           {
 *               @After-Throwing conn.rollback()
 *           }
 *           finally
 *           {
 *              @After  conn,setAutoCommit(true)
 *           }
 *           
 *           return ""; @After-Returning
 *       }
 *    ----------------------- advice
 *    
 *    ----------------------- aspect
 *    
 *    
 */
public class BoardAspect {
   public void before() // 문장 수행전에 호출 
   {
	  System.out.println("오라클 연결!!");   
   }
   public void after() // 문장 수행이 종료 => finally
   {
	   System.out.println("오라클 해제!!");
   }
}
