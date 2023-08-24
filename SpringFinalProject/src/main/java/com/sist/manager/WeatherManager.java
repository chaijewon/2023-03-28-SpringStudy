package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
@Component
public class WeatherManager {
  public String weatherData()
  {
	  String html="";
	  try
	  {
		  Document doc=Jsoup.connect("https://korean.visitseoul.net/weather").get();
		  Element section=doc.selectFirst("section#content");
		  html="<section id=\"content\">";
		  html+=section.html();
		  html+="</section>";
		  // <img src="https://korean.visitseoul.net/resources/theme/images/weather/img-weather10.png" alt="흐리고 비">
		  html=html.replace("src=\"","src=\"https://korean.visitseoul.net" );
		  html=html.replace("제공 : 케이웨더(Kweather)","" );
	  }catch(Exception ex) {}
	  return html;
  }
}
