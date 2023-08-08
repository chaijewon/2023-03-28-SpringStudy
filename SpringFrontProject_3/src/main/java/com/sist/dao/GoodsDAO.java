package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.*;
@Repository
public class GoodsDAO {
   @Autowired
   private GoodsMapper mapper;
   
   /*@Select("SELECT no,goods_name as name,goods_poster as poster,goods_price as price,num "
			  +"FROM (SELECT no,goods_name,goods_poster,goods_price,rownum as num "
			  +"FROM (SELECT no,goods_name,goods_poster,goods_price "
			  +"FROM goods_all ORDER BY no ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")*/
	   // 인라인뷰 => Top-N : 포트폴리어 => 인라인뷰를 이용한 페이징 기법 사용
	  public List<GoodsVO> goodsListData(Map map)
	  {
		  return mapper.goodsListData(map);
	  }
	   
	   //상세보기 => Session (장바구니)
	   /*@Update("UPDATE goods_all SET "
			  +"hit=hit+1 "
			  +"WHERE no=#{no}")
	   public void hitIncrement(int no);
	   @Select("SELECT no,goods_name as name,goods_sub as sub,"
			  +"goods_price as price,goods_discount as discount,"
			  +"goods_first_price as first_price,"
			  +"goods_delivery ad delivery,goods_poster as poster,"
			  +"hit,account "
			  +"FROM goods_all "
			  +"WHERE no=#{no}")*/
	   public GoodsVO goodsDetailData(int no)
	   {
		   mapper.hitIncrement(no);
		   return mapper.goodsDetailData(no);
	   }
}
