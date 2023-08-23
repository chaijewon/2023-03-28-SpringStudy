package com.sist.web;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
@RestController
public class RecommandRestController {
	private String[] type1= {"봄", "여름", "가을", "겨울", "맑은날", "추운날", "흐린날" ,"비오는날", "더운날","눈오는날"};
	private String[] type2= {"외로운 날", "기분전환", "슬픈 날", "이별하는 날" ,"지칠는 날", "위로 받고 싶은 날" ,"짜증나는 날",  "우울한 날",
	 "행복한 날", "불안한 날" , "기쁜 날", "축하받고 싶은 날"};
	private String[] type3= {"밝은 날", "신나는 날", "따뜻한 날", "편안한 날", "달콤한 날", "시원한 날" ,  "어두운 날"};
	
	@GetMapping(value="recommand/recommand_sub_vue.do",produces = "text/plain;charset=UTF-8")
	public String recommand_sub(int no) throws Exception
	{
		List<String> list=new ArrayList<String>();
		if(no==1)
		{
			list=Arrays.asList(type1);
		}
		else if(no==2)
		{
			list=Arrays.asList(type2);
		}
		else if(no==3)
		{
			list=Arrays.asList(type3);
		}
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
}
