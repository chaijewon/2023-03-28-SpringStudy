package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// jsp를 변경(화면 변경)
@Controller
public class FoodController {
   @GetMapping("food/food_category.do")
   public String food_category()
   {
	   return "food/food_category";// 파일명 
   }
   @GetMapping("food/food_detail.do")
   public String food_detail(int fno,Model model)
   {
	   model.addAttribute("fno", fno);
	   return "food/food_detail";
   }
}
