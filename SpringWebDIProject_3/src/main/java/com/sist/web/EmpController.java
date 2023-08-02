package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class EmpController {
  @Autowired
  private EmpDAO dao;
  
  @GetMapping("emp/list.do")
  public String emp_list(Model model)
  {
	  List<String> list=dao.empGetNameData();
	  model.addAttribute("list", list);
	  return "emp/list";
  }
  @PostMapping("emp/info.do")
  public String emp_info(Model model,String[] names)
  {
	  for(String name:names)
	  {
		  System.out.println(name);
	  }
	  Map map=new HashMap();
	  map.put("names", names);
	  List<EmpVO> list=dao.empInfoData(map);
	  model.addAttribute("list", list);
	  return "emp/info";
  }
}
