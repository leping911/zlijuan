package com.zlp.zlijuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zlp.zlijuan.commons.domain.FunctionInfo;
import com.zlp.zlijuan.commons.domain.OrganizationInfo;
import com.zlp.zlijuan.commons.domain.RoleInfo;
import com.zlp.zlijuan.commons.domain.UserInfo;
import com.zlp.zlijuan.commons.enums.FunctionTypeEnum;
import com.zlp.zlijuan.commons.enums.GenderEnum;
import com.zlp.zlijuan.commons.enums.OrganizationTypeEnum;
import com.zlp.zlijuan.commons.enums.RoleTypeEnum;
import com.zlp.zlijuan.commons.enums.UserTypeEnum;
import com.zlp.zlijuan.commons.utils.FileUtils;
import com.zlp.zlijuan.service.FunctionInfoService;
import com.zlp.zlijuan.service.InitializeService;
import com.zlp.zlijuan.service.OrganizationInfoService;
import com.zlp.zlijuan.service.RoleInfoService;
import com.zlp.zlijuan.service.UserInfoService;

/**
 * @Title: 初始化数据服务层
 * @ClassName: InitializeServiceImpl.java  
 * @Package: com.zlp.zlijuan.service.impl
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:45:44
 * @version: V1.0
 */
@Service("initializeService")
public class InitializeServiceImpl implements InitializeService {

	@Autowired
	OrganizationInfoService organizationInfoService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	FunctionInfoService functionInfoService;
	
	@Autowired
	RoleInfoService roleInfoService;

	/**
	 * @Title: 初始化用户数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:46:05
	 * @see com.zlp.zlijuan.service.InitializeService#initializeUser()
	 */
	@Transactional
	@Override
	public void initializeUser() {
		/*初始化用户信息*/
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(20);
		userInfo.setNickName("administrator");
		userInfo.setGender(GenderEnum.F);
		userInfo.setUserCode("admin");
		userInfo.setUserName("admin");
		userInfo.setSalt(RandomStringUtils.randomAlphanumeric(20));
		userInfo.setUserPassword("admin");
		userInfo.setUserType(UserTypeEnum.SYSTEM);
		userInfoService.save(userInfo);
		
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setAge(20);
		userInfo2.setNickName("test01");
		userInfo2.setGender(GenderEnum.F);
		userInfo2.setUserCode("test01");
		userInfo2.setUserName("test01");
		userInfo2.setSalt(RandomStringUtils.randomAlphanumeric(20));
		userInfo2.setUserPassword("test01");
		userInfo2.setUserType(UserTypeEnum.NORMAL);
		userInfoService.save(userInfo2);
	}

	/**
	 * @Title: 初始化机构数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:46:24
	 * @see com.zlp.zlijuan.service.InitializeService#initializeOrganization()
	 */
	@Transactional
	@Override
	public void initializeOrganization() {
		List<OrganizationInfo> organizationInfos = getOrganizationInfoFromFile("data/organizationData.json");
		organizationInfos.forEach(organizationInfo -> {
			if(organizationInfo != null) {
				if(organizationInfo.getParentOrganizationInfo() != null) {
					OrganizationInfo parentOrganizationInfo = organizationInfoService.findByOrgUnitCode(organizationInfo.getParentOrganizationInfo().getOrgUnitCode());
					organizationInfo.setParentOrganizationInfo(parentOrganizationInfo);
				}
				organizationInfoService.save(organizationInfo);
			}
		});
	}


	/**
	 * @Title: 初始化角色数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:47:16
	 * @see com.zlp.zlijuan.service.InitializeService#initializeRole()
	 */
	@Override
	public void initializeRole() {
		/*初始化角色信息*/
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleDesc("系统管理员");
		roleInfo.setRoleCode("SAD");
		roleInfo.setRoleName("系统管理员");
		roleInfo.setRoleType(RoleTypeEnum.SYSTEM);
		roleInfoService.save(roleInfo);
		
		/*初始化角色信息*/
		RoleInfo roleInfo2 = new RoleInfo();
		roleInfo2.setRoleDesc("普通管理员");
		roleInfo2.setRoleName("普通管理员");
		roleInfo2.setRoleCode("NAD");
		roleInfo2.setRoleType(RoleTypeEnum.NORMAL);
		roleInfoService.save(roleInfo2);
	}

