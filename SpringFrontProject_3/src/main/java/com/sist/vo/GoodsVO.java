package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
// 1. 페이지 기법 
// 2. Cookie 
// 3. Session
// 4. 로그인 => password 암호화 / 복호화 
// 5. Front => Vue => watch / computed / component / filter
// 6. 회원가입 => 유효성 검사 
/*
 *   NO                NOT NULL NUMBER         
	GOODS_NAME        NOT NULL VARCHAR2(1000) 
	GOODS_SUB                  VARCHAR2(1000) 
	GOODS_PRICE       NOT NULL VARCHAR2(50)   
	GOODS_DISCOUNT             NUMBER         
	GOODS_FIRST_PRICE          VARCHAR2(20)   
	GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
	GOODS_POSTER               VARCHAR2(260)  
	HIT                        NUMBER         
	ACCOUNT                    NUMBER 
 */
@Getter
@Setter
public class GoodsVO {
   private int no,discount,hit,account;
   private String name,sub,price,first_price,delivery,poster;
   // vo.setName(rs.getString("goods_name"))
}
