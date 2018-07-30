package com.zlp.zlijuan.service;

import java.util.List;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;
import com.zlp.zlijuan.commons.domain.VO.TreeNode;


/**
 * @Title: ztree树逻辑处理类接口
 * @ClassName: TreeNodeService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:29:16
 * @version: V1.0
 */
public interface TreeNodeService {

	/**
	 * @Title: 通过父用户组获取子用户组节点
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:29:33
	 * @param parentOrganizationInfo 父用户组
	 * @return: List<TreeNode> 子节点集合
	 */
	List<TreeNode> findByParentOrganizationInfo(OrganizationInfo parentOrganizationInfo);

}
