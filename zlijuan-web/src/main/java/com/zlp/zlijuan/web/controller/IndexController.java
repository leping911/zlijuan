package com.zlp.zlijuan.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @Package cn.zlj.core.controller 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Leepec.zeng
 * @date 2018年3月22日 上午12:10:06
 * @version V1.0
 */
@Controller
@RequestMapping("index")
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/**
	 * @Title: 首页页面
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:58:40
	 * @return String 首页
	 */
	@GetMapping("")
	public String index(HttpSession session) {
		logger.info("首页请求,{}", session.getId());
		return "index";
	}
}
