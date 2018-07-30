package com.zlp.zlijuan.commons.domain.VO;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: ztree树对象
 * @ClassName: TreeNode.java  
 * @Package: com.zlp.zlijuan.commons.domain.VO
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:40:54
 * @version: V1.0
 */
public class TreeNode implements Serializable {

	private static final long serialVersionUID = 1L;

	//节点id
	private Long id;

	//父节点id
	private Long pId;

	//名称
	private String name;

	//是否包含子节点
	private Boolean isParent;

	//子节点
	private List<TreeNode> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

}
