package com.zlp.zlijuan.commons.enums;

/**
 * @Title: 人员性别枚举类
 * @ClassName: GenderEnum.java  
 * @Package: com.zlp.zlijuan.commons.enums
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午6:51:14
 * @version: V1.0
 */
public enum GenderEnum {
	F("女性"), //女性
	M("男性"); //男性
	
	private String value;
	
	public String getValue() {
		return value;
	}

	GenderEnum(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
