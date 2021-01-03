package com.miniPJT.covid19.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.miniPJT.covid19.model.DayGlobal;
import com.miniPJT.covid19.service.GlobalService;

@Configuration
@EnableScheduling
public class GlobalScheduleConfig {
//	@Bean
//	public TaskScheduler schduler() {
//		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//		scheduler.setPoolSize(4);
//		return scheduler;
//	}
	
	@Autowired
	private GlobalService globalService;
	@Autowired
	private GlobalAPIExplorer globalApi;
	
	//매일 아침 11시마다 업데이트
	@Scheduled(cron = "0 0 11 * * *")
	private void globalJob() throws InterruptedException{
		List<DayGlobal> list = null;
		try {
			list = globalApi.save();
//			System.out.println(list);
			globalService.insertToday(list); // 오늘 day_global insert
			globalService.updateDayGlobal(); // 오늘 나라별 추가 확진자 update(day_global) 
			globalService.insertTotal(); // 오늘 세계 총 확진자(total_global) insert
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
