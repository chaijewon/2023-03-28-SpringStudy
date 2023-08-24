package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
  @GetMapping("weather/weather.do")
  public String weather(Model model)
  {
	  model.addAttribute("main_jsp", "../weather/weather.jsp");
	  return "main/main";
  }
}
