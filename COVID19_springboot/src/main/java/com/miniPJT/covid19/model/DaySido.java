package com.miniPJT.covid19.model;

public class DaySido {
	private String stdDay;
	private String sido;
	private int dayDefCnt;
	private int dayDeathCnt;
	private int totalDefCnt;
	private int totalDeathCnt;
	
	public DaySido() {}

	public DaySido(String stdDay, String sido, int dayDefCnt, int dayDeathCnt, int totalDefCnt, int totalDeathCnt) {
		super();
		this.stdDay = stdDay;
		this.sido = sido;
		this.dayDefCnt = dayDefCnt;
		this.dayDeathCnt = dayDeathCnt;
		this.totalDefCnt = totalDefCnt;
		this.totalDeathCnt = totalDeathCnt;
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

}
