package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app.xml");
        /*SeoulDAO dao=(SeoulDAO)app.getBean("dao");
        
        int curpage=1;
        Scanner scan=new Scanner(System.in);
        System.out.print("페이지 입력:");
        curpage=scan.nextInt();
        
        Map map=new HashMap();
        int rowSize=10;
        int start=(rowSize*curpage)-(rowSize-1);
        int end=rowSize*curpage;
        map.put("start", start);
        map.put("end", end);
        List<SeoulLocationVO> list=dao.seoulListData(map);
        System.out.println("=====       서울 명소        =====");
        for(SeoulLocationVO vo:list)
        {
        	System.out.println(vo.getNo()+"."+vo.getTitle());
        }
        System.out.println("===============================");
        int totalpage=dao.seoulTotalPage();
        System.out.println("   "+curpage+" page / "+totalpage+ "pages");
        System.out.println("===============================");
        System.out.print("검색어 입력:");
        String title=scan.next();
        List<SeoulLocationVO> fList=dao.seoulFindData(title);
        System.out.println("=========== 검색 결과 ===========");
        for(SeoulLocationVO vo:fList)
        {
        	System.out.println(vo.getNo()+"."+vo.getTitle());
        }
        System.out.println("================================");
        */
        System.out.println("============ 맛집 카테고리 ==========");
        
        FoodCategoryDAO fdao=(FoodCategoryDAO)app.getBean("fdao");
        List<CategoryVO> cList=fdao.categoryListData();
        for(CategoryVO cvo:cList)
        {
        	System.out.println(cvo.getCno()+"."+cvo.getTitle());
        }
	}

}
