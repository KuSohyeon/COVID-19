package com.miniPJT.covid19.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniPJT.covid19.mapper.SidoMapper;
import com.miniPJT.covid19.model.DaySido;
import com.miniPJT.covid19.model.TotalSido;

@Service
public class SidoServiceImpl implements SidoService {
	@Autowired
	private SqlSession session;

	@Override
	public void insertWeek(List<DaySido> list) throws Exception {
		session.getMapper(SidoMapper.class).insertWeek(list);
	}

	@Override
	public void insertToday(List<DaySido> list) throws Exception {
		session.getMapper(SidoMapper.class).insertToday(list);
	}
	
	@Override
	public void insertTotal(List<TotalSido> totalList) throws Exception {
		session.getMapper(SidoMapper.class).insertTotal(totalList);
	}
	
	@Override
	public List<TotalSido> selectTotal(String today) throws Exception {
		return session.getMapper(SidoMapper.class).selectTotal(today);
	}

	@Override
	public List<DaySido> selectToday(String today) throws Exception {
		return session.getMapper(SidoMapper.class).selectToday(today);
	}

	@Override
	public TotalSido selectYesterdayTotal(Map<String, String> yTotal) throws Exception {
		return session.getMapper(SidoMapper.class).selectYesterdayTotal(yTotal);
	}

	@Override
	public DaySido selectYesterdayToday(Map<String, String> yTotal) throws Exception {
		return session.getMapper(SidoMapper.class).selectYesterdayToday(yTotal);
	}

	@Override
	public List<TotalSido> selectWeek() throws Exception {
		return session.getMapper(SidoMapper.class).selectWeek();
	}

}
