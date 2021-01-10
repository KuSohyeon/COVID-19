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
	
	/** 오늘 날짜 insert(day) */
	@Override
	public void insertToday(List<DayGlobal> list) throws Exception {
		for(DayGlobal day : list) {
			sqlSession.getMapper(GlobalMapper.class).insertToday(day);
		}
	}
	
	/** 오늘 날짜 업데이트(day)*/
	@Override
	public void updateDayGlobal() throws Exception {
		sqlSession.getMapper(GlobalMapper.class).updateDayGlobal();
	}
	
	/** 오늘 날짜 insert(total) */
	@Override
	public void insertTotal() throws Exception {
		sqlSession.getMapper(GlobalMapper.class).insertTotal();
	}

	/** 나라별 오늘 확진자 정보 반환 */
	@Override
	public List<DayGlobal> todayGlobal() throws Exception {
		return sqlSession.getMapper(GlobalMapper.class).todayGlobal();
	}
	
	/** 오늘 날짜 총 확진자 반환  */
	@Override
	public TotalGlobal totalToday() throws Exception {
		return sqlSession.getMapper(GlobalMapper.class).totalToday();
	}
	
	/** 최근 7일 간 총 확진자 반환 */
	@Override
	public List<TotalGlobal> total7Days() throws Exception {
		return sqlSession.getMapper(GlobalMapper.class).total7Days();
	}

	
}
