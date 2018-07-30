package com.zlp.zlijuan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlp.zlijuan.commons.domain.RoleInfo;
import com.zlp.zlijuan.service.RoleInfoService;

/**
 * @Title: 角色管理控制层
 * @ClassName: RoleInfoController.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午9:04:48
 * @version: V1.0
 */
@Controller
@RequestMapping("role")
public class RoleInfoController {
	
	@Autowired
	RoleInfoService roleInfoService;
	
	/**
	 * @Title: 角色管理列表页面
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:05:20
	 * @return String 视图
	 */
	@GetMapping()
	public String list() {
		return "role/list";
	}
	
	/**
	 * @Title: 角色分页数据请求
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:05:45
	 * @param pageRequest 分页请求对象
	 * @return Page<RoleInfo> 角色分页数据
	 */
	@GetMapping("page")
	@ResponseBody
	public Page<RoleInfo> page(PageRequest pageRequest){
		return roleInfoService.findAll(pageRequest);
	}
}
