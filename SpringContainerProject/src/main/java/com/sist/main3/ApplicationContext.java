package com.sist.main3;
import java.util.*;
public class ApplicationContext {
   private Map map=new HashMap(); // 클래스 관리 
   public ApplicationContext()
   {
	   map.put("a", new A());
	   map.put("b", new B());
	   map.put("c", new C());
	   map.put("d", new D());
   }
   // 클래스 여러개를 묶어서 관리 => 컨테이너 / Factory Pattern
   // 객체 찾기 
   public Object getBean(String key)
   {
	   return map.get(key);
   }
   /*
    *   Spring => 클래스 관리 (컨테이너) 
    *   ---------------------------
    *    1. 객체의 생명주기 관리 (생성 ~ 소멸)
    *    2. 객체 찾기 (getBean())
    *    3. DL / DI 
    *       D Lookup => 객체 찾기
    *       D Injection => 주입 
    *         setter DI 
    *         constructor
    *         method 
    */
}
