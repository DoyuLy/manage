package com.go2plus.core.promotion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.promotion.service.SupplierRankService;
import com.go2plus.core.userCenter.vo.ScoreCategory;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierCreditNew;
import com.go2plus.core.userCenter.vo.SupplierRank;

/**
 * 用户中心——我的广告——供应商排行榜
 * 
 * @Description: TODO
 * @author lhc
 * @date 2015-12-3
 * 
 */
@Controller
@RequestMapping("/promotion/")
@SessionAttributes("supplier")
public class SupplierRankController extends BaseController {

	private final static Logger log = LoggerFactory
			.getLogger(SupplierRankController.class);

	@Autowired
	private SupplierRankService supplierRankService;

	private boolean useRedis = false;

	// 测试使用
	private int userId = 84;

	/**
	 * 供应商排行榜
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/billboard")
	public ModelAndView billboard(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = loadNewBox(request);
		// 获取商家信息
		Supplier supplier = null;
		if (useRedis) {
			supplier = supplierRankService.getByUserIdFromRedis(userId);
		} else {
			supplier = supplierRankService.getByUserId(userId);
		}
		try {
			// 国际商贸城认证级别以上商家有权限
			if (supplier.getMarketId() != 5 || supplier.getCertifiedType() <= 0) {
				box.setAttribute("msg",
						"对不起，您无法使该功能。<br/>目前仅国际商贸城认证商家支持使用该功能，如需开通认证请联系网站客服QQ 4006611603！");
				return createModelAndView("core/promotion/billboard.jsp", box);
			}
			// 获取商家排名
			SupplierRank supplierRank = null;
			// 获取供应商前500的排名信息
			List<SupplierRank> supplierRanks = null;
			if (useRedis) {
				supplierRank = supplierRankService
						.getRankByUserIdFromRedis(userId);
				supplierRanks = supplierRankService.getTop500FromRedis();
			} else {
				supplierRank = supplierRankService.getRankByUserId(userId);
				supplierRanks = supplierRankService.getTop500();
			}
			box.setAttribute("supplierRank", supplierRank);
			box.setAttribute("supplierRanks", supplierRanks);
			box.setAttribute("supplierLevel", supplierRankService
					.converteScoreToLevel(supplierRank.getScore()));
			box.setAttribute("levels", getLevels(supplierRanks));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e.getMessage());
		}
		box.setAttribute("supplier", supplier);
		return createModelAndView("core/promotion/billboard.jsp", box);
	}

	/**
	 * 获取积分详情
	 * 
	 * @param supplier
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/scoredetail")
	public ModelAndView scoredetail(
			@ModelAttribute("supplier") Supplier supplier,
			HttpServletRequest request, HttpServletResponse response) {
		Box box = loadNewBox(request);
		try {
			if (supplier != null) {
				// 国际商贸城认证级别以上商家有权限
				if (supplier.getMarketId() != 5
						|| supplier.getCertifiedType() <= 0) {
					box.setAttribute("msg",
							"对不起，您无法使该功能。<br/>目前仅国际商贸城认证商家支持使用该功能，如需开通认证请联系网站客服QQ 4006611603！");
					return createModelAndView("core/promotion/scoredetail.jsp",
							box);
				}
				TreeMap<String, Long> totalMap = new TreeMap<>();
				// 获取积分类型映射
				HashMap<String, String> scoreCategoryMap = getScoreCategoryMap();
				List<SupplierCreditNew> supplierCreditNews = supplierRankService
						.getScoreTotal(userId);
				for (SupplierCreditNew creditNew : supplierCreditNews) {
					totalMap.put(scoreCategoryMap.get(String.valueOf(creditNew
							.getType())), creditNew.getTotalScore());
				}
				box.setAttribute("totalMap", totalMap);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return createModelAndView("core/promotion/scoredetail.jsp", box);
	}

	/**
	 * 获取积分对应的等级集合
	 * 
	 * @param supplierRanks
	 * @return
	 */
	private ArrayList<Integer> getLevels(List<SupplierRank> supplierRanks) {
		ArrayList<Integer> levels = new ArrayList<>();
		for (SupplierRank rank : supplierRanks) {
			levels.add(supplierRankService.converteScoreToLevel(rank.getScore()));
		}
		return levels;
	}

	/**
	 * 获取分数类别的映射
	 * 
	 * @return
	 */
	private HashMap<String, String> getScoreCategoryMap() {
		HashMap<String, String> map = new HashMap<>();
		List<ScoreCategory> scoreCategories = supplierRankService
				.getScoreCategory();
		for (ScoreCategory category : scoreCategories) {
			map.put(category.getCid(), category.getTitle());
		}
		return map;
	}

}
