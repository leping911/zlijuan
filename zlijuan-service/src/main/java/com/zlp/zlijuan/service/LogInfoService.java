package com.zlp.zlijuan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zlp.zlijuan.commons.domain.LogInfo;

/**
 * @Title: 日志服务层接口
 * @ClassName: LogInfoService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:25:42
 * @version: V1.0
 */
public interface LogInfoService {
	
	/**
	 * @Title: 保存
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:25:57
	 * @param logInfo 日志对象
	 * @return: LogInfo 日志对象
	 */
	LogInfo save(LogInfo logInfo);
	
	/**
	 * @Title: 获取日志分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:26:20
	 * @param pageable 分页请求参数对象
	 * @return: Page<LogInfo> 分页数据
	 */
	Page<LogInfo> findAll(Pageable pageable);
	
	/**
	 * @Title: 获取所有日志
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:26:47
	 * @return: List<LogInfo> 日志集合
	 */
	List<LogInfo> findAll();
}
