package com.go2plus.core.promotion.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 广告模块验证基础功能
 * 
 * @Description: TODO
 * @author lhc
 * @date 2015-12-10
 * 
 */
public interface ValidatorService {

	/**
	 * 判断日期参数是否满足指定格式
	 * 
	 * @param date
	 *            日期参数
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public boolean isDate(String date, String pattern);

	/**
	 * 判断广告位及编号是否符号标准
	 * 
	 * @param posX
	 * @param type
	 * @return
	 */
	public boolean isPosX(String posX, String type);

	/**
	 * 判断指定键是否已在集合中设置过
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public boolean isSet(Map<String, ?> map, String key);

	/**
	 * 判断指定键是否已在集合中设置过
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	public boolean isSet(List<String> list, String key);

	/**
	 * 验证两个hash值是否相同
	 * 
	 * @param sHash
	 *            hash值1
	 * @param tHash
	 *            hash值2
	 * @return
	 * @throws Exception
	 */
	public boolean isPass(String sHash, String tHash) throws Exception;

	/**
	 * 推荐广告位是否可用
	 * 
	 * @param posX
	 * @param startTime
	 * @return
	 */
	public boolean isAvaiableFP(String posX, Date startTime);
	/**
   * 各广告位是否可用
   * 
   * @param posX
   * @param startTime
   * @return
   */
	public boolean isAvaiableAD(String type);

	/**
	 * 日期格式转换
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public Date toDate(String date) throws Exception;

	/**
	 * 日期格式转换
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public String toDate(Date date) throws Exception;

	/**
	 * 获取添加数周的日期时间
	 * 
	 * @param date
	 * @param num
	 * @return
	 */
	public Date addDay(Date date, Integer num);
	public Date addWeek(Date date, Integer num);
	public Date addWeek7(Date date, Integer num);
	public Date subWeek7(Date date, Integer num);
	public int  getWeek7(Date date);
	/**
	 * 取时间戳的短整数
	 * 
	 * @param date
	 * @return
	 */
	public Long strtotime(Date date);

	/**
	 * 获取连个日期的间隔周数
	 * 
	 * @param lastDay
	 * @param startTime
	 * @return
	 */
	public Integer getWeekNum(Date lastDay, Date startTime);

	/**
	 * 判断是否在指定的黑名单内
	 * 
	 * @param userId
	 * @return
	 */
	public boolean disableFunc(Integer userId);

	/**
	 * 判断是否黑名单中
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isOnBlackList(Integer userId);

	/**
	 * 判断是否为TOP100厂家
	 * 
	 * @param userId
	 * @return
	 */
	public Boolean isTop100Supplier(Integer userId);
}
