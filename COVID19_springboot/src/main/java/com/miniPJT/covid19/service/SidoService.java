package com.miniPJT.covid19.service;

import java.util.List;
import java.util.Map;

import com.miniPJT.covid19.model.DaySido;
import com.miniPJT.covid19.model.TotalSido;

public interface SidoService {
	public void insertWeek(List<DaySido> list) throws Exception;
	public void insertToday(List<DaySido> list) throws Exception;
	public void insertTotal(List<TotalSido> totalList) throws Exception;
	public List<TotalSido> selectTotal(String today) throws Exception;
	public List<DaySido> selectToday(String today) throws Exception;
	public TotalSido selectYesterdayTotal(Map<String, String> yTotal) throws Exception;
}
