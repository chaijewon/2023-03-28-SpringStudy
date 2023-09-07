package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
@RestController
@RequestMapping("food/")
@CrossOrigin("http://localhost:3000")
public class FoodRestController {
   @Autowired
   private FoodCategoryDAO dao;
   
   @Autowired
   private FoodDAO fdao;
   
   @Autowired
   private FoodLocationDAO ldao;
   
   @GetMapping("category1")
   public List<CategoryEntity> food_category1()
   {
	   List<CategoryEntity> list=dao.categoryData1();
	   return list;
   }
   @GetMapping("category2")
   public List<CategoryEntity> food_category2()
   {
	   List<CategoryEntity> list=dao.categoryData2();
	   return list;
   }
   @GetMapping("category3")
   public List<CategoryEntity> food_category3()
   {
	   List<CategoryEntity> list=dao.categoryData3();
	   return list;
   }
   
   @GetMapping("category_info_react")
   public CategoryEntity categort_info(int cno) //{}
   {
	   CategoryEntity vo=dao.findByCno(cno);
	   return vo;
   }
   @GetMapping("food_list_react")
   public List<FoodEntity> food_list(int cno)//[]
   {
	   List<FoodEntity> list=fdao.foodListData(cno);
	   return list;
   }
   @GetMapping("food_detail_react")
   public FoodEntity food_detail(int fno)
   {
	   FoodEntity vo=fdao.findByFno(fno);
	   return vo;
   }
   
   @RequestMapping("food_find_react")
   public List<FoodLocationEntity> food_find(String address,String page)
   {
	   if(address==null)
		   address="마포";
	   
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=20;
	   int start=(rowSize*curpage)-rowSize;//LIMIT => 0
	   List<FoodLocationEntity> list=ldao.foodFindData(address, start);
	   return list;
   }
   @GetMapping("food_totalpage_react")
   public int food_page(String address)
   {
	   int totalpage=ldao.foodFindTotalPage(address);
	   
	   return totalpage;
   }
   @GetMapping("food_count_react")
   public int food_count(String address)
   {
	   return ldao.foodFindCount(address);
   }
}
