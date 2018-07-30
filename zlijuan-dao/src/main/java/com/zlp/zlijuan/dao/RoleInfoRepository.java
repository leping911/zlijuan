package com.zlp.zlijuan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zlp.zlijuan.commons.domain.RoleInfo;

/**
 * @Title: 角色持久类
 * @ClassName: RoleInfoRepository.java  
 * @Package: com.zlp.zlijuan.dao
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:17:11
 * @version: V1.0
 */
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long>{

}
