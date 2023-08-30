package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.FoodMapper;
import com.sist.web.vo.CategoryVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
    private FoodMapper mapper;
	@Override
	public List<CategoryVO> categoryListData() {
		// TODO Auto-generated method stub
		return mapper.categoryListData();
	}
   
}
