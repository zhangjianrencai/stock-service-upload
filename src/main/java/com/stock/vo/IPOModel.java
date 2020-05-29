package com.stock.vo;

import java.io.Serializable;

public class IPOModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String companyId;
	private String exchangeId;
	private String price;
	private String shares;
	private String remarks;
	private String dataTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void String(String dataTime) {
		this.dataTime = dataTime;
	}
}
	


