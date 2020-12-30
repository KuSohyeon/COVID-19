package com.miniPJT.covid19.model;

public class TotalGlobal {
	private int defCnt;
	private int deathCnt;
	
	public TotalGlobal() {}

	public TotalGlobal(int defCnt, int deathCnt) {
		super();
		this.defCnt = defCnt;
		this.deathCnt = deathCnt;
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
