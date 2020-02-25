package com.yc.spring.bank.bean;

import java.sql.Date;

public class Record {
	
	private Integer id;
	private Integer accountId;
	private Double opmoney;
	private Date opdate;
	
	public Record() {
	}

	public Record(Integer accountId, Double opmoney, Date opdate) {
		super();
		this.accountId = accountId;
		this.opmoney = opmoney;
		this.opdate = opdate;
	}

	public Record(Integer id, Integer accountId, Double opmoney, Date opdate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.opmoney = opmoney;
		this.opdate = opdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Double getOpmoney() {
		return opmoney;
	}
	public void setOpmoney(Double opmoney) {
		this.opmoney = opmoney;
	}
	public Date getOpdate() {
		return opdate;
	}
	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", accountId=" + accountId + ", opmoney=" + opmoney + ", opdate=" + opdate + "]";
	}

}
