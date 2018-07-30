package com.zlp.zlijuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zlp.zlijuan.commons.domain.FunctionInfo;
import com.zlp.zlijuan.dao.FunctionInfoRepository;
import com.zlp.zlijuan.service.FunctionInfoService;

/**
 * 权限菜单服务层
 * @Package cn.zlj.core.service.impl 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Leepec.zeng
 * @date 2018年3月16日 下午2:29:39
 * @version V1.0
 */
@Service("functionInfoService")
public class FunctionInfoServiceImpl implements FunctionInfoService {
	
	@Autowired
	FunctionInfoRepository functionInfoRepository;

	/**
	 * @Title: 保存权限菜单
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:35:58
	 * @param functionInfo 权限菜单
	 * @return FunctionInfo 权限菜单
	 * @see com.zlp.zlijuan.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public FunctionInfo save(FunctionInfo functionInfo) {
		return functionInfoRepository.save(functionInfo);
	}

	/**
	 * @Title: 根据id获取权限菜单
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:36:51
	 * @param id 功能权限id
	 * @return FunctionInfo 权限菜单
	 * @see com.zlp.zlijuan.service.BaseService#findOne(java.lang.Long)
	 */
	@Override
	public FunctionInfo findOne(Long id) {
		return functionInfoRepository.findOne(id);
	}

	/**
	 * @Title: 根据id删除功能权限
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:37:46
	 * @param id 功能权限id
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		functionInfoRepository.delete(id);
	}

	/**
	 * @Title: 获取功能权限分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:38:28
	 * @param pageable 分页请求对象
	 * @return Page<FunctionInfo> 分页数据
	 * @see com.zlp.zlijuan.service.BaseService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<FunctionInfo> findAll(Pageable pageable) {
		return functionInfoRepository.findAll(pageable);
	}

	/**
	 * @Title: 获取所有功能权限数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:39:00
	 * @return List<FunctionInfo> 功能权限集合
	 * @see com.zlp.zlijuan.service.BaseService#findAll()
	 */
	@Override
	public List<FunctionInfo> findAll() {
		return functionInfoRepository.findAll();
	}

	/**
	 * @Title: 获取一级功能权限数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:39:49
	 * @return List<FunctionInfo> 一级功能权限数据集合
	 * @see com.zlp.zlijuan.service.FunctionInfoService#findByParentFunctionInfoIsNull()
	 */
	@Override
	public List<FunctionInfo> findByParentFunctionInfoIsNull() {
		return functionInfoRepository.findByParentFunctionInfoIsNull();
	}

	/**
	 * @Title: 批量删除功能权限
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:40:35
	 * @param functionInfos 需要删除的功能权限集合
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.util.List)
	 */
	@Override
	public void delete(List<FunctionInfo> functionInfos) {
		functionInfoRepository.delete(functionInfos);
	}

}
