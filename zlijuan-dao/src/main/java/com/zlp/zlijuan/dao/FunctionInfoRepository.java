package com.zlp.zlijuan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zlp.zlijuan.commons.domain.FunctionInfo;

/**
 * @Title: 功能权限持久层
 * @ClassName: FunctionInfoRepository.java  
 * @Package: com.zlp.zlijuan.dao
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:07:49
 * @version: V1.0
 */
public interface FunctionInfoRepository extends JpaRepository<FunctionInfo, Long>{

	/**
	 * @Title: 查找一级功能权限菜单
	 * @Description: TODO(查找父id为空的一级功能菜单)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:10:38
	 * @return: List<FunctionInfo>
	 */
	List<FunctionInfo> findByParentFunctionInfoIsNull();

}
