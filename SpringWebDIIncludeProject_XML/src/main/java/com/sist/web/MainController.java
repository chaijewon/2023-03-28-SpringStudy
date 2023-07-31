package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *   Spring : 자바라이브러리 
 *   -------
 *     DI : Spring을 통해서 객체생성 ~ 객체소멸
 *                        ------
 *                         필요한 데이터가 있는 경우에 데이터를 전송 (멤버변수의 초기화)
 *                         변수의 초기화 
 *                         ----------
 *                         1. 명시적 초기화 => 클래스를 제작시에 변수에 값을 직점 채워주는 방식
 *                         public class A
 *                         {
 *                           private String name="홍길동";
 *                         }
 *                         2. 생성자 => 생성자 DI
 *                         3. setter를 이용하는 방법 => setter DI
 *                         ----------------------------------- XML이용 , 자바를 이용
 *     AOP : 프로그램 (핵심 코드 , 공통 코드) 
 *                            --------- getConnection(), disConnection()
 *           => 클래스마다 공통으로 사용되는 메소드 모았다가 필요한 시기에 자동 호출이 가능 
 *           => 트랜젝션, LOG , 보안 
 *     MVC : 웹 제작 (View/Model) 
 *           Model : 데이터 관리 (자바) 
 *           View  : 데이터 출력 전용 
 *           Controller : 요청을 받고 , 데이터를 전송하는 역할 
 *           ----------------------------------------- 이미 라이브러리로 제작 
 *                     DispatcherServlet=> 톰캣에 의해 구동 
 *                                         ------------- web.xml
 *                     1) DispatcherServlet등록 
 *                     2) DispatcherServlet을 찾는 방법 
 *                        <url-pattern>*.do</url-pattern>
 *                        <url-pattern>/</url-pattern>
 *                        => PathValiable (admin/hong/1234)
 *           *** 요청을 받는 경우 (요청 데이터 전송)
 *               => request안에 담겨서 들어온다 => request.getParameter();
 *                  ** request는 사용자 정보 (IP,PORT) 가지고 있다 (보안상 문제) 
 *                     => 가급적이면 사용하지 않는다 
 *                     => 사용자 정의 메소드를 만들때 매개변수를 설정하면 DispatcherServlet에 의해 
 *                        매개변수가 채워진다 
 *                     => JSP 결과값은 전송 => Model
 *           Model을 작성 
 *           1) @Controller 설정해야 메모리 할당이 가능하다 (메소드 찾는 경우)
 *           2) 메소드 
 *              = 리턴형 : String , void 
 *                       ------- 화면 이동에 관련된 JSP정보/리다이렉트 정보 
 *              = 매개변수 : JSP에서 제공하는 내장 객체 설정 
 *                         => HttpServletRequest , HttpServletResponse , HttpSession
 *                         @GetMapping()
 *                         public String display(HttpSession session)
 *                         => VO단위 , String[] , 기본형 (int , double , boolean)
 *                         => List단위 
 *                         *** 순서는 상관없다 
 *           3) 찾기 (메소드) 
 *              @GetMapping => Get방식으로 요청 (default) => <a> ajax , axios...
 *              @PostMapping => <form> , ajax , axios
 *                                              ------ ajax대체 => Vue,React
 *                              axios.get() , axios.post()
 *               ------------------------- Spring 4.3이후부터 나눠져 있다 
 *              @RequestMapping => GET/POST를 동시에 처리가 가능 
 *           4) return => 반드시 JSP명(확장자는 사용하지 않는다)
 *                        재호출 : "redirect:.do"
 *                        
 *           => MVC 구동 방식 
 *           1) 사용자 요청 => .do
 *           2) DispatcherServlet이 요청을 받는다 
 *           3) DispatcherServlet => HandlerMapping
 *                             클래스를 찾아서 메소드 호출하라고 전송 
 *                             어노테이션 (GetMapping,PostMapping)
 *           ***4) Model에서 처리 ===> 사용자 정의 (개발자) 
 *           5) Model에서 처리된 결과를 DispatcherServlet이 받는다 
 *           6) ViewResolver로 전송 
 *              ------------ JSP를 찾아서 request를 전송하는 역할 
 *           ***7) JSP에서 request에 담긴 데이터를 출력 
 *           8) DispatcherServlet에 의해 브라우저 화면 전송 
 *       => 인터셉터 , AOP , 트랜잭션 기능 
 *       => 보안 , 데이터 , 배치 , 클라우드 ...
 */
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainController {
   // 객체주소를 받을지 여부 확인 
   @Autowired
   private FoodDAO dao;
   
   // 사용자 요청시 처리 
   @GetMapping("main/main.do") // main.do?cno=1
   public String main_main(String cno,Model model)
   {
	   if(cno==null)
		   cno="1";
	   Map map=new HashMap();
	   map.put("cno", Integer.parseInt(cno));
	   List<CategoryVO> list=dao.foodCategoryData(map);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
}








