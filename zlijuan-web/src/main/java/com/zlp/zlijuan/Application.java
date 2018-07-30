package com.zlp.zlijuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Title: 启动类
 * @ClassName: Application.java  
 * @Package: com.zlp.zlijuan
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:39:16
 * @version: V1.0
 */
@SpringBootApplication
@EnableJpaAuditing //允许jpa对象值注入
@ServletComponentScan //自定义@WebFilter需要
@EnableRedisHttpSession //启用redis session
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
