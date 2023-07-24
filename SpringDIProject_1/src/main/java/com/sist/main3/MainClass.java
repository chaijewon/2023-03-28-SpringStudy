package com.sist.main3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app3.xml");
        Student std=(Student)app.getBean("std");
        std.print();
	}

}
