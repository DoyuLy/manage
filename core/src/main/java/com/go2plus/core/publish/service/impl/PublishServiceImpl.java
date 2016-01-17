package com.go2plus.core.publish.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go2plus.common.X;
import com.go2plus.common.http.HttpAgent;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.publish.dao.LogDownloadDao;
import com.go2plus.core.publish.dao.PublishDao;
import com.go2plus.core.publish.service.PublishService;
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
 * PublishTaobaoServiceImpl Service Impl
 * 
 * @author denglin
 * @since 2015-11-23
 */

@Service
public class PublishServiceImpl implements PublishService {

	@Resource
	private PublishDao publishDao;

	@Resource
	private LogDownloadDao logDownloadDao;

	/**
	 * 根据商品id验证是否可以发布到淘宝
	 * 
	 * @param userId
	 * @param pid
	 * @return
	 */
	@Override
	public List<TaobaoItem> getTaobaoItemsRecord(String userId, String pid) {
		// 从数据库中获取数据 用于验证是否还能发布
		List<TaobaoItem> taobaoItemRecords = publishDao.getTaobaoItemsRecord(
				userId, pid);

		return taobaoItemRecords;
	}

	@Override
	public List<TaobaoItem> getTaobaoList(int productId) {
		return publishDao.getTaobaoList(productId);
	}

	@Override
	public List<LogDownload> getDownloadList(int productId) {
		return logDownloadDao.getDownloadList(productId);
	}

	@Override
	public String getEncrypt(String subUrl, String type) {
		/*StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL("http://eapi.ximgs.net/oauth/taobao/getUrl?"
					+ subUrl);
			// "http://my.ximgs.net/oauth/taobao/getUrl?" + subUrl);
			String line;

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			connection.disconnect();

			System.out.println(sb.toString());

		} catch (Exception e) {

		}
		StringBuilder s = new StringBuilder(X.PUBLISH2TAOBAO_URL);
		// 一键发布项目前临时调用
		s.append(sb.toString());
		return s.toString();
		*/
		StringBuilder sb = new StringBuilder(X.PUBLISH2TAOBAO_URL);
		String result = HttpAgent.get("http://eapi.ximgs.net/oauth/taobao/getUrl?" + subUrl);
		return sb.append(result).toString();
	}

	@Override
	public List<ProductDownload> getDownloadProduct(String pid) {
		return publishDao.getDownloadProduct(pid);
	}

	@Override
	public Integer getDownOrLinkTimes(String userId) {
		return publishDao.getDownOrLinkTimes(userId);
	}

	@Override
	public List<ProductDownload> getProductBySupplierId(String userId,
			String pid) {
		return publishDao.getProductBySupplierId(userId, pid);
	}

	@Override
	public Product getFile(String pid) {
		return publishDao.getFile(pid);
	}

	@Override
	public LogDownload getProductLinkInfo(String userId, String pid) {
		return publishDao.getProductLinkInfo(userId, pid);
	}

	@Override
	public Integer updateProductLinkTimes(String logDownloadId,
			Integer times) {
		return publishDao.updateProductLinkTimes(logDownloadId, times);
	}

}
