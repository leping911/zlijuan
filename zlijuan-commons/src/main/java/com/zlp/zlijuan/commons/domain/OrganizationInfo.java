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
import com.zlp.zlijuan.commons.enums.OrganizationTypeEnum;

/**
 * 机构实体类
 * @Title: 
 * @ClassName: OrganizationInfo.java  
 * @Package: com.zlp.zlijuan.commons.domain
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:42:00
 * @version: V1.0
 */
@Entity
@SQLDelete(sql = "update organization_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@EntityListeners(AuditingEntityListener.class)
public class OrganizationInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	//机构名称
	private String orgUnitName;
	//机构编号
	private String orgUnitCode;
	//机构类型
	@Enumerated(EnumType.STRING)
	private OrganizationTypeEnum orgUnitType;
	//机构级别
	private String orgUnitLevel;
	//父机构
	@ManyToOne
	@JoinColumn(name = "orgUnitParentId")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = {"parentOrganizationInfo", "childOrganizationInfos"})
	private OrganizationInfo parentOrganizationInfo;
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
	//机构包含的用户信息
	@OneToMany(mappedBy = "organizationInfo")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = {"organizationInfo"})
	private List<UserInfo> userInfos;
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
	//下属机构
	@OneToMany(mappedBy = "parentOrganizationInfo")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = {"parentOrganizationInfo", "childOrganizationInfos"})
	private List<OrganizationInfo> childOrganizationInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgUnitName() {
		return orgUnitName;
	}

	public void setOrgUnitName(String orgUnitName) {
		this.orgUnitName = orgUnitName;
	}

	public String getOrgUnitCode() {
		return orgUnitCode;
	}

	public void setOrgUnitCode(String orgUnitCode) {
		this.orgUnitCode = orgUnitCode;
	}

	public String getOrgUnitLevel() {
		return orgUnitLevel;
	}

	public void setOrgUnitLevel(String orgUnitLevel) {
		this.orgUnitLevel = orgUnitLevel;
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

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
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

	public OrganizationInfo getParentOrganizationInfo() {
		if(parentOrganizationInfo == null) {
			parentOrganizationInfo = new OrganizationInfo();
		}
		return parentOrganizationInfo;
	}

	public void setParentOrganizationInfo(OrganizationInfo parentOrganizationInfo) {
		this.parentOrganizationInfo = parentOrganizationInfo;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public OrganizationTypeEnum getOrgUnitType() {
		return orgUnitType;
	}

	public void setOrgUnitType(OrganizationTypeEnum orgUnitType) {
		this.orgUnitType = orgUnitType;
	}

	public List<OrganizationInfo> getChildOrganizationInfos() {
		return childOrganizationInfos;
	}

	public void setChildOrganizationInfos(List<OrganizationInfo> childOrganizationInfos) {
		this.childOrganizationInfos = childOrganizationInfos;
	}
}
