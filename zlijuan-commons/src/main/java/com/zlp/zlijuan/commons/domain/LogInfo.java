package com.zlp.zlijuan.commons.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.zlp.zlijuan.commons.enums.LogOperationTypeEnum;
import com.zlp.zlijuan.commons.enums.LogTypeEnum;
import com.zlp.zlijuan.commons.enums.ModuleTypeEnum;

/**
 * @Title: 日志实体类
 * @ClassName: LogInfo.java  
 * @Package: com.zlp.zlijuan.commons.domain
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:41:44
 * @version: V1.0
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class LogInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	//模块类型
	@Enumerated(EnumType.STRING)
	private ModuleTypeEnum moduleType;
	//操作类型
	@Enumerated(EnumType.STRING)
	private LogOperationTypeEnum operationType;
	//操作名称
	private String operationName;
	//描述
	private String description;
	//日志类型
	@Enumerated(EnumType.STRING)
	private LogTypeEnum logType;
	//请求url
	private String requestUrl;
	//请求ip
	private String requestIp;
	//错误编号
	private Integer exceptionCode;
	//详细错误信息
	private String exceptionDetail;
	//请求的方法
	private String klassMethod;
	//参数
	private String args;
	//httpmethod
	private String httpMethod;
	//返回值
	private String jsonResult;
	//耗时
	private Long consumeTime;
	//创建人
	@ManyToOne
	@JoinColumn(name = "userCreate", updatable = false)
	@CreatedBy
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInfo userCreate;
	//创建时间
	@Column(updatable = false)
	@CreatedDate
	private Date gmtCreate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModuleTypeEnum getModuleType() {
		return moduleType;
	}

	public void setModuleType(ModuleTypeEnum moduleType) {
		this.moduleType = moduleType;
	}

	public LogOperationTypeEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(LogOperationTypeEnum operationType) {
		this.operationType = operationType;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LogTypeEnum getLogType() {
		return logType;
	}

	public void setLogType(LogTypeEnum logType) {
		this.logType = logType;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public Integer getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public UserInfo getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(UserInfo userCreate) {
		this.userCreate = userCreate;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getKlassMethod() {
		return klassMethod;
	}

	public void setKlassMethod(String klassMethod) {
		this.klassMethod = klassMethod;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public Long getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Long consumeTime) {
		this.consumeTime = consumeTime;
	}

}
