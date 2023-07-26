package com.sist.dao2;
import java.util.*;
public class StudentDAO {
    private StudentMapper mapper;

	public void setMapper(StudentMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<StudentVO> studentListData()
	{
		return mapper.studentListData();
	}
	public StudentVO studentDetailData(int hakbun)
	{
		return mapper.studentDetailData(hakbun);
	}
	public List<StudentVO> studentFindData(String name)
	{
		return mapper.studentFindData(name);
	}
	public void studentUpdate(StudentVO vo)
	{
		mapper.studentUpdate(vo);
	}
	public void studentDelete(int hakbun)
	{
		mapper.studentDelete(hakbun);
	}
	public void studentInsert(StudentVO vo)
	{
		mapper.studentInsert(vo);
	}
}
