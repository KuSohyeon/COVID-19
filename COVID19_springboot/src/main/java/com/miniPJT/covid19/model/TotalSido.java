package com.miniPJT.covid19.model;

public class TotalSido {
	private int defCnt;
	private int deathCnt;
	private String stdDay;
	private String sido;
	
	public TotalSido() {}

	public TotalSido(int defCnt, int deathCnt, String stdDay, String sido) {
		super();
		this.defCnt = defCnt;
		this.deathCnt = deathCnt;
		this.stdDay = stdDay;
		this.sido = sido;
	}

	public int getDefCnt() {
		return defCnt;
	}

	public void setDefCnt(int defCnt) {
		this.defCnt = defCnt;
	}

	public int getDeathCnt() {
		return deathCnt;
	}

	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
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
