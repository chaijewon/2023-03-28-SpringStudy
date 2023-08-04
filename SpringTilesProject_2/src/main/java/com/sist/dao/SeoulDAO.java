package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

@Repository
public class SeoulDAO {
  @Autowired
  private SeoulMapper mapper;
  //@Select(value="{CALL seoulListData(#{pNo,mode=IN,javaType=java.lang.Integer},#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR})}")
  //@Options(statementType = StatementType.CALLABLE)
  public List<SeoulVO> seoulListData(Map map)
  {
	  mapper.seoulListData(map);
	  return (List<SeoulVO>)map.get("pResult");
  }
  //@Select(value="{CALL seoulTotalPage(#{pNo,mode=IN,javaType=java.lang.Integer},#{pTotal,mode=OUT,javaType=java.lang.Integer})")
  //@Options(statementType = StatementType.CALLABLE)
  public Integer seoulTotalPage(Map map)
  {
	  mapper.seoulTotalPage(map);
	  return (Integer)map.get("pTotal");
  }
  public SeoulVO seoulDetailData(Map map)
  {
	  return mapper.seoulDetailData(map);
  }
}
