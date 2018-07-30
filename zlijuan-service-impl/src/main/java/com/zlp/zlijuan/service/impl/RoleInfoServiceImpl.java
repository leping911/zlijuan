package com.zlp.zlijuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zlp.zlijuan.commons.domain.RoleInfo;
import com.zlp.zlijuan.dao.RoleInfoRepository;
import com.zlp.zlijuan.service.RoleInfoService;

/**
 * @Title: 角色服务层
 * @ClassName: RoleInfoServiceImpl.java  
 * @Package: com.zlp.zlijuan.service.impl
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:58:01
 * @version: V1.0
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
	
	@Autowired
	RoleInfoRepository roleInfoRepository;
	
	/**
	 * @Title: 保存角色信息，存在则更新，不存在则插入
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:58:25
	 * @param roleInfo 用户角色
	 * @return RoleInfo 保存后用户角色
	 * @see com.zlp.zlijuan.service.BaseService#save(java.lang.Object)
	 */
	public RoleInfo save(RoleInfo roleInfo) {
		return roleInfoRepository.save(roleInfo);
	}

	/**
	 * @Title: 根据id获取角色信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:58:50
	 * @param id 角色id
	 * @return RoleInfo 角色
	 * @see com.zlp.zlijuan.service.BaseService#findOne(java.lang.Long)
	 */
	@Override
	public RoleInfo findOne(Long id) {
		return roleInfoRepository.findOne(id);
	}

	/**
	 * @Title: 根据id删除角色
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:59:32
	 * @param id 角色id
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		roleInfoRepository.delete(id);
	}

	/**
	 * @Title: 获取角色分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:00:03
	 * @param pageable 分页请求对象
	 * @return Page<RoleInfo> 分页数据
	 * @see com.zlp.zlijuan.service.BaseService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<RoleInfo> findAll(Pageable pageable) {
		return roleInfoRepository.findAll(pageable);
	}

	/**
	 * @Title: 获取所有角色数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:00:32
	 * @return List<RoleInfo> 角色对象集合
	 * @see com.zlp.zlijuan.service.BaseService#findAll()
	 */
	@Override
	public List<RoleInfo> findAll() {
		return roleInfoRepository.findAll();
	}

	/**
	 * @Title: 批量删除角色
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:00:52
	 * @param roleInfos 需要删除的角色集合
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.util.List)
	 */
	@Override
	public void delete(List<RoleInfo> roleInfos) {
		roleInfoRepository.delete(roleInfos);
	}
	
}
