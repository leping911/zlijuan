package com.zlp.zlijuan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Title: 基础业务处理Service
 * @ClassName: BaseService.java  
 * @Package: com.zlp.zlijuan.service
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:19:35
 * @version: V1.0
 */
public interface BaseService<T> {
	
	/**
	 * @Title: 保存
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:19:46
	 * @param t <T>泛型对象
	 * @return: T 泛型对象
	 */
	T save(T t);
	
	/**
	 * @Title: 通过id查找对象
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:20:27
	 * @param id 对象id
	 * @return: T 泛型对象
	 */
	T findOne(Long id);
	
	/**
	 * @Title: 删除
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:21:11
	 * @param id 对象id
	 * @return: void 
	 */
	void delete(Long id);
	
	/**
	 * @Title: 批量删除
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:21:44
	 * @param t 对象集合
	 * @return: void
	 */
	void delete(List<T> t);
	
	/**
	 * @Title: 数据分页
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:22:10
	 * @param pageable 分页请求参数
	 * @return: Page<T> 分页数据
	 */
	Page<T> findAll(Pageable pageable);
	
	/**
	 * @Title: 获取所有数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:22:40
	 * @return: List<T> 数据集合
	 */
	List<T> findAll();
}
