package com.zlp.zlijuan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zlp.zlijuan.commons.domain.LogInfo;

/**
 * @Title: 日志持久层
 * @ClassName: LogInfoRepository.java  
 * @Package: com.zlp.zlijuan.dao
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:13:18
 * @version: V1.0
 */
public interface LogInfoRepository extends JpaRepository<LogInfo, Long>{

}
