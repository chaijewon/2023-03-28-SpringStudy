package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping(value="food/category_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_category() throws Exception
   {
	   List<CategoryVO> list=dao.foodCategoryListData();
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
   @GetMapping(value="food/category_info_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_category_info(int cno) throws Exception
   {
	   CategoryVO vo=dao.foodCategoryInfoData(cno);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
   @GetMapping(value="food/food_find_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_find(int page,String column,String fd) throws Exception
   {
	   Map map=new HashMap();
	   map.put("column",column);
	   map.put("fd", fd);
	   int rowSize=20;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   map.put("start", start);
	   map.put("end", end);
	   List<FoodVO> list=dao.foodFindData(map);
	   for(FoodVO vo:list)
	   {
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   poster=poster.replace("#", "&");
		   vo.setPoster(poster);
	   }
	   ObjectMapper mapper=new ObjectMapper(); 
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
   @GetMapping(value="food/page_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_page(int page,String column,String fd) throws Exception
   {
	   Map map=new HashMap();
	   map.put("column",column);
	   map.put("fd", fd);
	   int totalpage=dao.foodFindTotalPage(map);
	   
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   PageVO vo=new PageVO();
	   vo.setCurpage(page);
	   vo.setTotalpage(totalpage);
	   vo.setStartPage(startPage);
	   vo.setEndPage(endPage);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
   @GetMapping(value="food/food_detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_detail(int fno) throws Exception
   {
	   FoodVO vo=dao.foodDetailData(fno);
	   String addr=vo.getAddress();
	   addr=addr.substring(0,addr.indexOf("지번"));
	   vo.setAddress(addr.trim());
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
}
