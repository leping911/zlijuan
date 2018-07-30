package com.zlp.zlijuan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zlp.zlijuan.commons.domain.UserInfo;

/**
 * @Title: 用户信息持久类
 * @ClassName: UserInfoRepository.java  
 * @Package: com.zlp.zlijuan.dao
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:17:28
 * @version: V1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

	/**
	 * @Title: 根据用户名获取用户信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:17:40
	 * @param userName 用户名
	 * @return: UserInfo 用户信息
	 */
	UserInfo findByUserName(String userName);

	/**
	 * @Title: 更改用户密码
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:18:11
	 * @param id 用户id
	 * @param userPassword 密码
	 * @return: int 更新行数
	 */
	@Transactional
	@Modifying
	@Query("update UserInfo u set u.userPassword = :userPassword where u.id = :id")
	int updateUserPasswordById(@Param("id")Long id, @Param("userPassword")String userPassword);

}
