package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
    @GetMapping("movie/movie_rank.do")
    public String movie_rank()
    {
    	return "movie/movie_rank";
    }
}
