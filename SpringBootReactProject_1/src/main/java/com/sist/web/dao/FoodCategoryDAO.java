package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
@Repository
public interface FoodCategoryDAO extends JpaRepository<CategoryEntity,Integer> {
   @Query(value="SELECT * FROM food_category WHERE cno BETWEEN 1 AND 12",nativeQuery=true)
   public List<CategoryEntity> categoryData1();
   @Query(value="SELECT * FROM food_category WHERE cno BETWEEN 13 AND 18",nativeQuery=true)
   public List<CategoryEntity> categoryData2();
   @Query(value="SELECT * FROM food_category WHERE cno BETWEEN 19 AND 30",nativeQuery=true)
   public List<CategoryEntity> categoryData3();
   
   public CategoryEntity findByCno(int cno);
   
}
