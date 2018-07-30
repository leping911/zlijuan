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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
import com.zlp.zlijuan.commons.enums.RoleTypeEnum;

/**
 * @Title: 角色实体类
 * @ClassName: RoleInfo.java  
 * @Package: com.zlp.zlijuan.commons.domain
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:42:21
 * @version: V1.0
 */
@Entity
@SQLDelete(sql = "update role_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@EntityListeners(AuditingEntityListener.class)
public class RoleInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	//角色名称
	private String roleName;
	//角色编号
	private String roleCode;
	//角色描述
	private String roleDesc;
	//角色类型
	@Enumerated(EnumType.STRING)
	private RoleTypeEnum roleType;
	//创建时间
	@Column(updatable = false)
	@CreatedDate
	private Date gmtCreate;
	//修改时间
	@LastModifiedDate
	private Date gmtModified;
	//是否删除
	@Column(name = "is_deleted")
	private Boolean deleted = false;
	//创建人
	@ManyToOne
	@JoinColumn(name = "userCreate", updatable = false)
	@CreatedBy
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInfo userCreate;
	//修改人
	@ManyToOne
	@JoinColumn(name = "userModified")
	@LastModifiedBy
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInfo userModified;
	//拥有该角色的用户
	@ManyToMany(mappedBy = "roleInfos")
	@JsonIgnoreProperties(value = {"roleInfos"})
	private List<UserInfo> userInfos;
	//功能权限
	@ManyToMany
	@JoinTable(name = "roleFunctions", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
			@JoinColumn(name = "functionId") })
	@JsonIgnoreProperties(value = {"roleInfos"})
	private List<FunctionInfo> functionInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public UserInfo getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(UserInfo userCreate) {
		this.userCreate = userCreate;
	}

	public UserInfo getUserModified() {
		return userModified;
	}

	public void setUserModified(UserInfo userModified) {
		this.userModified = userModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public List<FunctionInfo> getFunctionInfos() {
		return functionInfos;
	}

	public void setFunctionInfos(List<FunctionInfo> functionInfos) {
		this.functionInfos = functionInfos;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public RoleTypeEnum getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleTypeEnum roleType) {
		this.roleType = roleType;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}
