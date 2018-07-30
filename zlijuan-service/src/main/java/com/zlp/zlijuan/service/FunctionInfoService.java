package com.zlp.zlijuan.service;

import java.util.List;

import com.zlp.zlijuan.commons.domain.FunctionInfo;

/**
 * @Title: 功能权限服务层接口
 * @ClassName: FunctionInfoService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:23:34
 * @version: V1.0
 */
public interface FunctionInfoService extends BaseService<FunctionInfo>{

	/**
	 * @Title: 获取顶级菜单
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:23:22
	 * @return
	 * @return: List<FunctionInfo>
	 * @throws
	 */
	List<FunctionInfo> findByParentFunctionInfoIsNull();

}
