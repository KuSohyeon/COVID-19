package com.miniPJT.covid19.model;

public class DayGlobal {
	private String stdDay;
	private String areaName;
	private String nationName;
	private int defCnt;
	private int deathCnt;
	
	public DayGlobal() {}

	public DayGlobal(String stdDay, String areaName, String nationName, int defCnt, int deathCnt) {
		super();
		this.stdDay = stdDay;
		this.areaName = areaName;
		this.nationName = nationName;
		this.defCnt = defCnt;
		this.deathCnt = deathCnt;
	}

	public String getStdDay() {
		return stdDay;
	}

	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
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
