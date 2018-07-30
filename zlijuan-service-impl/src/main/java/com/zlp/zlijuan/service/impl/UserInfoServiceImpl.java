package com.zlp.zlijuan.service.impl;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zlp.zlijuan.commons.domain.UserInfo;
import com.zlp.zlijuan.dao.UserInfoRepository;
import com.zlp.zlijuan.service.UserInfoService;

/**
 * @Title: 用户信息服务层
 * @ClassName: UserInfoServiceImpl.java  
 * @Package: com.zlp.zlijuan.service.impl
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:02:38
 * @version: V1.0
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	/**
	 * @Title: 保存用户,如果存在则更新，不存在则新增
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:02:56
	 * @param userInfo 用户信息
	 * @return UserInfo 保存后的用户信息
	 * @see com.zlp.zlijuan.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public UserInfo save(UserInfo userInfo) {
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		userInfo.setSalt(salt);
		userInfo.setUserPassword("admin");
		return userInfoRepository.save(userInfo);
	}
	
	/**
	 * @Title: 根据id获取用户信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:03:22
	 * @param id 用户id
	 * @return UserInfo 用户信息
	 * @see com.zlp.zlijuan.service.BaseService#findOne(java.lang.Long)
	 */
	@Override
	public UserInfo findOne(Long id) {
		UserInfo userInfo = userInfoRepository.findOne(id);
		return userInfo;
	}
	
	/**
	 * @Title: 根据id删除用户信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:03:48
	 * @param id 用户id
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		userInfoRepository.delete(id);
	}
	
	/**
	 * @Title: 获取用户分页数据 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:04:06
	 * @param pageable 分页请求对象
	 * @return Page<UserInfo> 用户分页数据
	 * @see com.zlp.zlijuan.service.BaseService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<UserInfo> findAll(Pageable pageable) {
		Page<UserInfo> page = userInfoRepository.findAll(pageable);
		return page;
	}

	/**
	 * @Title: 获取所有用户数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:04:37
	 * @return List<UserInfo> 用户集合
	 * @see com.zlp.zlijuan.service.BaseService#findAll()
	 */
	@Override
	public List<UserInfo> findAll() {
		List<UserInfo> list = userInfoRepository.findAll();
		if(list != null && !list.isEmpty()) {
			for(UserInfo userInfo : list) {
				if(userInfo != null) {
					userInfo.setUserPassword(null);
				}
			}
		}
		return list;
	}

	/**
	 * @Title: 根据用户名获取用户信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:05:01
	 * @param userName 用户名
	 * @return UserInfo 用户
	 * @see com.zlp.zlijuan.service.UserInfoService#findByUserName(java.lang.String)
	 */
	@Override
	public UserInfo findByUserName(String userName) {
		UserInfo userInfo = userInfoRepository.findByUserName(userName);
		return userInfo;
	}

	/**
	 * @Title: 修改用户密码
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:05:24
	 * @param userInfo 用户信息
	 * @return int 更新行数
	 * @see com.zlp.zlijuan.service.UserInfoService#updatePassword(com.zlp.zlijuan.commons.domain.UserInfo)
	 */
	@Override
	public int updatePassword(UserInfo userInfo) {
		return userInfoRepository.updateUserPasswordById(userInfo.getId(), userInfo.getUserPassword());
	}

	/**
	 * @Title: 批量删除用户
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:05:48
	 * @param userInfos 需要删除的用户集合
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.util.List)
	 */
	@Override
	public void delete(List<UserInfo> userInfos) {
		userInfoRepository.delete(userInfos);
	}
}
