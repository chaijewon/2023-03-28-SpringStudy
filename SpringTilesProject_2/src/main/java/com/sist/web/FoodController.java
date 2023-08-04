package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
  @Autowired
  private FoodDAO dao;
  // food/food_list.do?cno=${vo.cno }
  @GetMapping("food/food_list.do")
  public String food_list(int cno,Model model)
  {
	  List<FoodVO> list=dao.foodListData(cno);
	  for(FoodVO vo:list)
	  {
		  String address=vo.getAddress();
		  address=address.substring(0,address.lastIndexOf("지번"));
		  vo.setAddress(address);
		  
		  String poster=vo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  poster=poster.replace("#", "&");
		  vo.setPoster(poster);
	  }
	  CategoryVO vo=dao.foodCategoryInfoData(cno);
	  model.addAttribute("cvo", vo);
	  model.addAttribute("list", list);
	  return "food/food_list";
  }
  @GetMapping("food/food_find.do")
  public String food_find(String fd,String page,Model model)
  {
	  if(fd==null)
		  fd="마포";
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  //DAO연결 
	  Map map=new HashMap();
	  int rowSize=20;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  map.put("start", start);
	  map.put("end", end);
	  map.put("fd", fd);
	  List<FoodVO> list=dao.foodFindData(map);
	  for(FoodVO vo:list)
	  {
		  String poster=vo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  poster=poster.replace("#", "&");
		  vo.setPoster(poster);
	  }
	  int totalpage=dao.foodFindTotalPage(fd);
	  //블록 페이지 
	  final int BLOCK=5;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // 데이터를 jsp로 전송 
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  model.addAttribute("list", list);
	  model.addAttribute("fd", fd);
	  return "food/food_find";
  }
}
