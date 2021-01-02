package com.miniPJT.covid19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniPJT.covid19.model.DayGlobal;
import com.miniPJT.covid19.model.TotalGlobal;
import com.miniPJT.covid19.service.GlobalService;

@RestController
@CrossOrigin
@RequestMapping("/global")
public class GlobalController {
	@Autowired
	private GlobalService globalService;
	
	@GetMapping("/today/countries")
	private List<DayGlobal> todayCountries(){
		List<DayGlobal> list = null;
		try {
			list = globalService.todayGlobal();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오늘 나라 별 총 확진자 조회 오류" + e);
		}
		return list;
	}
	
	@GetMapping("/today/total")
	private TotalGlobal totalGlobalToday() {
		TotalGlobal totalGlobal = null;
		try {
			totalGlobal = globalService.totalToday();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오늘 세계 총 확진자 조회 오류" + e);
		}
		return totalGlobal;
	}
	
	@GetMapping("/today/total/week")
	private List<TotalGlobal> totalGlobal7Days() {
		List<TotalGlobal> totalGlobal = null;
		try {
			totalGlobal = globalService.total7Days();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("이번 주 세계 총 확진자 조회 오류" + e);
		}
		return totalGlobal;
	}
	
}
