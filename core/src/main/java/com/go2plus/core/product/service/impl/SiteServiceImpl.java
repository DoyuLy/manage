package com.go2plus.core.product.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2plus.core.product.dao.SiteDao;
import com.go2plus.core.product.service.SiteService;
import com.go2plus.core.product.vo.Site;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * @Description: this is SiteServiceImpl
 * @author: liyang
 * @Date: 2015-12-9 17:46:37
 */
@Service
public class SiteServiceImpl implements SiteService {
  @Autowired
  private SiteDao siteDao;

  public List<Site> findPageList(Map<String, Object> queryMap) {
    Integer counter = siteDao.findCount(queryMap);
    queryMap.put("totalRow", counter);
    List<Site> list = siteDao.findPageList(queryMap);
    return list;
  }

  /*
   * public List<Site> findList() throws SystemException { List<Site> list =siteDao.findList(); return list; }
   */
  public Site findById(Integer id) {
    Site site = siteDao.findById(id);
    return site;
  }

  public void add(Site site) {
    siteDao.insert(site);
  }

  public void update(Site site) {
    siteDao.update(site);
  }

  public boolean save(Site siteForm) {
    Site site = null;
    if (siteForm.getId() == null) {
      site = new Site();
    } else {
      site = findById(siteForm.getId());
    }
    if (site != null) {
      site.setUserId(siteForm.getUserId());
      site.setSubdomain(siteForm.getSubdomain());
      site.setState(siteForm.getState());
      site.setCreateTime(siteForm.getCreateTime());
      site.setUpdateTime(siteForm.getUpdateTime());

      if (site.getId() != null && site.getId() > 0) {
        update(site);
      } else {
        add(site);
      }
      return true;
    }
    return false;
  }

  public void delete(String[] selectedIds) {
    Integer len = selectedIds.length;
    for (int i = 0; i < len; i++) {
      String id = selectedIds[i];
      if (StringUtils.isNotBlank(id)) {
        delete(Integer.parseInt(id));
      }
    }
  }

  public void delete(Integer id) {
    siteDao.delete(id);
  }

}
