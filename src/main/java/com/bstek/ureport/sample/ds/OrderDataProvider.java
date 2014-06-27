package com.bstek.ureport.sample.ds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bstek.ureport.datasource.ReportDataProvider;
import com.bstek.ureport.model.Parameter;
import com.bstek.ureport.sample.model.Order;

/**
 * @author Lucas 2014-6-26
 */
public class OrderDataProvider implements ReportDataProvider<Order> {
	public List<Order> provide(String arg0, List<Parameter> arg1) {
		List<Order> orderList = new ArrayList<Order>();
		Calendar date = Calendar.getInstance();
		for (int i = 0; i < 1000; i++) {
			Order o = new Order();
			String id = "OD";
			if (i < 10) {
				id += "000" + i;
			} else if (i < 100) {
				id += "00" + i;
			} else if (i < 1000) {
				id += "0" + i;
			} else {
				id += "" + i;
			}
			o.setId(id);
			o.setAmount(getRandomInt(1, 100));
			o.setCompanyId(getRandomCompany());//
			o.setCustomerId(getRandomCustomer());
			o.setMoney(getRandomDouble(10000, 100000));
			date.setTime(getRandomDate());
			o.setCreateDate(date.getTime());
			o.setMonth(date.get(Calendar.MONTH) + 1);
			o.setYear(date.get(Calendar.YEAR));
			o.setReachDate(date.getTime());
			o.setSignPerson(getSignPerson());
			orderList.add(o);
		}
		Collections.sort(orderList, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getMonth() - o2.getMonth() > 0 ? 1 : 0;
			}
		});
		return orderList;
	}

	public String getRandomCustomer() {
		List<String> sList = new ArrayList<String>();
		sList.add("丁丹丹");
		sList.add("袁磊");
		sList.add("任周磊");
		sList.add("刘春华");
		sList.add("侯继红");
		sList.add("龙江涛");
		sList.add("丁惠清");
		sList.add("方琳");
		sList.add("汤燕");
		sList.add("余洁");
		sList.add("余然");
		return sList.get(getRandomInt(1, 10));
	}

	public String getRandomCompany() {
		List<String> sList = new ArrayList<String>();
		sList.add("北京商贸乐公司");
		sList.add("天天数码公司");
		sList.add("广州万海资科技公司");
		sList.add("佛山普乐华科技公司");
		sList.add("卡西里(上海)贸易公司");
		sList.add("杭州味有食品公司");
		sList.add("亮量科技公司");
		sList.add("贝因美工技术有限公司");
		sList.add("智德友信息技术有限公司");
		sList.add("华天技术有限公司");
		sList.add("余然科技公司");
		return sList.get(getRandomInt(1, 10));
	}

	public String getSignPerson() {
		List<String> sList = new ArrayList<String>();
		sList.add("丁丹丹");
		sList.add("袁磊");
		sList.add("任周磊");
		sList.add("刘春华");
		sList.add("侯继红");
		sList.add("龙江涛");
		sList.add("丁惠清");
		sList.add("方琳");
		sList.add("汤燕");
		sList.add("余洁");
		sList.add("余然");
		return sList.get(getRandomInt(1, 10));
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Date getRandomDate() {
		List<String> dList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			/*
			 * if (i < 2) { dList.add("2012-" + getRandomInt(1, 12) + "-" +
			 * getRandomInt(3, 29)); } else if (i < 8) { dList.add("2013-" +
			 * getRandomInt(1, 12) + "-" + getRandomInt(3, 29)); } else {
			 * dList.add("2014-" + getRandomInt(1, 12) + "-" + getRandomInt(3,
			 * 29)); }
			 */
			dList.add("2014-" + getRandomInt(1, 10) + "-" + getRandomInt(3, 29));
		}
		try {
			return sdf.parse(dList.get(getRandomInt(0, 9)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	static Random random = new Random();

	private double getRandomDouble(int min, int max) {
		while (true) {
			double t = random.nextDouble() * 100000;
			if (t >= min && t <= max) {
				return t;
			}
		}
	}

	private int getRandomInt(int min, int max) {
		while (true) {
			int t = random.nextInt(max);
			if (t >= min && t <= max) {
				return t;
			}
		}
	}

	@SuppressWarnings("unused")
	private String getRandomId(String prefix, int num) {
		String idStr = prefix;
		boolean flag = true;
		while (flag) {
			int id = random.nextInt(num);
			if (id > 0) {
				if (id < 10) {
					idStr += "000" + id;
					flag = false;
				} else if (id < 100) {
					idStr += "00" + id;
					flag = false;
				} else if (id < 1000) {
					idStr += "0" + id;
					flag = false;
				} else {
					idStr += "" + id;
					flag = false;
				}
			} else {
				continue;
			}
		}
		return idStr;
	}

}
