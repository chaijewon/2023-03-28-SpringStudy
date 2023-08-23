package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommandController {
  @GetMapping("recommand/recommand.do")
  public String recommand_page(Model model)
  {
	  model.addAttribute("main_jsp", "../recommand/recommand.jsp");
	  return "main/main";
  }
}
