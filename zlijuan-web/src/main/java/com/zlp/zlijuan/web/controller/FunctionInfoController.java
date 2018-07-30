package com.zlp.zlijuan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlp.zlijuan.commons.domain.FunctionInfo;
import com.zlp.zlijuan.service.FunctionInfoService;

/**
 * 权限管理控制层
 * @Package cn.zlj.core.controller 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Leepec.zeng
 * @date 2018年3月12日 下午2:51:52
 * @version V1.0
 */
@Controller
@RequestMapping("function")
public class FunctionInfoController {
	
	@Autowired
	FunctionInfoService functionInfoService;
	
	/**
	 * 权限管理列表页面
	 * @Description: 
	 * @author Leepec
	 * @date 2018年3月12日 下午2:52:07
	 * @return String
	 */
	/**
	 * @Title: 权限管理列表页面
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:56:25
	 * @return String 列表页面
	 */
	@GetMapping("")
	public String list() {
		return "function/list";
	}
	
	/**
	 * @Title: 权限分页数据请求
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:56:49
	 * @param pageRequest 分页请求对象
	 * @return Page<FunctionInfo> 权限分页数据
	 */
	@GetMapping("page")
	@ResponseBody
	public Page<FunctionInfo> page(PageRequest pageRequest){
		return functionInfoService.findAll(pageRequest);
	}
}
