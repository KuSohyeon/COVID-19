package com.miniPJT.covid19.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniPJT.covid19.mapper.GlobalMapper;
import com.miniPJT.covid19.model.DayGlobal;
import com.miniPJT.covid19.model.TotalGlobal;

@Service
public class GlobalServiceImpl implements GlobalService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertToday(List<DayGlobal> list) throws Exception {
		sqlSession.getMapper(GlobalMapper.class).insertToday(list);
	}

	@Override
	public void insertTotal() throws Exception {
		sqlSession.getMapper(GlobalMapper.class).insertTotal();
	}

	@Override
	public List<DayGlobal> todayGlobal() throws Exception {
		return sqlSession.getMapper(GlobalMapper.class).todayGlobal();
	}
	
	@Override
	public TotalGlobal totalToday() throws Exception {
		return sqlSession.getMapper(GlobalMapper.class).totalToday();
	}

	@Override
	public List<TotalGlobal> total7Days() throws Exception {
		return sqlSession.getMapper(GlobalMapper.class).total7Days();
	}

	
	
}
