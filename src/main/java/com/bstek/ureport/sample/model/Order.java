package com.bstek.ureport.sample.model;

import java.util.Date;

/**
 * @author Lucas 订单
 */
public class Order {
	private String id;
	private String companyId;
	private String customerId;
	private int amount;
	private double money;
	private int year;
	private int month;
	private Date createDate;
	private Date reachDate;
	private String signPerson;
	private String desc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Date getReachDate() {
		return reachDate;
	}

	public void setReachDate(Date reachDate) {
		this.reachDate = reachDate;
	}

	public String getSignPerson() {
		return signPerson;
	}

	public void setSignPerson(String signPerson) {
		this.signPerson = signPerson;
	}
}
