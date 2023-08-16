package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
   @GetMapping("food/food_list.do")
   public String food_list(int cno,Model model)
   {
	   model.addAttribute("cno", cno);
	   model.addAttribute("main_jsp", "../food/food_list.jsp");
	   return "main/main";
   }
}
