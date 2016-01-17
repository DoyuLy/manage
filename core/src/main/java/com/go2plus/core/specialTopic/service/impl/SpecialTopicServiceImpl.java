package com.go2plus.core.specialTopic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go2plus.core.specialTopic.dao.SpecialTopicDao;
import com.go2plus.core.specialTopic.service.SpecialTopicService;
import com.go2plus.core.specialTopic.vo.SpecialTopic;

@Service
public class SpecialTopicServiceImpl implements SpecialTopicService {
  @Resource
  private SpecialTopicDao specialTopicDao;

  @Override
  public List<SpecialTopic> querySpecial() {
    return specialTopicDao.querySpecial();
  }

  @Override
  public boolean getApplyInfo(String productId) {
    return specialTopicDao.getApplyInfo(productId);
  }

}
