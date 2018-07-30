package com.zlp.zlijuan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;
import com.zlp.zlijuan.service.OrganizationInfoService;

/**
 * @Title: 组织机构控制层
 * @ClassName: OrganizationInfoController.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午9:01:04
 * @version: V1.0
 */
@Controller
@RequestMapping("organization")
public class OrganizationInfoController {
	
	@Autowired
	OrganizationInfoService organizationInfoService;
	
	/**
	 * @Title: 机构列表页面
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:01:31
	 * @return String 视图
	 */
	@GetMapping("")
	public String list() {
		return "organization/list";
	}
	
	/**
	 * @Title: 机构分页数据请求
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:03:15
	 * @param pageRequst 分页请求对象
	 * @param id 父机构id
	 * @return Page<OrganizationInfo> 机构分页数据
	 */
	@GetMapping("page")
	@ResponseBody
	public Page<OrganizationInfo> page(PageRequest pageRequst,
			@RequestParam(defaultValue="1", name="id", required=false)Long id) {
		OrganizationInfo parentOrganizationInfo = new OrganizationInfo();
		parentOrganizationInfo.setId(id);
		return organizationInfoService.findByParentOrganizationInfo(pageRequst, parentOrganizationInfo);
	}
	
	/**
	 * @Title: 获取所有用户组信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:04:06
	 * @return
	 */
	@GetMapping("listJson")
	@ResponseBody
	public List<OrganizationInfo> listJson() {
		return organizationInfoService.findAll();
	}
}
