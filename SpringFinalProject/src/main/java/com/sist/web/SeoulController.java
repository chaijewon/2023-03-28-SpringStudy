package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeoulController {
   private String[] titles={"","서울 명소","서울 자연 & 관광","서울 쇼핑"};
   @GetMapping("seoul/seoul_list.do")
   public String seoul_list(int type,Model model)
   {
	   model.addAttribute("type", type);
	   model.addAttribute("title", titles[type]);
	   model.addAttribute("main_jsp", "../seoul/seoul_list.jsp");
	   return "main/main";
   }
}
