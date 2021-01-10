package com.miniPJT.covid19.model;

public class TotalGlobal {
	
	private String stdDay;
	private int defCnt;
	private int dayDefCnt;
	private int deathCnt;
	private int dayDeathCnt;
	
	public TotalGlobal() {}
	
	public TotalGlobal(String stdDay, int defCnt, int dayDefCnt, int deathCnt, int dayDeathCnt) {
		super();
		this.stdDay = stdDay;
		this.defCnt = defCnt;
		this.dayDefCnt = dayDefCnt;
		this.deathCnt = deathCnt;
		this.dayDeathCnt = dayDeathCnt;
	}

	public String getStdDay() {
		return stdDay;
	}

	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}

	public int getDefCnt() {
		return defCnt;
	}

	public void setDefCnt(int defCnt) {
		this.defCnt = defCnt;
	}

	public int getDayDefCnt() {
		return dayDefCnt;
	}

	public void setDayDefCnt(int dayDefCnt) {
		this.dayDefCnt = dayDefCnt;
	}

	public int getDeathCnt() {
		return deathCnt;
	}

	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}

	public int getDayDeathCnt() {
		return dayDeathCnt;
	}

	public void setDayDeathCnt(int dayDeathCnt) {
		this.dayDeathCnt = dayDeathCnt;
	}
	
}
