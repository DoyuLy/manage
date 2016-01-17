package com.go2plus.core.promotion.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.userCenter.dao.SellerDao;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.SupplierRank;

@Service
public class ValidatorServiceImpl implements ValidatorService {
	
	@Autowired
	private PromotionDao promotionDao;
	
	@Autowired
	private SellerDao sellerDao;
	
	@Autowired
	private SupplierDao supplierDao;

	@Override
	public boolean isDate(String date, String pattern) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Date result = dateFormat.parse(date);
			if (result != null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return false;
	}

	@Override
	public boolean isPosX(String posX, String type) {
		// TODO Auto-generated method stub
		if (posX == null || !posX.matches("^([a-z]{1})([0-9]{1,2})$")) {
			return false;
		}
		if (type == null) {
			type = "featured";
		}
		char c = posX.charAt(0);
		int num = Integer.valueOf(posX.substring(1, posX.length()));
		switch (type) {
		case "featured":
			if (isInArr(c, new char[] { 'c', 'd', 'i', 'j', 'k', 'o', 'p', 'q',
					'r', 's' })
					&& (num >= 1 && num <= 12)) {
				return true;
			}
			return false;
		case "usercenter":
			if (isInArr(c, new char[] { 'u' }) && (num >= 1 && num <= 30)) {
				return true;
			}
			return false;
		case "search":
			if (isInArr(c, new char[] { 'g' }) && (num >= 1 && num <= 36)) {
				return true;
			}
			return false;
		case "all":
			if (isInArr(c, new char[] { 'c', 'd', 'i', 'j', 'k', 'o', 'p', 'q',
					'r', 's', 'e', 'f', 'x' })
					&& (num >= 1 && num <= 10)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean isSet(Map<String, ?> map, String key) {
		// TODO Auto-generated method stub
		if(map==null){
			return false;
		}
		if (map.get(key) != null) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean isSet(List<String> list, String key) {
		// TODO Auto-generated method stub
		if(list==null){
			return false;
		}
		return list.contains(key);
	}

	private boolean isInArr(char ch, char[] arr) {
		for (char c : arr) {
			if (ch == c) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isPass(String shash, String thash) throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(shash) || StringUtils.isEmpty(thash)){
			return false;
		}
		if(shash.equals(thash)){
			return true;
		}
		return false;
	}


	@Override
	public Date toDate(String date) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(date);
	}

	@Override
	public String toDate(Date date) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	@Override
  public Date addDay(Date date, Integer num) {
    // TODO Auto-generated method stub
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_YEAR, num);
    return calendar.getTime();
  }
	@Override
	public Date addWeek(Date date, Integer num) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 6*num);
		return calendar.getTime();
	}
	@Override
  public Date addWeek7(Date date, Integer num) {
    // TODO Auto-generated method stub
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.WEEK_OF_MONTH, num);
    return calendar.getTime();
  }
	@Override
  public Date subWeek7(Date date, Integer num) {
    // TODO Auto-generated method stub
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.WEEK_OF_MONTH, -num);
    return calendar.getTime();
  }
	@Override
  public int getWeek7(Date date) {
    // TODO Auto-generated method stub
    Calendar calendar=Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.DAY_OF_WEEK);
  }
	@Override
	public Long strtotime(Date date) {
		// TODO Auto-generated method stub
		return date.getTime() / 1000;
	}

	@Override
	public Integer getWeekNum(Date lastDay, Date startTime) {
		// 精度有误差，暂时可用，有空调善
		double num =( (double)(strtotime(lastDay) - strtotime(startTime)) / (86400.0 * 7));
		return new BigDecimal(Math.ceil(num)).intValue();
	}

	@Override
	public boolean isAvaiableFP(String posX, Date startTime) {
		// TODO Auto-generated method stub
		int num=promotionDao.getAvailableNum(posX, startTime);
		if(num==0){
			return true; 
		}
		return false;
	}
	@Override
  public boolean isAvaiableAD(String type) {
    // TODO Auto-generated method stub
    int num=promotionDao.getADNum(type);
    if(num==0){
      return true; 
    }
    return false;
  }
	@Override
	public boolean disableFunc(Integer userId) {
		// TODO Auto-generated method stub
		int[] arr={84,4316,63052,75533,1908,88918};
		for(int i:arr){
			if(i==userId){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isOnBlackList(Integer userId) {
		// TODO Auto-generated method stub
		List<String> list=sellerDao.queryJoinedBlackListSupplierId(String.valueOf(userId));
		if(list!=null){
			return list.contains(String.valueOf(userId));
		}
		return false;
	}

	@Override
	public Boolean isTop100Supplier(Integer userId) {
		// TODO Auto-generated method stub
		 SupplierRank supplierRank = supplierDao.getSupplierRankByUserId(userId);
		 if(supplierRank!=null && supplierRank.getRank() <= 100){
			 return true;
		 }
		 return false;
	}

}
