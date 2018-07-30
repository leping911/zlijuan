package com.zlp.zlijuan.web.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zlp.zlijuan.web.resolver.PageRequestArgumentResolver;

/**
 * @Title: web mvc配置类
 * @ClassName: WebAppConfig.java  
 * @Package: com.zlp.zlijuan.web.config
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:36:29
 * @version: V1.0
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new PageRequestArgumentResolver());
    }
	
}
