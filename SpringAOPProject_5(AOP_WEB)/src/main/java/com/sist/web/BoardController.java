package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
// MSA / DevOps / 
@Controller
@RequestMapping("board/")
public class BoardController {
   @Autowired
   private BoardDAO dao;
   
   @RequestMapping("list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<BoardVO> list=dao.boardListData(map);
	   int totalpage=dao.boardTotalPage();
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list",list);
	   
	   model.addAttribute("main_jsp", "../board/list.jsp");
	   return "main/main";
   }
   
   @GetMapping("insert.do")
   public String board_insert(Model model)
   {
	   model.addAttribute("main_jsp", "../board/insert.jsp");
	   return "main/main";
   }
   
   @PostMapping("insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:../board/list.do";
   }
   // board/detail.do?no=${vo.no }
   @GetMapping("detail.do")
   public String board_detail(int no,Model model)
   {
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   // 문장 분석 
	   model.addAttribute("main_jsp", "../board/detail.jsp");
	   return "main/main";
   }
   //board/reply.do?pno=${vo.no }
   @GetMapping("reply.do")
   public String board_reply(int pno,Model model)
   {
	   model.addAttribute("pno", pno);
	   model.addAttribute("main_jsp", "../board/reply.jsp");
	   return "main/main";
   }
   
   @PostMapping("reply_ok.do")
   public String board_reply_ok(int pno,BoardVO vo)
   {
	   dao.boardReplyInsert(pno, vo);
	   return "redirect:../board/list.do";
   }
   
}









