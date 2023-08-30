package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.vo.FoodVO;
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodMapper mapper;

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(String address) {
		// TODO Auto-generated method stub
		return mapper.foodFindTotalPage(address);
	}
}
