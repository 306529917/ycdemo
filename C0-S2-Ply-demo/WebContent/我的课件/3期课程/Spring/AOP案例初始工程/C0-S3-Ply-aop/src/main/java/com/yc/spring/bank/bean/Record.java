package com.yc.spring.bank.bean;

import java.sql.Timestamp;

public class Record {
	
	private Integer id;
	// 账号
	private Integer accountId;
	// 操作金额（存款、取款、转账、利息。。。）
	private Double opmoney;
	// 手续费（转账）
	private Double charge;
	// 操作时间
	private Timestamp opdate;
	
	public Record() {
	}

	public Record(Integer accountId, Double opmoney, Timestamp opdate) {
		super();
		this.accountId = accountId;
		this.opmoney = opmoney;
		this.opdate = opdate;
	}

	public Record(Integer id, Integer accountId, Double opmoney, Timestamp opdate) {
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
	public Timestamp getOpdate() {
		return opdate;
	}
	public void setOpdate(Timestamp opdate) {
		this.opdate = opdate;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}


}
