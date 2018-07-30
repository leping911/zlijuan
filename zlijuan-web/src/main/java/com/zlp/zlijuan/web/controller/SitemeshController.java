package com.zlp.zlijuan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zlp.zlijuan.commons.domain.FunctionInfo;
import com.zlp.zlijuan.service.FunctionInfoService;

/**
 * @Title: sitemesh视图控制层
 * @ClassName: SitemeshController.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午9:06:21
 * @version: V1.0
 */
@Controller
@RequestMapping("decorators")
public class SitemeshController {

	@Autowired
	FunctionInfoService functionService;
	
	/**
	 * @Title: sitemesh视图
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:06:47
	 * @param model 模型对象
	 * @return String 视图
	 */
    @GetMapping("meta")
    public String sitemesh(Model model) {
    	List<FunctionInfo> functionInfos = functionService.findByParentFunctionInfoIsNull();
    	model.addAttribute("functionInfos", functionInfos);
        return "decorators/meta";
    }
}
