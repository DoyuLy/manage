package com.go2plus.core.promotion.vo;


public class HashPromotion {

	private Promotion promotion;

	private String hash;

	public HashPromotion(Promotion promotion, String hash) {
		super();
		this.promotion = promotion;
		this.hash = hash;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
