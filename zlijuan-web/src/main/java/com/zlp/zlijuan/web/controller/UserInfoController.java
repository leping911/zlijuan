package com.zlp.zlijuan.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlp.zlijuan.commons.domain.UserInfo;
import com.zlp.zlijuan.commons.domain.VO.ResultData;
import com.zlp.zlijuan.service.RoleInfoService;
import com.zlp.zlijuan.service.UserInfoService;

/**
 * @Title: 用户管理控制层
 * @ClassName: UserInfoController.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午9:10:14
 * @version: V1.0
 */
@Controller
@RequestMapping("user")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	RoleInfoService roleInfoService;
	
	/**
	 * @Title: 用户管理列表页面
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:10:42
	 * @param model 数据模型对象
	 * @return String 视图
	 */
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("roleInfos", roleInfoService.findAll());
		return "user/list";
	}
	
	/**
	 * @Title: 获取用户分页数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午9:11:21
	 * @param pageRequest
	 * @return
	 */
	@GetMapping("page")
	@ResponseBody
	public Page<UserInfo> page(PageRequest pageRequest){
		return userInfoService.findAll(pageRequest);
	}
	
	/**
	 * 保存用户信息
	 * @Description: 
	 * @author Leepec
	 * @date 2018年4月10日 上午9:30:25
	 * @param userInfo
	 * @return void
	 */
	@PostMapping("save")
	@ResponseBody
	public ResultData<UserInfo> save(@RequestBody UserInfo userInfo) {
		ResultData<UserInfo> resultData = new ResultData<>();
		//根据用户名判断是否已经存在对应用户名的用户
		UserInfo existUserInfo = userInfoService.findByUserName(userInfo.getUserName());
		if(existUserInfo != null && !existUserInfo.getId().equals(userInfo.getId())) {
			resultData.setSuccess(false);
			resultData.setMsg("用户名已存在");
		} else {
			UserInfo currentUser = userInfoService.findByUserName("admin");
			userInfo.setUserCreate(currentUser);
			userInfo.setUserModified(currentUser);
			userInfo.setGmtCreate(new Date());
			userInfo.setGmtModified(new Date());
			userInfoService.save(userInfo);
			resultData.setData(userInfo);
		}
		return resultData;
	}
	
	
	/**
	 * 根据id删除单个用户信息
	 * @Description: 
	 * @author Leepec
	 * @date 2018年4月10日 下午3:03:32
	 * @param id 用户信息id
	 * @return ResultData<UserInfo>
	 */
	@PostMapping("delete")
	@ResponseBody
	public ResultData<UserInfo> delete(Long id) {
		ResultData<UserInfo> resultData = new ResultData<>();
		try {
			userInfoService.delete(id);
		} catch (Exception e) {
			resultData.setSuccess(false);
			resultData.setMsg("删除失败，请重新操作！");
		}
		return resultData;
	}
	
	/**
	 * 根据id获取用户信息
	 * @Description: 
	 * @author Leepec
	 * @date 2018年4月10日 下午4:02:45
	 * @param id
	 * @return
	 * @return UserInfo
	 */
	@GetMapping("get")
	@ResponseBody
	public UserInfo get(Long id) {
		return userInfoService.findOne(id);
	}
	
	/**
	 * 修改密码
	 * @Description: 
	 * @author Leepec
	 * @date 2018年4月11日 上午11:22:34
	 * @return ResultData<UserInfo>
	 */
	@PostMapping("updatePassword")
	@ResponseBody
	public ResultData<UserInfo> updatePassword(@RequestBody UserInfo userInfo) {
		ResultData<UserInfo> resultData = new ResultData<>();
		try {
			int cnt = userInfoService.updatePassword(userInfo);
			if(cnt == 0) {
				resultData.setSuccess(false);
				resultData.setMsg("未找到对应的用户信息");
			}
		} catch (Exception e) {
			resultData.setSuccess(false);
			resultData.setMsg("删除失败，请重新操作！");
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**
	 * 根据id删除单个用户信息
	 * @Description: 
	 * @author Leepec
	 * @date 2018年4月10日 下午3:03:32
	 * @param id 用户信息id
	 * @return ResultData<UserInfo>
	 */
	@PostMapping("deleteByIds")
	@ResponseBody
	public ResultData<UserInfo> deleteByIds(@RequestParam("ids")Long[] ids) {
		ResultData<UserInfo> resultData = new ResultData<>();
		if(ids != null && ids.length > 0) {
			List<UserInfo> userInfos = null;
			for(Long id : ids) {
				if(id != null) {
					UserInfo userInfo = new UserInfo();
					userInfo.setId(id);
					if(userInfos == null) {
						userInfos = new ArrayList<>();
					}
					userInfos.add(userInfo);
				}
			}
			if(userInfos != null) {
				userInfoService.delete(userInfos);
			}
		}
		return resultData;
	}

}
