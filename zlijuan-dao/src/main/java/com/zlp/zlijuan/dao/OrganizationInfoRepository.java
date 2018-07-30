package com.zlp.zlijuan.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;

/**
 * @Title: 机构持久层
 * @ClassName: OrganizationInfoRepository.java  
 * @Package: com.zlp.zlijuan.dao
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:13:43
 * @version: V1.0
 */
public interface OrganizationInfoRepository extends JpaRepository<OrganizationInfo, Long>{

	/**
	 * @Title: 根据编号获取机构信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:14:01
	 * @param orgUnitCode 机构编号
	 * @return: OrganizationInfo 机构
	 */
	OrganizationInfo findByOrgUnitCode(String orgUnitCode);

	/**
	 * @Title: 根据父用户组获取子用户组列表
	 * @Description: TODO(父用户组对象只需要id即可)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:14:31
	 * @param parentOrganizationInfo 父用户组
	 * @return: List<OrganizationInfo> 子用户组列表
	 */
	List<OrganizationInfo> findByParentOrganizationInfo(OrganizationInfo parentOrganizationInfo);

	
	/**
	 * @Title: 根据父用户组获取用户组分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:15:09
	 * @param pageable 分页参数对象
	 * @param parentOrganizationInfo 父用户组
	 * @return: Page<OrganizationInfo> 分页数据
	 */
	Page<OrganizationInfo> findByParentOrganizationInfo(Pageable pageable, OrganizationInfo parentOrganizationInfo);

}
