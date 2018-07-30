package com.zlp.zlijuan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;
import com.zlp.zlijuan.commons.domain.VO.TreeNode;
import com.zlp.zlijuan.service.TreeNodeService;

@RequestMapping("tree")
@RestController
public class TreeNodeController {
	
	@Autowired
	TreeNodeService treeNodeService;
	
	/**
	 * @Title: 机构树
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:07:47
	 * @param id 父节点id
	 * @return List<TreeNode> 子节点集合
	 */
	@RequestMapping("findByParentOrganizationInfo")
	public List<TreeNode> findByParentOrganizationInfo(@RequestParam(required = false, name = "id")Long id) {
		OrganizationInfo parentOrganizationInfo = null;
		if(id != null) {
			parentOrganizationInfo = new OrganizationInfo();
			parentOrganizationInfo.setId(id);
		}
		return treeNodeService.findByParentOrganizationInfo(parentOrganizationInfo);
	}

}
