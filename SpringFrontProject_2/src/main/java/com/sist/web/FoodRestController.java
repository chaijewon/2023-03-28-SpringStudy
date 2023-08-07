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
}
