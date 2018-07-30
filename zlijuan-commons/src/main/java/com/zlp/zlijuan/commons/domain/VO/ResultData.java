package com.zlp.zlijuan.commons.domain.VO;

/**
 * @Title: 数据返回类
 * @ClassName: ResultData.java  
 * @Package: com.zlp.zlijuan.commons.domain.VO
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午4:40:25
 * @version: V1.0
 */
public class ResultData<T> {

	//是否成功
	private boolean success = true;
	
	//消息
	private String msg;
	
	//返回数据
	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
