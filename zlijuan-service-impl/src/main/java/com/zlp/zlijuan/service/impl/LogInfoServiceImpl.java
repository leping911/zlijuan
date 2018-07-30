package com.zlp.zlijuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zlp.zlijuan.commons.domain.LogInfo;
import com.zlp.zlijuan.dao.LogInfoRepository;
import com.zlp.zlijuan.service.LogInfoService;

/**
 * @Title: 日志服务层
 * @ClassName: LogInfoServiceImpl.java  
 * @Package: com.zlp.zlijuan.service.impl
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:50:35
 * @version: V1.0
 */
@Service("logInfoService")
public class LogInfoServiceImpl implements LogInfoService {
	
	@Autowired
	LogInfoRepository logInfoRepository;

	/**
	 * @Title: 保存日志信息
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:50:50
	 * @param logInfo 日志对象
	 * @return LogInfo 日志对象
	 * @see com.zlp.zlijuan.service.LogInfoService#save(com.zlp.zlijuan.commons.domain.LogInfo)
	 */
	@Override
	public LogInfo save(LogInfo logInfo) {
		return logInfoRepository.save(logInfo);
	}

	/**
	 * @Title: 获取日志分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:51:18
	 * @param pageable 分页请求对象
	 * @return Page<LogInfo> 日志分页数据
	 * @see com.zlp.zlijuan.service.LogInfoService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<LogInfo> findAll(Pageable pageable) {
		return logInfoRepository.findAll(pageable);
	}

	/**
	 * @Title: 查下所有日志数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:51:50
	 * @return List<LogInfo> 日志集合
	 * @see com.zlp.zlijuan.service.LogInfoService#findAll()
	 */
	@Override
	public List<LogInfo> findAll() {
		return logInfoRepository.findAll();
	}

}
