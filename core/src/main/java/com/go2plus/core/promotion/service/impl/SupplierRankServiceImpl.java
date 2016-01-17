package com.go2plus.core.promotion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.go2plus.common.json.Json;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.product.vo.Site;
import com.go2plus.core.promotion.service.SupplierRankService;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.ScoreCategory;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierCreditNew;
import com.go2plus.core.userCenter.vo.SupplierRank;
import com.google.gson.reflect.TypeToken;

@Service
public class SupplierRankServiceImpl implements SupplierRankService {
	
	@Autowired
	private SupplierDao supplierDao;

	@Override
	public Supplier getByUserIdFromRedis(Integer userId) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtil.getPool().getResource();
		Supplier supplier = (Supplier) Json.fromJson(
				redis.hget("suppliers", "supplier" + userId), Supplier.class);
		if (supplier != null) {
			Site site = (Site) Json.fromJson(
					redis.hget("sites", "site" + userId), Site.class);
			if (site != null) {
				supplier.setSite(site);
			}
		}
		return supplier;
	}

	@Override
	public List<SupplierRank> getTop500FromRedis() {
		// TODO Auto-generated method stub
		Jedis redis=RedisUtil.getPool().getResource();
		@SuppressWarnings("unchecked")
		List<SupplierRank> list=(List<SupplierRank>) Json.fromJson(redis.get("top500supplier"), new TypeToken<List<SupplierRank>>(){}.getType());
		if(list==null){
			list=getTop500();
			redis.set("top500supplier", Json.toJson(list));
			redis.expire("top500supplier", 2*60*60);
		}
		return list;
	}

	@Override
	public SupplierRank getRankByUserIdFromRedis(Integer userId) {
		// TODO Auto-generated method stub
		Jedis redis=RedisUtil.getPool().getResource();
		SupplierRank rank=(SupplierRank) Json.fromJson(redis.hget("supplierRanks", "supplierRank"+userId), SupplierRank.class);
		if(rank==null){
			rank=getRankByUserId(userId);
			redis.hset("supplierRanks", "supplierRank"+userId, Json.toJson(rank));
			redis.expire("supplierRanks", 2*60*60);
		}
		return rank;
	}

	@Override
	public Supplier getByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return supplierDao.getByUserId(userId);
	}

	@Override
	public Integer converteScoreToLevel(Integer score) {
		// TODO Auto-generated method stub
		if (score > 10000000) {
			return 20;
		} else if (score > 5000000) {
			return 19;
		} else if (score > 2000000) {
			return 18;
		} else if (score > 1000000) {
			return 17;
		} else if (score > 500000) {
			return 16;
		} else if (score > 200000) {
			return 15;
		} else if (score > 100000) {
			return 14;
		} else if (score > 50000) {
			return 13;
		} else if (score > 20000) {
			return 12;
		} else if (score > 10000) {
			return 11;
		} else if (score > 5000) {
			return 10;
		} else if (score > 2000) {
			return 9;
		} else if (score > 1000) {
			return 8;
		} else if (score > 500) {
			return 7;
		} else if (score > 250) {
			return 6;
		} else if (score > 150) {
			return 5;
		} else if (score > 90) {
			return 4;
		} else if (score > 40) {
			return 3;
		} else if (score > 10) {
			return 2;
		} else {
			return 1;
		}
	}

	@Override
	public List<SupplierRank> getTop500() {
		// TODO Auto-generated method stub
		return supplierDao.getTop500();
	}

	@Override
	public SupplierRank getRankByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierRankByUserId(userId);
	}

	@Override
	public List<SupplierCreditNew> getScoreTotal(Integer userId) {
		// TODO Auto-generated method stub
		return supplierDao.getScoreTotal(userId);
	}

	@Override
	public List<ScoreCategory> getScoreCategory() {
		// TODO Auto-generated method stub
		return supplierDao.getScoreCategory();
	}

}
