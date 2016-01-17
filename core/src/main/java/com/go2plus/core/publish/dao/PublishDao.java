package com.go2plus.core.publish.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.publish.vo.ProductDownload;
import com.go2plus.core.publish.vo.TaobaoItem;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * PublishTaobaoDao
 * 
 * @author denglin
 * @since 2015-11-23
 */

public interface PublishDao extends DAO {

	/**
	 * 根据用户Id和pid 查找已经被该人发布的该商品信息
	 * 
	 * @param userId
	 * @param table
	 * @return
	 */
	public List<TaobaoItem> getTaobaoItemsRecord(
			@Param("userId") String userId, @Param("productId") String productId);

	/**
	 * 产品发布到淘宝的记录
	 * 
	 * @param productId
	 * @return
	 */
	public List<TaobaoItem> getTaobaoList(int productId);

	/**
	 * 获取下载产品信息
	 * 
	 * @param pid
	 */
	public List<ProductDownload> getDownloadProduct(String pid);

	/**
	 * 户当天下载或者外连的次数
	 * 
	 * @param userId
	 * @return
	 */
	public Integer getDownOrLinkTimes(String userId);
	
	/**
	 * 下载页面关联得用户商品
	 * @param userId
	 * @param pid
	 * @return
	 */
	public List<ProductDownload> getProductBySupplierId(@Param("userId") String userId,  @Param("pid") String pid);

	
	/**
	 * 根据pid获取商品压缩包信息
	 * @param pid
	 * @return
	 */
	public Product getFile(String pid);
	
	/**
	 * 获取产品的关联记录信息
	 * @param userId
	 * @param pid
	 * @return
	 */
	public LogDownload getProductLinkInfo(@Param("userId") String userId,  @Param("pid") String pid);
	
	/**
	 * 修改产品外联次数
	 * @param logDownloadId 
	 * @param logDownload
	 * @return
	 */
	public Integer updateProductLinkTimes(String logDownloadId,
			Integer times);
}
