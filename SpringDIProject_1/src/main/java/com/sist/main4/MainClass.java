package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 *    ApplicationContext 
 *    AnnotationConfigApplicationContext ==> 5
 */
public class MainClass {
    private Sawon sa;
    
	public Sawon getSa() {
		return sa;
	}

	public void setSa(Sawon sa) {
		this.sa = sa;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //ApplicationContext app=
        		//new ClassPathXmlApplicationContext("app4.xml");
		GenericXmlApplicationContext app=
				new GenericXmlApplicationContext("app4.xml");
        /*Sawon sa=(Sawon)app.getBean("sa1");
        // sa.init()
        sa.print();
        // sa.destroy() (X)
        app.close();*/
	}

}
