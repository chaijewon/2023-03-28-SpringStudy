package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.SeoulDAO;
import com.sist.mapper.*;
import com.sist.vo.*;

@Controller
public class SeoulController {
	 @Autowired
     private SeoulDAO dao;
	 
	 @GetMapping("seoul/location.do")
	 public String seoul_location(String page,Model model)
	 {
		 if(page==null)
			 page="1";
		 int curpage=Integer.parseInt(page);
		 int rowSize=12;
		 int start=(rowSize*curpage)-(rowSize-1);
		 int end=rowSize*curpage;
		 
		 Map map=new HashMap();
		 map.put("start", start);
		 map.put("end", end);
		 List<SeoulVO> list=dao.seoulLocationListData(map);
		 int totalpage=dao.seoulLocationTotalPage();
		 
		 final int BLOCK=5;
		 int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		 int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		 
		 if(endPage>totalpage)
			 endPage=totalpage;
		 
		 // jsp 전송할 데이터 설정 
		 model.addAttribute("curpage", curpage);
		 model.addAttribute("totalpage", totalpage);
		 model.addAttribute("startPage", startPage);
		 model.addAttribute("endPage", endPage);
		 model.addAttribute("list", list);
		 
		 model.addAttribute("main_jsp", "../seoul/location.jsp");
		 return "main/main";
	 }
}
