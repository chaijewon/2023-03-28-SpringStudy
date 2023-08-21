package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FoodController {
   @GetMapping("food/food_list.do")
   public String food_list(int cno,Model model)
   {
	   model.addAttribute("cno", cno);
	   model.addAttribute("main_jsp", "../food/food_list.jsp");
	   return "main/main";
   }
   @GetMapping("food/food_find.do")
   public String food_find(Model model)
   {
	   model.addAttribute("main_jsp", "../food/food_find.jsp");
	   return "main/main";
   }
   @GetMapping("food/food_detail_before.do")
   // 스프링 => 매개변수를 이용해서 필요한 데이터나 내장 객체 요청 
   //                  ----------------- 사용자가 보내는 데이터 
   // 순서는 상관없다 
   public String food_detail_before(int fno,RedirectAttributes ra,
		   HttpServletResponse response)
   {
	   Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
	   // 쿠키 => 클라이언트 (단점:보안 취약 , 문자열만 저장이 가능)
	   // 내장 객체는 아니다 
	   // 쿠키 생성 => 저장 장소 설정 => 기간 설정 => 전송 
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);// 초단위로 저장 
	   response.addCookie(cookie);
	   ra.addAttribute("fno", fno);// sendRedirect => request를 초기화 
	   return "redirect:../food/food_detail.do";
   }
   @GetMapping("food/food_detail.do")
   public String food_detail(int fno,Model model,HttpSession session)
   {
	   String id=(String)session.getAttribute("id");
	   if(id==null)
		   id="";
	   model.addAttribute("id", id);
	   model.addAttribute("fno", fno);
	   model.addAttribute("main_jsp", "../food/food_detail.jsp");
	   return "main/main";// forward => request를 전송 
   }
}
