package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
  @GetMapping("music/music_main.do")
  public String music_main()
  {
	  return "music/music_main";
  }
}
