package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

import oracle.net.aso.m;
@RestController
public class DataBoardRestController {
   @Autowired
   private DataBoardDAO dao;
   // C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringFinalProject\\upload
   @PostMapping(value="databoard/insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String databoard_insert(@ModelAttribute DataBoardVO vo,HttpServletRequest request)
   {
	   String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
	   path=path.replace("\\", File.separator);
	   List<MultipartFile> list=vo.getImages();
	   if(list==null)
	   {
		   //System.out.println("파일 업로드가 없습니다");
		   vo.setFilename("");
		   vo.setFilesize("");
		   vo.setFilecount(0);
	   }
	   else
	   {
		   // System.out.println("파일이 "+list.size()+"개 업로드됨");
		   String filename="";
		   String filesize="";
		   for(MultipartFile mf:list)
		   {
			   String name=mf.getOriginalFilename();
			   File file=new File(path+name);
			   try
			   {
				   
				   mf.transferTo(file);// 업로드
			   }catch(Exception ex){}
			   
			   filename+=name+',';
			   filesize+=file.length()+",";
		   }
		   
		   filename=filename.substring(0,filename.lastIndexOf(","));
		   filesize=filesize.substring(0,filesize.lastIndexOf(","));
		   vo.setFilecount(list.size());
		   vo.setFilename(filename);
		   vo.setFilesize(filesize);
	   }
	   dao.dataBoardInsert(vo);
	   return "ok";
   }
   // Vue / React => JSONP , 클로져 
   @GetMapping(value="databoard/list_vue.do",produces = "text/plain;charset=UTF-8")
   public String databoard_list(int page) throws Exception
   {
	   
	   Map map=new HashedMap();
	   int rowSize=10;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   map.put("start", start);
	   map.put("end", end);
	   List<DataBoardVO> list=dao.databoardListData(map);
	   //int totalpage=dao.databoardTotalPage();
	   ObjectMapper mapper=new ObjectMapper();
	   
	   String json=mapper.writeValueAsString(list);
	   
	   return json;
   }
   @GetMapping(value="databoard/page_vue.do",produces = "text/plain;charset=UTF-8")
   public String databoard_page(int page) throws Exception
   {
	   int totalpage=dao.databoardTotalPage();
	   Map map=new HashedMap();
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   return json;
   }
   @GetMapping(value="databoard/detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String databoard_detail(int no) throws Exception
   {
	   DataBoardVO vo=dao.databoardDetailData(no);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
}








