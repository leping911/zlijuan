package com.zlp.zlijuan.commons.enums;

/**
 * @Title: 日志类型枚举类
 * @ClassName: LogTypeEnum.java  
 * @Package: com.zlp.zlijuan.commons.enums
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午6:57:59
 * @version: V1.0
 */
public enum LogTypeEnum {
	
	NORMAL("操作日志"),
	ERROR("错误日志");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	LogTypeEnum(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
