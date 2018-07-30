package com.zlp.zlijuan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: 登录控制器
 * @ClassName: LoginController.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月31日 上午12:14:10
 * @version: V1.0
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@GetMapping("")
	public String login() {
		return "login";
	}
}
