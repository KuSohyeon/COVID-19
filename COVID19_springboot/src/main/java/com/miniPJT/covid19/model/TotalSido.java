package com.miniPJT.covid19.model;

public class TotalSido {
	private int totalDefCnt;
	private int totalDeathCnt;
	private int dayDefCnt;
	private int dayDeathCnt;
	private String stdDay;
	private String sido;
	
	public TotalSido() {}

	public TotalSido(int totalDefCnt, int totalDeathCnt, int dayDefCnt, int dayDeathCnt, String stdDay, String sido) {
		super();
		this.totalDefCnt = totalDefCnt;
		this.totalDeathCnt = totalDeathCnt;
		this.dayDefCnt = dayDefCnt;
		this.dayDeathCnt = dayDeathCnt;
		this.stdDay = stdDay;
		this.sido = sido;
	}

	public int getTotalDefCnt() {
		return totalDefCnt;
	}

	public void setTotalDefCnt(int totalDefCnt) {
		this.totalDefCnt = totalDefCnt;
	}

	public int getTotalDeathCnt() {
		return totalDeathCnt;
	}

	public void setTotalDeathCnt(int totalDeathCnt) {
		this.totalDeathCnt = totalDeathCnt;
	}

	public int getDayDefCnt() {
		return dayDefCnt;
	}

	public void setDayDefCnt(int dayDefCnt) {
		this.dayDefCnt = dayDefCnt;
	}

	public int getDayDeathCnt() {
		return dayDeathCnt;
	}

	public void setDayDeathCnt(int dayDeathCnt) {
		this.dayDeathCnt = dayDeathCnt;
	}

	public String getStdDay() {
		return stdDay;
	}

	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	
}
