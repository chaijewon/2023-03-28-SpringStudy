package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.manager.*;
@RestController
public class WeatherRestController {
  @Autowired
  private WeatherManager wm;
  
  @GetMapping(value="weather/weather_vue.do",produces = "text/plain;charset=UTF-8")
  public String weather_vue()
  {
	  String html=wm.weatherData();
	  return html;
  }
}