	/**
	 * @Title: 初始化功能权限数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:47:36
	 * @see com.zlp.zlijuan.service.InitializeService#initializeFunction()
	 */
	@Transactional
	@Override
	public void initializeFunction() {
		FunctionInfo functionInfo = new FunctionInfo();
		functionInfo.setFunctionDesc("基础设置");
		functionInfo.setFunctionName("基础设置");
		functionInfo.setFunctionIcons("fa-wrench");
		functionInfo.setFunctionType(FunctionTypeEnum.MENU);
		functionInfo.setFunctionOrder(1);
		functionInfoService.save(functionInfo);
		
		/*用户管理*/
		FunctionInfo userFunctionInfo = new FunctionInfo();
		userFunctionInfo.setFunctionDesc("用户管理");
		userFunctionInfo.setFunctionName("用户管理");
		userFunctionInfo.setFunctionType(FunctionTypeEnum.MENU);
		userFunctionInfo.setFunctionUrl("/user");
		userFunctionInfo.setFunctionOrder(2);
		userFunctionInfo.setParentFunctionInfo(functionInfo);
		functionInfoService.save(userFunctionInfo);
		
		/*用户管理*/
		FunctionInfo organizationFunctionInfo = new FunctionInfo();
		organizationFunctionInfo.setFunctionDesc("机构管理");
		organizationFunctionInfo.setFunctionName("机构管理");
		organizationFunctionInfo.setFunctionType(FunctionTypeEnum.MENU);
		organizationFunctionInfo.setFunctionUrl("/organization");
		organizationFunctionInfo.setFunctionOrder(3);
		organizationFunctionInfo.setParentFunctionInfo(functionInfo);
		functionInfoService.save(organizationFunctionInfo);
		
		FunctionInfo roleFunctionInfo = new FunctionInfo();
		roleFunctionInfo.setFunctionDesc("角色管理");
		roleFunctionInfo.setFunctionName("角色管理");
		roleFunctionInfo.setFunctionType(FunctionTypeEnum.MENU);
		roleFunctionInfo.setFunctionUrl("/role");
		roleFunctionInfo.setFunctionOrder(4);
		roleFunctionInfo.setParentFunctionInfo(functionInfo);
		functionInfoService.save(roleFunctionInfo);
		
		FunctionInfo functionFunctionInfo = new FunctionInfo();
		functionFunctionInfo.setFunctionDesc("权限管理");
		functionFunctionInfo.setFunctionName("权限管理");
		functionFunctionInfo.setFunctionType(FunctionTypeEnum.MENU);
		functionFunctionInfo.setFunctionUrl("/function");
		functionFunctionInfo.setFunctionOrder(5);
		functionFunctionInfo.setParentFunctionInfo(functionInfo);
		functionInfoService.save(functionFunctionInfo);
	}
	
	/**
	 * @Title: 从文件中读取机构数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:47:54
	 * @param filePath 文件路径
	 * @return List<OrganizationInfo> 机构数据集合
	 */
	public List<OrganizationInfo> getOrganizationInfoFromFile(String filePath) {
		InitializeServiceImpl InitializeServiceImpl = new InitializeServiceImpl();
		JSONObject jsonObject = FileUtils.getJSONObjectFromClasspathFile(filePath);
		OrganizationInfo organizationInfo = new OrganizationInfo();
		organizationInfo.setOrgUnitCode("86");
		organizationInfo.setOrgUnitName("中华人民共和国");
		organizationInfo.setOrgUnitType(OrganizationTypeEnum.NATION);
		organizationInfo.setOrgUnitLevel("1");
		List<OrganizationInfo> list = new ArrayList<>();
		list.add(organizationInfo);
		Integer level = 1;
		InitializeServiceImpl.jsonObjectToBean(jsonObject, list, organizationInfo, level);
		return list;
	}
	
	/**
	 * @Title: 将从文件读取到的json对象转换为机构数据集合
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:48:32
	 * @param jsonObject json对象
	 * @param list 机构数据集合
	 * @param organizationInfo 父机构
	 * @param level 级别
	 */
	public void jsonObjectToBean(JSONObject jsonObject, List<OrganizationInfo> list, OrganizationInfo organizationInfo, Integer level) {
		level++;
		for(String key : jsonObject.keySet()) {
			OrganizationInfo child = new OrganizationInfo();
			list.add(child);
			child.setParentOrganizationInfo(organizationInfo);
			child.setOrgUnitLevel(String.valueOf(level));
			if(level == 2) {
				child.setOrgUnitType(OrganizationTypeEnum.PROVINCE);
			} else if(level == 3){
				child.setOrgUnitType(OrganizationTypeEnum.CITY);
			} else {
				child.setOrgUnitType(OrganizationTypeEnum.COUNTY);
			}
			try {
				JSONObject value = jsonObject.getJSONObject(key);
				if(value != null && !value.isEmpty()) {
					String name = value.getString("name");
					child.setOrgUnitName(name);
				}
				child.setOrgUnitCode(key);
				JSONObject childJSONObject = value.getJSONObject("child");
				if(childJSONObject != null && !childJSONObject.isEmpty()) {
					jsonObjectToBean(childJSONObject, list, child, level);
				}
			} catch (Exception e) {
				child.setOrgUnitCode(key);
				child.setOrgUnitName(jsonObject.getString(key));
			}
		}
	}
}
