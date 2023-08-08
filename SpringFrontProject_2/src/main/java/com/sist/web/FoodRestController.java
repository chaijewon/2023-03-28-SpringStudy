package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FoodDAO;
import java.util.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_list_vue(String page)
   {
	   String result="";
	   try
	   {
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   Map map=new HashMap();
		   map.put("start", (curpage*12)-11);
		   map.put("end", curpage*12);
		   List<FoodLocationVO> list=dao.foodListData(map);
		   int totalpage=dao.foodTotalPage();
		   // List => [] => JSONArray
		   // FoodLocationVO => {} => JSONObject
		   // [{},{},{}....]
		   JSONArray arr=new JSONArray(); 
		   int i=0;
		   // fno,name,poster,score
		   /*
		    *   {fno:1,name:"",poater:"",score:5.0}
		    */
		   for(FoodLocationVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("fno", vo.getFno());
			   obj.put("name", vo.getName());
			   obj.put("score", vo.getScore());
			   String poster=vo.getPoster();
			   poster=poster.substring(0,poster.indexOf("^"));
			   poster=poster.replace("#", "&");
			   obj.put("poster", poster);
			   if(i==0)
			   {
				   obj.put("curpage", curpage);
				   obj.put("totalpage", totalpage);
			   }
			   arr.add(obj);
			   i++;
		   }
		   result=arr.toJSONString();
	   }catch(Exception ex) {}
	   return result;
   }
   /*
    *   1. 일반문자열 => NOID,NOPWD,OK => text/html
    *   2. 데이터묶음(JSON) => text/plain
    *      List / VO
    *            ---- {} => JSONObject 
    *      ---- [] => JSONArray
    *      --------------------------------> jackson(Spring-Boot)
    *   3. XML전송 => text/xml
    */
   @GetMapping(value="food/find_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_find(int page,String fd)
   {
	   String result="";
	   try
	   {
		   int curpage=page;
		   Map map=new HashMap();
		   map.put("start", (curpage*12)-11);
		   map.put("end", curpage*12);
		   map.put("address", fd);
		   List<FoodLocationVO> list=dao.foodFindData(map);
		   int totalpage=dao.foodFindTotalPage(fd);
		   final int BLOCK=5;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1; 
		   // 4/5*5 => 0
		   // curpage => 1,5 => startPage=1
		   // 1 2 3 4 5
		   // curpage => 6,10 => startPage=6
		   // 6 7 8 9 10 
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   // JSON  변경 
		   int i=0;
		   JSONArray arr=new JSONArray(); // List대신 
		   // fno,name,poster,score
		   for(FoodLocationVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("fno", vo.getFno());
			   obj.put("name", vo.getName());
			   obj.put("score", vo.getScore());
			   String poster=vo.getPoster();
			   poster=poster.substring(0,poster.indexOf("^"));
			   poster=poster.replace("#", "&");
			   obj.put("poster", poster);
			   if(i==0)
			   {
				   obj.put("curpage", curpage);
				   obj.put("totalpage", totalpage);
				   obj.put("startPage", startPage);
				   obj.put("endPage", endPage);
			   }
			   i++;
			   arr.add(obj);
		   }
		   result=arr.toJSONString();
		   // [{curpage,totalpage,startPage},{},{}....]
	   }catch(Exception ex) {ex.printStackTrace();}
	   return result;
   }
}






