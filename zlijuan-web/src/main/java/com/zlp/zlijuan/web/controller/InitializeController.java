package com.zlp.zlijuan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zlp.zlijuan.commons.domain.VO.ResultData;
import com.zlp.zlijuan.service.FunctionInfoService;
import com.zlp.zlijuan.service.InitializeService;
import com.zlp.zlijuan.service.OrganizationInfoService;
import com.zlp.zlijuan.service.RoleInfoService;
import com.zlp.zlijuan.service.UserInfoService;

/**
 * @Title: 初始化基础数据控制类
 * @ClassName: InitializeController.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午9:00:45
 * @version: V1.0
 */
@RestController
@RequestMapping("initialize")
public class InitializeController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	OrganizationInfoService organizationInfoService;
	
	@Autowired
	RoleInfoService roleInfoService;

	@Autowired
	FunctionInfoService functionInfoService;
	
	@Autowired
	InitializeService initializeService;
	
	/**
	 * @Title: 初始化基础数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:59:12
	 * @return ResultData<String>
	 */
	@GetMapping("")
	@ResponseBody
	public ResultData<String> initUserAndOrganization() {
		ResultData<String> resultData = new ResultData<>();
		initializeService.initializeUser();
		initializeService.initializeOrganization();
		initializeService.initializeFunction();
		initializeService.initializeRole();
		resultData.setData("成功");
		return resultData;
	}
}
