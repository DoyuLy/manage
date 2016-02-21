package com.go2plus.core.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>User: mtwu
 * <p>Date: @2014-9-5
 * <p>Version: 1.0
 */
public class UnicodeUtils {

  /**
   * 把中文转成Unicode码
   * 
   * @param str
   * @return
   */
  public static String chinaToUnicode(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      int chr1 = (char) str.charAt(i);
      if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
        result += "\\u" + Integer.toHexString(chr1);
      } else {
        result += str.charAt(i);
      }
    }
    return result;
  }

  /**
   * 判断是否为中文字符
   * 
   * @param c
   * @return
   */
  public static boolean isChinese(char c) {
    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
      return true;
    }
    return false;
  }

  public static String unicodeEncode(String strText) {
    char c;
    String strRet = "";
    int intAsc;
    String strHex;
    for (int i = 0; i < strText.length(); i++) {
      c = strText.charAt(i);
      intAsc = c;
      if (intAsc > 128) {
        strHex = Integer.toHexString(intAsc);
        strRet += "\\u" + strHex;
      } else {
        strRet = strRet + c;
      }
    }
    return strRet;
  }

  public static String unicodeDecode(String strText) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    char c;
    while (i < strText.length()) {
      c = strText.charAt(i);
      if (c == '\\' && (i + 1) != strText.length() && strText.charAt(i + 1) == 'u') {
        sb.append((char) Integer.parseInt(strText.substring(i + 2, i + 6), 16));
        i += 6;
      } else {
        sb.append(c);
        i++;
      }
    }
    return sb.toString();
  }

  public static String string2Unicode(String s) {
    try {
      StringBuffer out = new StringBuffer("");
      byte[] bytes = s.getBytes("unicode");
      for (int i = 2; i < bytes.length - 1; i += 2) {
        out.append("u");
        String str = Integer.toHexString(bytes[i + 1] & 0xff);
        for (int j = str.length(); j < 2; j++) {
          out.append("0");
        }
        String str1 = Integer.toHexString(bytes[i] & 0xff);

        out.append(str);
        out.append(str1);
        out.append(" ");
      }
      return out.toString().toUpperCase();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
