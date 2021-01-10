package com.miniPJT.covid19.model;

public class DaySido {
	private String stdDay;
	private String sido;
	private int defCnt;
	private int deathCnt;
	
	public DaySido() {}
	
	public DaySido(String stdDay, String sido, int defCnt, int deathCnt) {
		super();
		this.stdDay = stdDay;
		this.sido = sido;
		this.defCnt = defCnt;
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

}
