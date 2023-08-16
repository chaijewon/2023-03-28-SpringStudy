package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.dao.*;

import com.sist.vo.*;
@Controller
public class MainController {
   
   @GetMapping("main/main.do")
   public String main_page(Model model) throws Exception
   {
	  
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   
	   return "main/main";
   }
   @GetMapping("chat/chat.do")
   public String chat_chat(Model model)
   {
	   model.addAttribute("main_jsp", "../chat/chat.jsp");
	   return "main/main";
   }
   
   @GetMapping("chat2/chat2.do")
   public String chat2_chat2(Model model)
   {
	   model.addAttribute("main_jsp", "../chat2/chat2.jsp");
	   return "main/main";
   }
   
}





