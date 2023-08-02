package com.sist.dao;

public class BoardDAO {
   public String find(String name)
   {
	   System.out.println("Find 수행...");
	   return name;
   }
   public void aopSelect(String name)
   {
	   System.out.println(name+":SELECT 문장 수행"); // 핵심모듈 
   }
   public void aopInsert()
   {
	   System.out.println("INSERT 문장 수행");
   }
   public void aopUpdate()
   {
	   System.out.println("UPDATE 문장 수행");
   }
   public void aopDelete()
   {
	   System.out.println("DELETE 문장 수행");
   }
}
