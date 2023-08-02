package com.sist.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
/*
 *   어노테이션 => 메모리 할당 
 *   @Component, 
 *   @Repository, 
 *   @Service, 
 *   @Controller, 
 *   @RestController, 
 *   @ControllerAdvice, 
     @Configuration
 *   
 */
// 다른 언어 연결 => VueJS
// FoodVO => {}  List<FoodVO> => [{},{},{}...] => JSON으로 변경후 전송 
@RestController
@CrossOrigin("http://localhost:3000")
public class FoodRestController {
  
}
