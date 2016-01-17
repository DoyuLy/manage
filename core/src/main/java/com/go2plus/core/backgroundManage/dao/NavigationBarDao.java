package com.go2plus.core.backgroundManage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.backgroundManage.vo.ConsoleAd;
import com.go2plus.core.backgroundManage.vo.NavigationBar;

@Repository
public interface NavigationBarDao extends DAO {

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
  public Integer deleteNavigationBar(int id);

  /**
   * 根据导航条名称查询相关信息
   * 
   * @param navigationName
   * @return 导航条信息
   */
  public List<NavigationBar> selectNavigationBar(NavigationBar navigationName);

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
}
