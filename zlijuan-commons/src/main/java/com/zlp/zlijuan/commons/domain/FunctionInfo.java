package com.zlp.zlijuan.commons.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zlp.zlijuan.commons.enums.FunctionTypeEnum;

/**
 * @Title: 功能权限
 * @ClassName: FunctionInfo.java  
 * @Package: com.zlp.zlijuan.commons.domain
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:41:11
 * @version: V1.0
 */
@Entity
@SQLDelete(sql = "update function_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@EntityListeners(AuditingEntityListener.class)
public class FunctionInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	//名称
	private String functionName;
	//编码
	private String functionCode;
	//url
	private String functionUrl;
	//类型
	@Enumerated(EnumType.STRING)
	private FunctionTypeEnum functionType;
	//描述
	private String functionDesc;
	//排序
	private Integer functionOrder;
	//图标
	private String functionIcons;
	//功能权限
	@ManyToOne
	@JoinColumn(name = "functionParentId")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = {"parentFunctionInfo", "childFunctionInfos"})
	private FunctionInfo parentFunctionInfo;
	//创建时间
	@Column(updatable = false)
	@CreatedDate
	private Date gmtCreate;
	//创建人
	@ManyToOne
	@JoinColumn(name = "userCreate", updatable = false)
	@CreatedBy
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInfo userCreate;
	//修改时间
	@LastModifiedDate
	private Date gmtModified;
	//修改人
	@ManyToOne
	@JoinColumn(name = "userModified")
	@LastModifiedBy
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInfo userModified;
	//是否删除
	@Column(name = "is_deleted")
	private Boolean deleted = false;
	//拥有该功能权限的角色
	@ManyToMany(mappedBy = "functionInfos")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = {"functionInfos"})
	private List<RoleInfo> roleInfos;
	//子功能权限
	@OneToMany(mappedBy = "parentFunctionInfo")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = {"parentFunctionInfo", "childFunctionInfos"})
	private List<FunctionInfo> childFunctionInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public String getFunctionDesc() {
		return functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	public FunctionInfo getParentFunctionInfo() {
		return parentFunctionInfo;
	}

	public void setParentFunctionInfo(FunctionInfo parentFunctionInfo) {
		this.parentFunctionInfo = parentFunctionInfo;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public UserInfo getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(UserInfo userCreate) {
		this.userCreate = userCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public UserInfo getUserModified() {
		return userModified;
	}

	public void setUserModified(UserInfo userModified) {
		this.userModified = userModified;
	}

	public List<RoleInfo> getRoleInfos() {
		return roleInfos;
	}

	public void setRoleInfos(List<RoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public FunctionTypeEnum getFunctionType() {
		return functionType;
	}

	public void setFunctionType(FunctionTypeEnum functionType) {
		this.functionType = functionType;
	}

	public List<FunctionInfo> getChildFunctionInfos() {
		return childFunctionInfos;
	}

	public void setChildFunctionInfos(List<FunctionInfo> childFunctionInfos) {
		this.childFunctionInfos = childFunctionInfos;
	}

	public Integer getFunctionOrder() {
		return functionOrder;
	}

	public void setFunctionOrder(Integer functionOrder) {
		this.functionOrder = functionOrder;
	}

	public String getFunctionIcons() {
		return functionIcons;
	}

	public void setFunctionIcons(String functionIcons) {
		this.functionIcons = functionIcons;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
}
