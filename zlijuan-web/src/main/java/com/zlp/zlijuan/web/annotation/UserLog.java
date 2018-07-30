package com.zlp.zlijuan.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zlp.zlijuan.commons.enums.LogOperationTypeEnum;
import com.zlp.zlijuan.commons.enums.ModuleTypeEnum;

/**
 * @Title: 自定义用户日志注解
 * @ClassName: UserLog.java  
 * @Package: com.zlp.zlijuan.web.annotation
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:23:03
 * @version: V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface UserLog {
	
	/**
	 * 日志模块类型
	 */
	ModuleTypeEnum module();
	
	/**
	 * 操作类型
	 */
	LogOperationTypeEnum type();
	
	/**
	 * 操作名称
	 */
	String name();
	
	/**
	 * 描述
	 */
	String description() default "";
	
}
