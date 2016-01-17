package com.go2plus.core.userCenter.dao;

import java.util.List;
import java.util.Map;

import com.go2plus.common.mvc.DAO;
import org.springframework.stereotype.Repository;

import com.go2plus.core.userCenter.vo.Daifa;
@Repository
public interface DaifaDao  extends DAO{
	
	/**
	 * page query Daifa information
	 * @param queryMap
	 * @return ArrayList
	 */
    public List<Daifa> findPageList(Map<String,Object> queryMap);
    
    /**
	 * query Daifa information
	 * @param queryDaifa
	 * @return ArrayList
	 */
    public List<Daifa> findList();
    
    /**
	 * query Daifa information Count
	 * @param queryDaifa
	 * @return Integer
	 */
    public Integer findCount(Map<String,Object> queryMap);
    
    /**
	 * get one Daifa information
	 * @param id
	 * @return Daifa
	 */
    public Daifa findById(Integer id);
	
	/**
	 * insert one Daifa information
	 * @param id
	 */
	public void insert(Daifa daifa);
	
	/**
	 * update one Daifa information
	 * @param Daifa
	 */
    public void update(Daifa daifa);
    
    /**
	 * delete one Daifa information
	 * @param id
	 */
    public void delete(Integer id);
    
   	
}
