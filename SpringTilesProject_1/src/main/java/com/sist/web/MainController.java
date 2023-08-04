package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
   @GetMapping("main/main.do")
   public String main_main()
   {
	   return "main";
   }
   @GetMapping("board/list.do")
   public String board_list()
   {
	   return "board/list";
   }
   @GetMapping("notice/list.do")
   public String notice_list()
   {
	   return "notice/list";
   }
}
