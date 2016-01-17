package com.go2plus.core.specialTopic.service;

import java.util.List;

import com.go2plus.core.specialTopic.vo.SpecialTopic;

public interface SpecialTopicService {

  /**
   * 查询专题列表
   * 
   * @return 专题列表
   */
  public List<SpecialTopic> querySpecial();

  /**
   * 判断该产品是否正报名活动
   * @param productId 
   * 
   * @return
   */
  public boolean getApplyInfo(String productId);
}
