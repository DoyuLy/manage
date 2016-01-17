package com.go2plus.core.userCenter.dao;

import java.util.List;
import java.util.Map;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.userCenter.vo.InSeller2Product;

public interface lnSeller2ProductDao extends DAO {
  
  public List<InSeller2Product> selectAll(int start);
  
  public List<Map> selectMap(int start);

}
