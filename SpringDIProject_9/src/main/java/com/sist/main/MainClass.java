package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao2.*;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app2.xml");
        StudentDAO dao=app.getBean("dao",StudentDAO.class); // DL
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	System.out.println("======= 메뉴 =======");
        	System.out.println("1.학생 목록");
        	System.out.println("2.학생 상세보기");
        	System.out.println("3.학생 검색");
        	System.out.println("4.학생 추가");
        	System.out.println("5.학생 수정");
        	System.out.println("6.학생 삭제");
        	System.out.println("7.프로그램 종료");
        	System.out.println("===================");
        	System.out.print("메뉴 선택:");
        	int no=scan.nextInt();
        	switch(no)
        	{
        	case 1:
        	{
        		List<StudentVO> list=dao.studentListData();
        		if(list.size()==0)
        		{
        			System.out.println("등록된 학생이 없습니다");
        		}
        		else
        		{
        			for(StudentVO vo:list)
        			{
        				System.out.println(vo.getHakbun()+" "
        						+vo.getName()+" "
        						+vo.getKor()+" "
        						+vo.getEng()+" "
        						+vo.getMath());
        			}
        		}
        	}
        		break;
        	case 2:
        	{
        		System.out.print("상세 볼 학번 입력:");
        		int hakbun=scan.nextInt();
        		StudentVO vo=dao.studentDetailData(hakbun);
        		System.out.println("학번:"+vo.getHakbun());
        		System.out.println("이름:"+vo.getName());
        		System.out.println("국어:"+vo.getKor());
        		System.out.println("영어:"+vo.getEng());
        		System.out.println("수학:"+vo.getMath());
        		System.out.println("총점:"+(vo.getKor()+vo.getEng()+vo.getMath()));
        		System.out.printf("평균:%.2f\n",(vo.getKor()+vo.getEng()+vo.getMath())/3.0);
        	}
        		break;
        	case 3:
        	{
        		System.out.print("검색어 입력:");
        		String name=scan.next();
        		List<StudentVO> list=dao.studentFindData(name);
        		if(list.size()==0)
        		{
        			System.out.println("검색된 학생이 없습니다");
        		}
        		else
        		{
        			for(StudentVO vo:list)
        			{
        				System.out.println(vo.getHakbun()+" "
        						+vo.getName()+" "
        						+vo.getKor()+" "
        						+vo.getEng()+" "
        						+vo.getMath());
        			}
        		}
        	}
        		break;
        	case 4:
        	{
        		System.out.print("이름 입력:");
        		String name=scan.next();
        		System.out.print("국어 입력:");
        		int kor=scan.nextInt();
        		System.out.print("영어 입력:");
        		int eng=scan.nextInt();
        		System.out.print("수학 입력:");
        		int math=scan.nextInt();
        		
        		StudentVO vo=new StudentVO();
        		vo.setName(name);
        		vo.setKor(kor);
        		vo.setMath(math);
        		vo.setEng(eng);
        		
        		dao.studentInsert(vo);
        		System.out.println("등록 완료");
        	}
        		break;
        	case 5:
        	{
        		System.out.print("이름 입력:");
        		String name=scan.next();
        		System.out.print("국어 입력:");
        		int kor=scan.nextInt();
        		System.out.print("영어 입력:");
        		int eng=scan.nextInt();
        		System.out.print("수학 입력:");
        		int math=scan.nextInt();
        		System.out.print("학번 입력:");
        		int hakbun=scan.nextInt();
        		
        		StudentVO vo=new StudentVO();
        		vo.setName(name);
        		vo.setKor(kor);
        		vo.setMath(math);
        		vo.setEng(eng);
        		vo.setHakbun(hakbun);
        		
        		dao.studentUpdate(vo);
        		System.out.println("수정 완료");
        	}
        		break;
        	case 6:
        	{
        		System.out.print("삭제할 학번 입력:");
        		int hakbun=scan.nextInt();
        		dao.studentDelete(hakbun);
        		System.out.println("삭제 완료");
        	}
        		break;
        	case 7:
        		System.exit(0);
        	}
        }
        
	}

}
