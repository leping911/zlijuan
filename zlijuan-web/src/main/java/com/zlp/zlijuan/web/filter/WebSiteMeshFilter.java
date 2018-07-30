package com.zlp.zlijuan.web.filter;

import javax.servlet.annotation.WebFilter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * @Title: sitemesh过滤器
 * @ClassName: WebSiteMeshFilter.java  
 * @Package: com.zlp.zlijuan.web.filter
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月31日 上午12:35:27
 * @version: V1.0
 */
@WebFilter
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	
    @Override
    public void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/decorators/meta");
        builder.addExcludedPath("/decorators/*");
        builder.addExcludedPath("/login**");
        builder.addExcludedPath("/swagger-ui.html");
        builder.addExcludedPath("/error");
    }
}
