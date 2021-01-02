package com.miniPJT.covid19.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	// 20210101
	public static String format() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(now);
	}
	// 2021-01-01
	public static String formatDash() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(now);
	}
}
