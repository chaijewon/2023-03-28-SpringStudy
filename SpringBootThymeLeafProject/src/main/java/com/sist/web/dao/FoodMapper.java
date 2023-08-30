package com.sist.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Repository
@Mapper
public interface FoodMapper {
   public List<CategoryVO> categoryListData();
}
