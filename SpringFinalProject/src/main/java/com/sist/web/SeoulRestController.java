package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
@RestController
public class SeoulRestController {
   @Autowired
   private SeoulDAO dao;
   
   private String[] tables={"","seoul_location","seoul_nature","seoul_shop"};
   
   @GetMapping(value="seoul/seoul_list_vue.do",produces = "text/plain;charset=UTF-8")
   public String seoul_list(int page,int type) throws Exception
   {
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   map.put("start", start);
	   map.put("end", end);
	   map.put("table_name", tables[type]);
	   List<SeoulVO> list=dao.seoulListData(map);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
   @GetMapping(value="seoul/seoul_page_info_vue.do",produces = "text/plain;charset=UTF-8")
   public String seoul_page_info(int page,int type) throws Exception
   {
	   Map map=new HashMap();
	   map.put("table_name", tables[type]);
	   int totalpage=dao.seoulTotalPage(map);
	   PageVO vo=new PageVO();
	   final int BLOCK=5;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   vo.setCurpage(page);
	   vo.setStartPage(startPage);
	   vo.setEndPage(endPage);
	   vo.setTotalpage(totalpage);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
}
