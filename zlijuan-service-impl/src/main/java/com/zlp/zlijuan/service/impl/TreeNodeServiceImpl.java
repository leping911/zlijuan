package com.zlp.zlijuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;
import com.zlp.zlijuan.commons.domain.VO.TreeNode;
import com.zlp.zlijuan.dao.OrganizationInfoRepository;
import com.zlp.zlijuan.service.TreeNodeService;

/**
 * @Title: ztree树服务层
 * @ClassName: TreeNodeServiceImpl.java  
 * @Package: com.zlp.zlijuan.service.impl
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:01:18
 * @version: V1.0
 */
@Service("treeNodeService")
public class TreeNodeServiceImpl implements TreeNodeService {
	
	@Autowired
	OrganizationInfoRepository organizationInfoRepository;

	/**
	 * @Title: 根据父节点获取子节点
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:01:33
	 * @param parentOrganizationInfo 父用户组节点
	 * @return List<TreeNode> 子节点数据集合
	 * @see com.zlp.zlijuan.service.TreeNodeService#findByParentOrganizationInfo(com.zlp.zlijuan.commons.domain.OrganizationInfo)
	 */
	@Override
	public List<TreeNode> findByParentOrganizationInfo(OrganizationInfo parentOrganizationInfo){
		List<TreeNode> listTreeNode = null;
		List<OrganizationInfo> listOganizationInfo = organizationInfoRepository.findByParentOrganizationInfo(parentOrganizationInfo);
		if(listOganizationInfo != null && !listOganizationInfo.isEmpty()) {
			listTreeNode = new ArrayList<>();
			for(OrganizationInfo organizationInfo : listOganizationInfo) {
				if(organizationInfo != null) {
					TreeNode treeNode = new TreeNode();
					listTreeNode.add(treeNode);
					treeNode.setId(organizationInfo.getId());
					treeNode.setName(organizationInfo.getOrgUnitName());
					if(organizationInfo.getParentOrganizationInfo() != null) {
						treeNode.setpId(organizationInfo.getParentOrganizationInfo().getId());
					} else {
						treeNode.setpId(0L);
					}
					if(organizationInfo.getChildOrganizationInfos() != null && !organizationInfo.getChildOrganizationInfos().isEmpty()) {
						treeNode.setIsParent(true);
					} else {
						treeNode.setIsParent(false);
					}
				}
			}
		}
		return listTreeNode;
	}
	

}
