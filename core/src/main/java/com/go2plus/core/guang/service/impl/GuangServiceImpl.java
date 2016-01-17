
package com.go2plus.core.guang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.go2plus.common.json.Json;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.guang.dao.GuangDao;
import com.go2plus.core.guang.service.GuangService;
import com.go2plus.core.guang.vo.Guang;
import com.google.gson.reflect.TypeToken;
/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
GuangService的实现类
@author liyang
*/
@Service
public class GuangServiceImpl implements GuangService{
  @Resource
  private GuangDao guangDao;

  /**
   * 根据条件查询逛逛列表，条件参数封装到guang对象里
   * @param guang
   * @return List<Guang>逛逛列表
   */
  @Override
  public List<Guang> getGuangProductList(Guang guang,String user_id) {
    List<Guang> guangs = guangDao.getGuangProductList(guang);
    //用户id，cookie中取出 
    String userKey = "guanglike"+user_id;
    
    if(RedisUtil.isConnectRedis()){
      List<String> productIdList = null;
      if(RedisUtil.exists(userKey)){
        String jsonList = RedisUtil.get(userKey);
        productIdList = (List<String>) Json.fromJson(jsonList, new TypeToken<List<String>>(){}.getType());
      }
      //加入用户是否喜欢和每件商品喜欢的人数
      for (int i = 0; i < guangs.size(); i++) {
        Guang g = guangs.get(i);
        String key = "go2:guang_product"+g.getProductId()+"_like"; 
       
        if(!StringUtils.isEmpty(RedisUtil.get(key))){
          g.setLikeNum(Integer.parseInt(RedisUtil.get(key)));
        }else{
          g.setLikeNum(0);
        }
        //查看用户是否已经喜欢
        if(productIdList!=null){
          if(productIdList.indexOf(g.getProductId()+"")!=-1){
            g.setLike(true);
          }
        }
      }
    }
    
    return guangs;
  }
  /**
   * 按条件查询逛逛的总数
   * @param guang
   * @return int型的逛逛总数
   */
  @Override
  public Integer getGuangProductTotal(Guang guang) {
    int total = guangDao.getGuangProductTotal(guang);
    return total;
  }
  
  /**
   * 查询当季热卖的数量,并用redis缓存
   * @return 返回一个map,对应每种的数量
   */
  @Override
  public HashMap<String, String> getCountCategorys() {
    String countCategorysRedisKey = "countCategoryMap";
    HashMap<String, String> countCategoryMap = new HashMap<>();
    String[] categoryArray = {"1","2","3","4","5","6","7","乐福鞋","平底鞋","高跟鞋","厚底鞋"};
    
    //当redis连接失败，直接查询数据库
    if(!RedisUtil.isConnectRedis()){
      for (int i = 0; i < categoryArray.length; i++) {
        int countCategory = guangDao.getCountEveryCategory(categoryArray[i]);
        countCategoryMap.put(categoryArray[i], countCategory+"");
      }
      return countCategoryMap;
    }
    
    Jedis jedis = RedisUtil.getJedis();
    List<String> listCategory = jedis.hmget(countCategorysRedisKey, "1","2","3","4","5","6","7","乐福鞋","平底鞋","高跟鞋","厚底鞋");
    if(listCategory.size()==11&&listCategory.get(0)!=null){
      for (int i = 0; i < listCategory.size(); i++) {
        countCategoryMap.put(categoryArray[i], listCategory.get(i));
      }
    }else{
      for (int i = 0; i < categoryArray.length; i++) {
        int countCategory = guangDao.getCountEveryCategory(categoryArray[i]);
        countCategoryMap.put(categoryArray[i], countCategory+"");
        RedisUtil.setMap(countCategorysRedisKey, countCategoryMap);
      }
    }
    return countCategoryMap;
  }
  
 /**
  * 保存逛逛喜欢
  * @param user_id
  * @param productId
  * @return 该商品喜欢总数
  */
  @Override
  public int saveGuangLike(String user_id, int productId) {
    if(!RedisUtil.isConnectRedis()){
      return -1;
    }
    //先为该产品喜欢数量+1
    String key = "go2:guang_product"+productId+"_like";
    String oldNum = RedisUtil.get(key);
    int newNum = 1;
    if(!StringUtils.isEmpty(oldNum)){
      newNum += Integer.parseInt(oldNum);
    }
    RedisUtil.set(key, newNum+"");
    
    //为用户存入一个值,生成用户key对应一个list
    String userKey = "guanglike"+user_id;
    List<String> productIdList = null;
    if(RedisUtil.exists(userKey)){
      String jsonList = RedisUtil.get(userKey);
      productIdList = (List<String>) Json.fromJson(jsonList, new TypeToken<List<String>>(){}.getType());
    }else{
      productIdList = new ArrayList<>();
    }
    productIdList.add(productId+"");
    RedisUtil.set(userKey, Json.toJson(productIdList));
    return newNum;
  }
  
  /**
   * 流行元素转化
   * @param props
   * @return 流行元素
   */
  @Override
  public String propsCase(String props) {
    if(StringUtils.isEmpty(props)){
      return "";
    }
    int prop = Integer.parseInt(props);
    switch(prop){
      case 1 :
        props = "松糕";
        break;
      case 2 :
        props = "防水台";
        break;
      case 3 :
        props = "一字型";
        break;
      case 4 :
        props = "人字鞋";
        break;
      case 5 :
        props = "尖头";
        break;
      case 6 :
        props = "绑带";
        break;
      case 7 :
        props = "PU";
        break;
      case 8 :
        props = "镂空";
        break;
      default :
        props = "";
        break;
    }
    return props;
  }
}

