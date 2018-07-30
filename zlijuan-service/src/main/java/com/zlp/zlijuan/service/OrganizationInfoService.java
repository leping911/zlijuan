package com.zlp.zlijuan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zlp.zlijuan.commons.domain.OrganizationInfo;


/**
 * @Title: 机构服务层接口
 * @ClassName: OrganizationInfoService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:27:25
 * @version: V1.0
 */
public interface OrganizationInfoService extends BaseService<OrganizationInfo>{

	/**
	 * @Title: 根据编号获取机构信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:27:39
	 * @param orgUnitCode 机构编号
	 * @return: OrganizationInfo 机构对象
	 */
	OrganizationInfo findByOrgUnitCode(String orgUnitCode);

	/**
	 * @Title: 获取子用户组分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:28:08
	 * @param pageRequst 分页请求对象
	 * @param parentOrganizationInfo 父用户组
	 * @return: Page<OrganizationInfo> 子用户组集合
	 */
	Page<OrganizationInfo> findByParentOrganizationInfo(Pageable pageable,
			OrganizationInfo parentOrganizationInfo);
	
}
