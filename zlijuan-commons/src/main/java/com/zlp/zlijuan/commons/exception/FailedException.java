package com.zlp.zlijuan.commons.exception;

/**
 * @Title: 自定义运行时异常
 * @ClassName: FailedException.java  
 * @Package: com.zlp.zlijuan.commons.exception
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:02:31
 * @version: V1.0
 */
public class FailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;
	private int code = 500;

	public FailedException(String message) {
		super(message);
		this.msg = message;
	}
	
	public FailedException(String message, int code) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public FailedException(String message, int code, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.msg = message;
	}

	public FailedException(String message, Throwable cause) {
		super(cause);
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
