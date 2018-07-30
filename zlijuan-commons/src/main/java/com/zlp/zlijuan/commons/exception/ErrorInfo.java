package com.zlp.zlijuan.commons.exception;

/**
 * @Title: 错误信息json数据返回
 * @ClassName: ErrorInfo.java  
 * @Package: com.zlp.zlijuan.commons.exception
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:00:38
 * @version: V1.0
 */
public class ErrorInfo<T> {

	public static final Integer OK = 0;
	public static final Integer ERROR = 100;
	
	//错误编号
	private Integer code;
	//错误信息
	private String message;
	//请求地址
	private String url;
	//数据
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static Integer getOk() {
		return OK;
	}

	public static Integer getError() {
		return ERROR;
	}

}
