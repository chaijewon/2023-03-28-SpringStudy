package com.sist.main2;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.EmpConfig;
import com.sist.dao2.*;
import com.sist.vo.*;
@Component("mc") //default id생성 => mainClass
public class MainClass {
	@Autowired
    private EmpDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*ApplicationContext app=
        		new ClassPathXmlApplicationContext("app2.xml");*/
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(EmpConfig.class);
        MainClass mc=(MainClass)app.getBean("mc");
        List<EmpVO> list=mc.dao.empdeptListData();
		for(EmpVO vo:list)
		{
			System.out.println(
			    vo.getEmpno()+" "
			  + vo.getEname()+" "
			  + vo.getJob()+" "
			  + vo.getDbday()+" "
			  + vo.getSal()+" "
			  + vo.getDvo().getDname()+" "
			  + vo.getDvo().getLoc()
			);
		}
		System.out.println("===================================");
		Scanner scan=new Scanner(System.in);
		System.out.print("사번 입력:");
		int empno=scan.nextInt();
		EmpVO vo=mc.dao.empdeptDetailData(empno);
		System.out.println("사번:"+vo.getEmpno());
		System.out.println("이름:"+vo.getEname());
		System.out.println("직위:"+vo.getJob());
		System.out.println("입사일:"+vo.getDbday());
		System.out.println("급여:"+vo.getSal());
		System.out.println("부서명:"+vo.getDvo().getDname());
		System.out.println("근무지:"+vo.getDvo().getLoc());
	}

}
