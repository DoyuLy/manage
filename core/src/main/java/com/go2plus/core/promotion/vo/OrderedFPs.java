package com.go2plus.core.promotion.vo;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;


public class OrderedFPs {

	// 位置最早的结束时间
	private TreeMap<String, Date> data;
	// 位置被占用
	private TreeMap<String, List<Promotion>> occu;
	// 是否中断
	private TreeMap<String, Integer> term;

	public TreeMap<String, Date> getData() {
		return data;
	}

	public void setData(TreeMap<String, Date> data) {
		this.data = data;
	}

	public TreeMap<String, List<Promotion>> getOccu() {
		return occu;
	}

	public void setOccu(TreeMap<String, List<Promotion>> occu) {
		this.occu = occu;
	}

	public TreeMap<String, Integer> getTerm() {
		return term;
	}

	public void setTerm(TreeMap<String, Integer> term) {
		this.term = term;
	}

}
