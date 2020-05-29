package com.stock.vo;

import java.io.Serializable;

public class SectorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String sectorName;

	private String brief;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
}
	


