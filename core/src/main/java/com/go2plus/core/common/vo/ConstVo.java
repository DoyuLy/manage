package com.go2plus.core.common.vo;

public class ConstVo {
	public static final String THUMB_URL_PREFIX = "http://thumb.w3.ximgs.net/thumbs";
	public static String imgReplace(String src, int scale) {
		String arr[] = src.split(".");
		String temp = "_" + scale + "x" + scale;
		String str = arr[0].concat(temp).concat(arr[1]);
		return str;
	}
}
