package com.miniPJT.covid19.model;

public class DaySido {
	private String stdDay;
	private String sido;
	private int defCnt;
	private int defTrans;
	private int deathCnt;
	private int deathTrans;
	
	public DaySido() {}
	
	public DaySido(String stdDay, String sido, int defCnt, int defTrans, int deathCnt, int deathTrans) {
		super();
		this.stdDay = stdDay;
		this.sido = sido;
		this.defCnt = defCnt;
		this.defTrans = defTrans;
		this.deathCnt = deathCnt;
		this.deathTrans = deathTrans;
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

	public int getDefTrans() {
		return defTrans;
	}

	public void setDefTrans(int defTrans) {
		this.defTrans = defTrans;
	}

	public int getDeathCnt() {
		return deathCnt;
	}

	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}

	public int getDeathTrans() {
		return deathTrans;
	}

	public void setDeathTrans(int deathTrans) {
		this.deathTrans = deathTrans;
	}
}
