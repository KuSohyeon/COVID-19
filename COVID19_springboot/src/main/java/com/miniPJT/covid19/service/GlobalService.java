package com.miniPJT.covid19.service;

import java.util.List;

import com.miniPJT.covid19.model.DayGlobal;
import com.miniPJT.covid19.model.TotalGlobal;


public interface GlobalService {
	
	/** 오늘 날짜 insert(day) */
	void insertToday(List<DayGlobal> list) throws Exception;
	
	/** 오늘 날짜 업데이트(day)*/
	void updateDayGlobal() throws Exception;
	
	/** 오늘 날짜 insert(total) */
	void insertTotal() throws Exception;
	
	/** 나라별 오늘 확진자 정보 반환 */
	List<DayGlobal> todayGlobal() throws Exception;
	
	/** 오늘 날짜 총 확진자 반환  */
	TotalGlobal totalToday() throws Exception;
	
	/** 최근 7일 간 총 확진자 반환 */
	List<TotalGlobal> total7Days() throws Exception;

}
