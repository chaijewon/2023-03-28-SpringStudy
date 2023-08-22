package com.sist.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBoardController {
   @GetMapping("databoard/list.do")
   public String databoard_list(Model model)
   {
	   model.addAttribute("main_jsp", "../databoard/list.jsp");
	   return "main/main";
   }
   @GetMapping("databoard/insert.do")
   public String databoard_insert(Model model)
   {
	   model.addAttribute("main_jsp", "../databoard/insert.jsp");
	   return "main/main";
   }
   @GetMapping("databoard/detail.do")
   public String databoard_detail(int no,Model model)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("main_jsp", "../databoard/detail.jsp");
	   return "main/main";
   }
   @GetMapping("databoard/download.do")
   public void databoard_download(String fn,
		   HttpServletRequest request,HttpServletResponse response)
   {
	   String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
	   path=path.replace("\\", File.separator);
	   try
	   {
		   File file=new File(path+fn);
		   response.setHeader("Content-Disposition", "attachement;filename="
				   +URLEncoder.encode(fn,"UTF-8"));
		   response.setContentLength((int)file.length());
		   
		   BufferedInputStream bis=
				   new BufferedInputStream(new FileInputStream(file));
		   BufferedOutputStream bos=
				   new BufferedOutputStream(response.getOutputStream());
		   int i=0; 
		   byte[] buffer=new byte[1024];
		   while((i=bis.read(buffer, 0, 1024))!=-1)
		   {
			   bos.write(buffer, 0, i);
		   }
		   bis.close();
		   bos.close();
	   }catch(Exception ex){}
   }
}





