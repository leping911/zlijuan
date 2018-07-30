package com.zlp.zlijuan.service;

/**
 * @Title: 初始化数据
 * @ClassName: InitializeService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:24:21
 * @version: V1.0
 */
public interface InitializeService {
	
	/**
	 * @Title: 初始化用户
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:24:33
	 */
	void initializeUser();
	
	/**
	 * @Title: 初始化组织机构
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:24:45
	 */
	void initializeOrganization();
	
	/**
	 * @Title: 初始化角色
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:25:02
	 */
	void initializeRole();
	
	/**
	 * @Title: 初始化权限菜单
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:25:14
	 */
	void initializeFunction();

}
