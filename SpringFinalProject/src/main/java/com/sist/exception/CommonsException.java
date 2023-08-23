package com.sist.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// 공통 예외처리 => Controller
@ControllerAdvice
public class CommonsException {
   @ExceptionHandler(RuntimeException.class)
   public void runtimeException(RuntimeException ex)
   {
	   System.out.println("========= RuntimeException 발생 =======");
	   ex.printStackTrace();
	   System.out.println("======================================");
   }
   // IOException , SqlException , Exception 
}
