package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        BoardDAO dao=(BoardDAO)app.getBean("dao");
        dao.aopDelete();
        dao.aopInsert();
        dao.aopSelect("홍길동");
        dao.aopUpdate();
        String name=dao.find("심청이");
	}

}
