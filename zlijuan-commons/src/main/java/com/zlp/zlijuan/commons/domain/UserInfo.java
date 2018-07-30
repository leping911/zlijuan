package com.zlp.zlijuan.commons.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zlp.zlijuan.commons.enums.GenderEnum;
import com.zlp.zlijuan.commons.enums.UserTypeEnum;

/**
 * @Title: 用户实体类
 * @ClassName: UserInfo.java  
 * @Package: com.zlp.zlijuan.commons.domain
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:42:41
 * @version: V1.0
 */
@Entity
@SQLDelete(sql = "update user_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	//用户名
	@NotBlank
	@Length(min = 5, max = 50)
	@Column(unique = true, nullable = false)
	private String userName;
	//盐
	private String salt;
	//密码
	@Column(updatable = false)
	@JsonIgnore
	private String userPassword;
	//昵称
	private String nickName;
	//年龄
	private Integer age;
	//用户类型
	@Enumerated(EnumType.STRING)
	private UserTypeEnum userType = UserTypeEnum.NORMAL;
	//性别
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	//用户编号
	private String userCode;
	//手机号码
	private String telephone;
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
	//组织机构
	@ManyToOne
	@JoinColumn(name = "orgUnitId")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = { "userInfos", "userModified", "userCreate" })
	private OrganizationInfo organizationInfo;
	//创建人
	@ManyToOne
	@JoinColumn(name = "userCreate", updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = { "organizationInfo", "roleInfos", "userModified", "userCreate" })
	private UserInfo userCreate;
	//修改人
	@ManyToOne
	@JoinColumn(name = "userModified")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnoreProperties(value = { "organizationInfo", "roleInfos", "userModified", "userCreate" })
	private UserInfo userModified;
	//拥有角色
	@ManyToMany
	@JoinTable(name = "userRoles", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	@JsonIgnoreProperties(value = { "userInfos", "userModified", "userCreate" })
	private List<RoleInfo> roleInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public OrganizationInfo getOrganizationInfo() {
		return organizationInfo;
	}

	public void setOrganizationInfo(OrganizationInfo organizationInfo) {
		this.organizationInfo = organizationInfo;
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

	public List<RoleInfo> getRoleInfos() {
		return roleInfos;
	}

	public void setRoleInfos(List<RoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
