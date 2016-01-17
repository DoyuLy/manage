package com.go2plus.core.promotion.service;

import java.util.List;

import com.go2plus.core.userCenter.vo.ScoreCategory;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierCreditNew;
import com.go2plus.core.userCenter.vo.SupplierRank;

public interface SupplierRankService {

	/**
	 * 获取商家信息
	 * 
	 * @param userId
	 * @return
	 */
	public Supplier getByUserId(Integer userId);

	/**
	 * 使用Redis获取商户信息
	 * 
	 * @param userId
	 * @return
	 */
	public Supplier getByUserIdFromRedis(Integer userId);

	/**
	 * 获取排名信息
	 * 
	 * @param userId
	 * @return
	 */
	public SupplierRank getRankByUserId(Integer userId);

	/**
	 * 使用Redis获取排名信息
	 * 
	 * @param userId
	 * @return
	 */
	public SupplierRank getRankByUserIdFromRedis(Integer userId);

	/**
	 * 获取排行信息
	 * 
	 * @return
	 */
	public List<SupplierRank> getTop500();

	/**
	 * 使用Redis获取排行信息
	 * 
	 * @return
	 */
	public List<SupplierRank> getTop500FromRedis();

	/**
	 * 将分数转化成等级
	 * 
	 * @param supplier
	 * @return 商家等级
	 */
	public Integer converteScoreToLevel(Integer score);

	/**
	 * 积分统计
	 * 
	 * @return
	 */
	public List<SupplierCreditNew> getScoreTotal(Integer userId);

	/**
	 * 用于积分管理生产分类下拉列表
	 * 
	 * @return
	 */
	public List<ScoreCategory> getScoreCategory();

}
