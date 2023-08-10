package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
   @GetMapping("food/food_category.do")
   public String food_category()
   {
	   return "food/food_category";// 파일명 
   }
}
