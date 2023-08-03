package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
   
   @GetMapping("update.do")
   public String board_update(int no,Model model)
   {
	   // 필요한 데이터를 전송 
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../board/update.jsp");
	   return "main/main";
   }
   
   @PostMapping(value="update_ok.do",produces = "text/html;charset=UTF-8")
   @ResponseBody
   public String board_update_ok(BoardVO vo)
   {
	   String result="";
	   boolean bCheck=dao.boardUpdate(vo);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"../board/detail.do?no="+vo.getNo()+"\""
				 +"</script>";
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   @GetMapping("delete.do")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("main_jsp", "../board/delete.jsp");
	   return "main/main";
   }
   
   @PostMapping(value="delete_ok.do",produces = "text/html;charset=UTF-8")
   @ResponseBody
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   boolean bCheck=dao.boardDelete(no, pwd);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"../board/list.do\""
				 +"</script>";
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   @PostMapping("find.do")
   public String board_find(String[] fs,String ss, Model model)
   {
	   // 검색된 데이터를 읽어 온다 (데이터베이스 연결)
	   Map map=new HashMap();
	   map.put("fsArr", fs);
	   map.put("ss", ss);
	   List<BoardVO> list=dao.boardFindData(map);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../board/find.jsp");
	   return "main/main";
   }
}









