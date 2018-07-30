package com.zlp.zlijuan.web.resolver;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Title: 分页参数处理类
 * @ClassName: PageRequestArgumentResolver.java  
 * @Package: com.zlp.zlijuan.web.resolver
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:38:58
 * @version: V1.0
 */
public class PageRequestArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return PageRequest.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		int page = 0;
		int size = 10;
		String limit = webRequest.getParameter("limit");
		String offset = webRequest.getParameter("offset");
		String sortName = webRequest.getParameter("sort");
		String order = webRequest.getParameter("order");
		Sort sort = null;
		if(StringUtils.isNotEmpty(sortName)) {
			if(Direction.DESC.toString().equalsIgnoreCase(order)) {
				sort = new Sort(Direction.DESC, sortName);
			} else {
				sort = new Sort(Direction.ASC, sortName);
			}
		}
		if(StringUtils.isNumeric(limit)) {
			size = Integer.parseInt(limit);
		}
		if(StringUtils.isNumeric(offset)) {
			page = Integer.parseInt(offset)/size;
		}
		PageRequest pageRequest = new PageRequest(page, size, sort);
		return pageRequest;
	}

}
