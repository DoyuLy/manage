package com.go2plus.core.specialTopic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.specialTopic.vo.SpecialTopic;

@Repository
public interface SpecialTopicDao extends DAO {

  /**
   * 查询专题列表
   * 
   * @return 专题列表
   */
  List<SpecialTopic> querySpecial();
  /**
   * 判断该产品是否正报名活动
   * @param productId 
   * 
   * @return
   */
  boolean getApplyInfo(String productId);

}
