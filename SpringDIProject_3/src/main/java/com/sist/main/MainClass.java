package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
public class MainClass {
	@Setter
    private GoodsDAO dao;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        List<String> list=mc.dao.goodsNameList();
        for(String name:list)
        {
        	System.out.println(name);
        }
	}

}
