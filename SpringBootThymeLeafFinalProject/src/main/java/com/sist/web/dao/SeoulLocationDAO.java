package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.sist.web.entity.*;
public interface SeoulLocationDAO extends JpaRepository<SeoulEntity,Integer>{
  @Query(value="SELECT * FROM seoul_location "
		      +"ORDER BY no ASC LIMIT :start,20",nativeQuery=true)
  public List<SeoulEntity> seoulLocationListData(@Param("start") Integer start);
  
  @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM seoul_location",nativeQuery=true)
  public int seoulLocationTotalPage();
  
  @Query(value="SELECT * FROM seoul_nature "
	      +"ORDER BY no ASC LIMIT :start,20",nativeQuery=true)
  public List<SeoulEntity> seoulNatureListData(@Param("start") Integer start);

  @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM seoul_nature",nativeQuery=true)
  public int seoulNatureTotalPage();

  @Query(value="SELECT * FROM seoul_shop "
	      +"ORDER BY no ASC LIMIT :start,20",nativeQuery=true)
  public List<SeoulEntity> seoulShopListData(@Param("start") Integer start);

  @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM seoul_shop",nativeQuery=true)
  public int seoulShopTotalPage();
}
