package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
/*
 *    client
 *      |
 *    DispatcherServlet : 사용자의 모든 요청을 받는다 (Front Controller)
 *                        이미 스프링에서 라이브러리 제작 
 *                        => 등록 (web.xml) => servlet은 구동 (톰캣)
 *                   = HandlerAdapter : Model를 찾는 역할 
 *                   = HandlerMapping : 찾은 Model에서 @RequestMapping()
 *                   ---------------- DispatcherServlet설정과 동시에 설정 
 *                   *** 자바로 환경 설정시에는 Handler~을 직접 설정 
 *                   ==> web.xml에 셋팅과 동시에 구동
 *      |
 *    ***해당 모델 (Controller) : 개발자 직접 제작 ==> DAO
 *      | request에 요청 처리값을 담는다 
 *      | JSP파일명을 전송한다
 *        Java ==> JSP로 전송(X) 
 *        JSP ==> JSP  , Servlet ==> JSP
 *    DispatcherServlet
 *      | 1) JSP찾기
 *        2) request를 전송 
 *        ---------------- ViewResolver
 *      |
 *    ***View (JSP)
 *      | request에 담긴 데이터를 출력 (JSTL/EL)
 *     Client (브라우저)
 */
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  /*@Select("SELECT cno,title,poster,subject "
			 +"FROM food_category "
			 +"ORDER BY cno ASC")*/
  public List<CategoryVO> foodCategoryListData()
  {
	  return mapper.foodCategoryListData();
  }
  
  /*@Select("SELECT fno,name,score,address,phone,type,poster "
			 +"FROM food_house "
			 +"WHERE cno=#{cno}")*/
   public List<FoodVO> foodListData(int cno)
   {
	   return mapper.foodListData(cno);
   }
}
