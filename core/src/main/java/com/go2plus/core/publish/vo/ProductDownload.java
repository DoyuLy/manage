package com.go2plus.core.publish.vo;

import com.go2plus.core.product.vo.Product;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.User;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * @category 下载产品信息
 * @author duyu
 * 
 */
public class ProductDownload extends Product{
	private User user;
	private Supplier supllier;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Supplier getSupllier() {
		return supllier;
	}
	public void setSupllier(Supplier supllier) {
		this.supllier = supllier;
	}
}

