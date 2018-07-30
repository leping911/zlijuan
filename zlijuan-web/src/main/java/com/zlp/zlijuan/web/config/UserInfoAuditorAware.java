package com.zlp.zlijuan.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.zlp.zlijuan.commons.domain.UserInfo;
import com.zlp.zlijuan.service.UserInfoService;

/**
 * @Title: 设置数据当前操作用户
 * @ClassName: UserInfoAuditorAware.java  
 * @Package: com.zlp.zlijuan.web.config
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:34:44
 * @version: V1.0
 */
@Configuration
public class UserInfoAuditorAware implements AuditorAware<UserInfo> {
	
	@Autowired
	UserInfoService userInfoService;

	@Override
	public UserInfo getCurrentAuditor() {
		return userInfoService.findByUserName("admin");
	}
}
