package com.zlp.zlijuan.service;

import com.zlp.zlijuan.commons.domain.UserInfo;

/**
 * @Title: 用户服务层接口
 * @ClassName: UserInfoService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:30:25
 * @version: V1.0
 */
public interface UserInfoService extends BaseService<UserInfo>{

	/**
	 * @Title: 根据用户名获取用户信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:30:39
	 * @param userName 用户名
	 * @return: UserInfo 用户信息
	 */
	UserInfo findByUserName(String userName);

	/**
	 * @Title: 更新用户密码
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:31:10
	 * @param userInfo 用户信息
	 * @return: int 受影响行数
	 */
	int updatePassword(UserInfo userInfo);

}
