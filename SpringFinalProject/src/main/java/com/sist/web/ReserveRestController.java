package com.sist.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReserveRestController {
   @GetMapping(value="reserve/reserve_food_vue.do",produces = "text/plain;charset=UTF-8")
   public String reserve_food_vue(String type)
   {
	   // reserve/food_list.do
	     String html="<html>";
		  try
		  {
			  Document doc=Jsoup.connect("http://localhost/web/reserve/food_list.do?type="+type).get();
			  Element section=doc.selectFirst("html");
			  
			  html+=section.html();
			  html+="</html>";
		  }catch(Exception ex) {}
		  return html;
   }
}
