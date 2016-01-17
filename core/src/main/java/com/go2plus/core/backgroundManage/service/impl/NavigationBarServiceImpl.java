package com.go2plus.core.backgroundManage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2plus.core.backgroundManage.dao.NavigationBarDao;
import com.go2plus.core.backgroundManage.service.NavigationBarService;
import com.go2plus.core.backgroundManage.vo.ConsoleAd;
import com.go2plus.core.backgroundManage.vo.NavigationBar;
import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.OrderedFPs;
import com.go2plus.core.promotion.vo.Promotion;

@Service
public class NavigationBarServiceImpl implements NavigationBarService {

  @Resource
  private NavigationBarDao navigationBarDao;
  @Autowired
  private PromotionDao     promotionDao;
  @Autowired
  private ValidatorService validatorService;

  @Override
  public int saveNavigationBar(NavigationBar navigationBar) {
    return navigationBarDao.saveNavigationBar(navigationBar);
  }

  @Override
  public int updateNavigationBar(NavigationBar navigationBar) {
    return navigationBarDao.updateNavigationBar(navigationBar);
  }

  @Override
  public int deleteNavigationBar(int id) {
    return navigationBarDao.deleteNavigationBar(id);
  }

  @Override
  public List<NavigationBar> selectNavigationBar(NavigationBar navigationName) {
    return navigationBarDao.selectNavigationBar(navigationName);
  }

  @Override
  public List<NavigationBar> queryNavigationBarName(String area) {
    return navigationBarDao.queryNavigationBarName(area);
  }

  @Override
  public int saveConsoleAd(ConsoleAd ad) {
    return navigationBarDao.saveConsoleAd(ad);
  }

  @Override
  public List<Promotion> getAvaiableFPs(Date lastDay, Date startTime, List<Promotion> occu) {
    if (startTime.after(lastDay)) {
      return null;
    }
    List<Promotion> list = new ArrayList<>();
    // 向前增加的周数
    int weekNum = validatorService.getWeekNum(lastDay, startTime);
    for (int i = 0; i < weekNum; i++) {
      Date date = validatorService.addWeek7(startTime, i);
      boolean hasOccu = false;
      if (occu.size() != 0) {
        for (Promotion promotion : occu) {
          if (date.equals(promotion.getStartTime())) {
            hasOccu = true;
            break;
          }
        }
      }
      if (!hasOccu) {
        Promotion promotion = new Promotion();
        promotion.setStartTime(date);
        promotion.setEndTime(validatorService.addWeek(date, 1));
        list.add(promotion);
      }
    }
    return list;
  }

  @Override
  public OrderedFPs getOrderedFPs(String FP_STRING) {
    List<Promotion> list = promotionDao.getOrderedFPs(FP_STRING);
    // 位置最早的结束时间
    TreeMap<String, Date> data = new TreeMap<>();
    // 位置被占用
    TreeMap<String, List<Promotion>> occu = new TreeMap<>();
    // 是否中断
    TreeMap<String, Integer> term = new TreeMap<>();

    if (list != null) {
      for (Promotion promotion : list) {
        if (!validatorService.isSet(data, promotion.getPosX())) {
          data.put(promotion.getPosX(), promotion.getEndTime());
        } else {
          // 覆盖结束时间
          if (promotion.getStartTime() == data.get(promotion.getPosX())) {
            if (validatorService.isSet(term, promotion.getPosX())) {
              List<Promotion> promotions = occu.get(promotion.getPosX());
              if (promotions == null) {
                promotions = new ArrayList<>();
              }
              promotions.add(promotion);
              occu.put(promotion.getPosX(), promotions);
            } else {
              data.put(promotion.getPosX(), promotion.getEndTime());
            }
          } else {
            term.put(promotion.getPosX(), 1);
            List<Promotion> promotions = occu.get(promotion.getPosX());
            if (promotions == null) {
              promotions = new ArrayList<>();
            }
            promotions.add(promotion);
            occu.put(promotion.getPosX(), promotions);
          }
        }
      }
      OrderedFPs fPs = new OrderedFPs();
      fPs.setData(data);
      fPs.setOccu(occu);
      fPs.setTerm(term);
      return fPs;
    }
    return null;
  }

  @Override
  public TreeMap<String, Promotion> getOrderedUCsBy(Date startTime) {
    TreeMap<String, Promotion> map = new TreeMap<>();
    List<Promotion> list = promotionDao.getOrderedUCsBy(startTime);
    if (list != null) {
      for (Promotion promotion : list) {
        map.put(promotion.getPosX(), promotion);
      }
    }
    return map;
  }
  @Override
  public TreeMap<String, Date> getOrderedMRsBy() {
    TreeMap<String, Date> map = new TreeMap<>();
    List<Promotion> list = promotionDao.getOrderedMRsBy();
    if (list != null) {
      for (Promotion promotion : list) {
        if(!validatorService.isSet(map, promotion.getPosX())){
          map.put(promotion.getPosX(), promotion.getEndTime());
        }else{
          if(map.get(promotion.getPosX()).before(promotion.getEndTime())){
            map.put(promotion.getPosX(),promotion.getEndTime());
          }
        }
      }
    }
    return map;
  }
  @Override
  public int addAD(List<AdPosition> ad) {
    return promotionDao.addBatchAD(ad);
  }
  @Override
  public int delAD(String type) {
    return promotionDao.delAD(null, null, type);
  }
  @Override
  public List<String> getDeletedFPs(Integer seconds) throws Exception {
    if (seconds == null) {
      seconds = 600;
    }
    List<String> list = new ArrayList<>();
    List<Promotion> promotions = promotionDao.getDeletedFPs(seconds);
    if (promotions != null) {
      for (Promotion promotion : promotions) {
        list.add(promotion.getPosX() + "_" + validatorService.toDate(promotion.getStartTime()));
      }
    }
    return list;
  }
}
