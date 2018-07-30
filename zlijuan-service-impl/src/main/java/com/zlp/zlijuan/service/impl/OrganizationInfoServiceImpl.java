package com.zlp.zlijuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;
import com.zlp.zlijuan.dao.OrganizationInfoRepository;
import com.zlp.zlijuan.service.OrganizationInfoService;

/**
 * @Title: 组织机构服务层
 * @ClassName: OrganizationInfoServiceImpl.java  
 * @Package: com.zlp.zlijuan.service.impl
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:52:20
 * @version: V1.0
 */
@Service("organizationInfoService")
public class OrganizationInfoServiceImpl implements OrganizationInfoService {

	@Autowired
	OrganizationInfoRepository organizationInfoRepository;

	/**
	 * @Title: 保存组织机构信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:52:38
	 * @param organizationInfo 机构数据
	 * @return OrganizationInfo 机构数据
	 * @see com.zlp.zlijuan.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public OrganizationInfo save(OrganizationInfo organizationInfo) {
		return organizationInfoRepository.save(organizationInfo);
	}

	/**
	 * @Title: 根据id获取机构信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:53:04
	 * @param id 机构id
	 * @return OrganizationInfo 机构数据
	 * @see com.zlp.zlijuan.service.BaseService#findOne(java.lang.Long)
	 */
	@Override
	public OrganizationInfo findOne(Long id) {
		return organizationInfoRepository.findOne(id);
	}

	/**
	 * @Title: 根据id删除机构
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:53:30
	 * @param id 机构id
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		organizationInfoRepository.delete(id);		
	}

	
	/**
	 * @Title: 获取机构分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:53:53
	 * @param pageable 分页请求对象
	 * @return Page<OrganizationInfo> 机构分页数据
	 * @see com.zlp.zlijuan.service.BaseService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<OrganizationInfo> findAll(Pageable pageable) {
		return organizationInfoRepository.findAll(pageable);
	}

	/**
	 * @Title: 获取所有机构数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:54:34
	 * @return List<OrganizationInfo> 机构数据集合
	 * @see com.zlp.zlijuan.service.BaseService#findAll()
	 */
	@Override
	public List<OrganizationInfo> findAll() {
		return organizationInfoRepository.findAll();
	}

	/**
	 * @Title: 根据编号查找机构
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:54:58
	 * @param orgUnitCode 机构编号
	 * @return OrganizationInfo 机构
	 * @see com.zlp.zlijuan.service.OrganizationInfoService#findByOrgUnitCode(java.lang.String)
	 */
	@Override
	public OrganizationInfo findByOrgUnitCode(String orgUnitCode) {
		return organizationInfoRepository.findByOrgUnitCode(orgUnitCode);
	}

	/**
	 * @Title: 批量删除机构信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:55:26
	 * @param organizationInfos 需要删除的机构对象集合
	 * @see com.zlp.zlijuan.service.BaseService#delete(java.util.List)
	 */
	@Override
	public void delete(List<OrganizationInfo> organizationInfos) {
		organizationInfoRepository.delete(organizationInfos);
	}

	/**
	 * @Title: 根据父用户组获取子用户组分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:55:49
	 * @param pageable 分页请求对象
	 * @param parentOrganizationInfo 父用户组
	 * @return Page<OrganizationInfo> 机构分页数据
	 * @see com.zlp.zlijuan.service.OrganizationInfoService#findByParentOrganizationInfo(org.springframework.data.domain.PageRequest, com.zlp.zlijuan.commons.domain.OrganizationInfo)
	 */
	@Override
	public Page<OrganizationInfo> findByParentOrganizationInfo(Pageable pageable,
			OrganizationInfo parentOrganizationInfo) {
		return organizationInfoRepository.findByParentOrganizationInfo(pageable, parentOrganizationInfo);
	}
	
}
