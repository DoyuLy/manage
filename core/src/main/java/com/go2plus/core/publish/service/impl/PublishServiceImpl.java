package com.go2plus.core.publish.service.impl;

import org.springframework.stereotype.Service;

import com.go2plus.common.X;
import com.go2plus.common.http.HttpAgent;
import com.go2plus.core.publish.service.PublishService;

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
}
