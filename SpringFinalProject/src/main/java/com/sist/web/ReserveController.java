package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.ReserveDAO;
import java.util.*;
import com.sist.vo.*;
@Controller
public class ReserveController {
  @Autowired
  private ReserveDAO dao;
  @GetMapping("reserve/reserve_main.do")
  public String reserve_main(Model model)
  {
	  model.addAttribute("main_jsp", "../reserve/reserve_main.jsp");
	  return "main/main";
  }
  @GetMapping("reserve/food_list.do")
  public String food_list(String type,Model model)
  {
	  System.out.println("type:"+type);
	  if(type==null)
		  type="한식";
	  List<FoodVO> list=dao.foodReserveData(type);
	  model.addAttribute("list", list);
	  return "reserve/food_list";
  }
}
