package com.miniPJT.covid19.mapper;

import java.util.List;
import java.util.Map;

import com.miniPJT.covid19.model.DaySido;
import com.miniPJT.covid19.model.TotalSido;

public interface SidoMapper {

	public void insertToday(List<DaySido> list) throws Exception;

	public void insertWeek(List<DaySido> list) throws Exception;

	public void insertTotal(List<TotalSido> list) throws Exception;

	public List<TotalSido> selectTotal(String today) throws Exception;

	public List<DaySido> selectToday(String today) throws Exception;

	public TotalSido selectYesterdayTotal(Map<String, String> yTotal) throws Exception;

}
