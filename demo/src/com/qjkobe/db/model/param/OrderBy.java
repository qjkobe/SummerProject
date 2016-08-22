package com.qjkobe.db.model.param;

public class OrderBy {
	private String orderName;
	private String orderSort;

	public OrderBy(String orderName, String orderSort) {
		this.orderName = orderName;
		this.orderSort = orderSort;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public void setOrderSort(String orderSort) {
		this.orderSort = orderSort;
	}

	public String getOrderName() {
		return orderName;
	}

	public String getOrderSort() {
		return orderSort;
	}
}
