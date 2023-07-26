package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component("mc")
public class MainClass {
	@Autowired   // 스프링에서 자동으로 객체 주소값을 찾아서 주입 
	@Qualifier("fdao") // 해당 객체를 지정할때 사용 
    private Board board;
	@Autowired
	private FreeBoardDAO f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
	}

}
