package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
//import com.sist.web.service.*;
//import com.sist.web.vo.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
@Controller
public class FoodController {
  @Autowired
  //private FoodService service;
  private FoodDAO dao;
  
  @RequestMapping("food/find")
  public String food_find(String page,String fd,Model model)
  {
	  if(fd==null)
		  fd="마포";
	  
	  if(page==null)
		  page="1";
	  
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize);
	  int end=rowSize*curpage;
      map.put("start", start);
      map.put("address", fd);
	  //List<FoodVO> list=service.foodFindData(map);
	  //int totalpage=service.foodFindTotalPage(fd);
	  List<FoodEntity> list=dao.foodFindData(fd, start);
	  int totalpage=dao.foodFindTotalPage(fd);
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  model.addAttribute("list", list);
	  model.addAttribute("fd", fd);
	  return "food/find";
  }
  @GetMapping("food/detail")
  public String food_detail(int fno,Model model)
  {
	  FoodEntity vo=dao.findByFno(fno);
	  String poster=vo.getPoster();
	  String[] temp=poster.split("\\^");
	  List<String> pList=Arrays.asList(temp);
	  model.addAttribute("pList", pList);
	  model.addAttribute("vo", vo);
	  return "food/detail";
  }
}
