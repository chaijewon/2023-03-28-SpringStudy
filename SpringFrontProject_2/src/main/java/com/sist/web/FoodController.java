package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping("food/list.do")
   public String food_list()
   {
	   return "food/list";
   }
   @GetMapping("food/find.do")
   public String food_find()
   {
	   return "food/find";
   }
}
