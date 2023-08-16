package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.MyVO;
import com.sist.vo.TestVO;
import java.util.*;
@Controller
public class TestController {
   @PostMapping("test/add.do")
   public String add(MyVO vo)
   {
	   List<TestVO> list=vo.getList();
	   for(TestVO tvo:list)
	   {
		   System.out.println(tvo.getName()+" "
				   +tvo.getSex()+" "
				   +tvo.getAge());
	   }
	   return "test/add";
   }
}
