package com.go2plus.core.backgroundManage.service;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import com.go2plus.core.backgroundManage.vo.ConsoleAd;
import com.go2plus.core.backgroundManage.vo.NavigationBar;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.OrderedFPs;
import com.go2plus.core.promotion.vo.Promotion;

public interface NavigationBarService {
  /**
   * 添加导航栏配置到数据库
   * 
   * @param navigationBar
   * @return 影响的记录条数
   */
  public int saveNavigationBar(NavigationBar navigationBar);

  /**
   * 修改导航栏配置
   * 
   * @param navigationBar
   * @return 影响的记录条数
   */
  public int updateNavigationBar(NavigationBar navigationBar);

  /**
   * 修改导航栏配置
   * 
   * @param id
   * @return 影响的记录条数
   */
  public int deleteNavigationBar(int id);

  /**
   * 根据导航条名称查询相关信息
   * 
   * @param serachNavigation
   * @return 导航条信息
   */
  public List<NavigationBar> selectNavigationBar(NavigationBar serachNavigation);

  /**
   * 加载导航栏名称
   * 
   * @param area
   * @return
   */
  public List<NavigationBar> queryNavigationBarName(String area);

  /**
   * 后台生成广告表
   * 
   * @param ConsoleAd
   * @return 影响的记录条数
   */
  public int saveConsoleAd(ConsoleAd ad);

  /**
   * 过滤可用广告 This method to generate an AES code
   * 
   * @param value
   * @return
   */
  public List<Promotion> getAvaiableFPs(Date lastDay, Date startTime, List<Promotion> occu);

  /**
   * 获取广告
   */
  public OrderedFPs getOrderedFPs(String FP_STRING);

  public TreeMap<String, Promotion> getOrderedUCsBy(Date startTime);
  public TreeMap<String, Date> getOrderedMRsBy();
  /**
   * 生成广告 This method to generate an AES code
   * 
   * @param value
   * @return
   */
  public int  addAD(List<AdPosition> ad);
  /**
   * 
   *删除已有类型广告
   *@param	value
   *@return
   */
  public int delAD(String type);
  /**
   * 最近删除的广告
   This method to generate an AES code
   	@param value 原始字符串
    @return 加密后的字符串
   * @throws Exception 
   */
  public List<String> getDeletedFPs(Integer seconds) throws Exception ;
}
