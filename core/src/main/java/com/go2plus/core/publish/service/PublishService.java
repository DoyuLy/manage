package com.go2plus.core.publish.service;

import java.util.List;

import org.springframework.stereotype.Service;
/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * PublishTaobaoService Service
 * 
 * @author duyu
 * @since 2015-11-23
 */

public interface PublishService {

	/**
	 * 获取token
	 * 
	 * @param subUrl
	 * @param type
	 * @return
	 */
	public String getEncrypt(String subUrl, String type);

	
}