package com.miniPJT.covid19.mapper;

import java.util.List;

import com.miniPJT.covid19.model.DayGlobal;
import com.miniPJT.covid19.model.TotalGlobal;

public interface GlobalMapper {

	/** 오늘 날짜 insert(day) */
	public void insertToday(DayGlobal dayGlobal) throws Exception;
	
	/** 오늘 날짜 업데이트(day)*/
	public void updateDayGlobal() throws Exception;
	
	/** 오늘 날짜 insert(total) */
	public void insertTotal() throws Exception;
	
	/** 나라별 오늘 확진자 정보 반환 */
	public List<DayGlobal> todayGlobal() throws Exception;
	
	/** 오늘 날짜 총 확진자 반환  */
	public TotalGlobal totalToday() throws Exception;
	
	/** 최근 7일 간 총 확진자 반환 */
	public List<TotalGlobal> total7Days() throws Exception;

	

	

}
