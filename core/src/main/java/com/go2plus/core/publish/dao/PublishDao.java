package com.go2plus.core.publish.dao;


import com.go2plus.common.mvc.DAO;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * PublishTaobaoDao
 * 
 * @author duyu
 * @since 2015-11-23
 */

public interface PublishDao extends DAO {
	
	/**
	 * 修改产品外联次数
	 * @param logDownloadId 
	 * @param logDownload
	 * @return
	 */
	public Integer updateProductLinkTimes(String logDownloadId,
			Integer times);
}
