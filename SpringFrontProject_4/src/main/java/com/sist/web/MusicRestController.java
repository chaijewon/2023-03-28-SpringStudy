package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class MusicRestController {
   @Autowired
   private MusicDAO dao;
   
   @GetMapping(value="music/list_vue.do",produces = "text/plain;charset=UTF-8")
   public String music_list(int cno)
   {
	   String result="";
	   try
	   {
		   List<MusicVO> list=dao.musicListData(cno);
		   String[] titles={"","Top100","가요","POP","OST","트롯","JAZZ","CLASSIC"};
		   JSONArray arr=new JSONArray();
		   int i=0;
		   for(MusicVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("mno", vo.getMno());
			   obj.put("title", vo.getTitle());
			   obj.put("singer", vo.getSinger());
			   obj.put("album", vo.getAlbum());
			   obj.put("id", vo.getIdcrement());
			   obj.put("state", vo.getState());
			   obj.put("key", vo.getKey());
			   obj.put("poster", vo.getPoster());
			   if(i==0)
			   {
				   obj.put("music_title", titles[cno]);
			   }
			   arr.add(obj);
			   i++;
		   }
		   result=arr.toJSONString();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   return result;
   }
   @GetMapping(value="music/detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String music_detail(int mno)
   {
	   String result="";
	   try
	   {
		   MusicVO vo=dao.musicDetailData(mno);
		   JSONObject obj=new JSONObject();
		   obj.put("title", vo.getTitle());
		   obj.put("key", vo.getKey());
		   result=obj.toJSONString();
	   }catch(Exception ex) {}
	   return result;
   }
   @GetMapping(value="music/test.do",produces = "text/plian;charset=UTF-8")
   public String music_test(int mno) throws Exception
   {
	   MusicVO vo=dao.musicDetailData(mno);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
   @GetMapping(value="music/test1.do",produces = "text/plian;charset=UTF-8")
   public String music_test1(int cno) throws Exception
   {
//	   MusicVO vo=dao.musicDetailData(mno);
//	   ObjectMapper mapper=new ObjectMapper();
//	   String json=mapper.writeValueAsString(vo);
	   List<MusicVO> list=dao.musicListData(cno);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
}






