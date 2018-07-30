package com.zlp.zlijuan.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Title: 用户信息控制层
 * @ClassName: UserInfoControllerTest.java  
 * @Package: com.zlp.zlijuan.web.controller
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:40:35
 * @version: V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoControllerTest {
	
	private MockMvc mvc;

	@Autowired
	protected WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	/**
	 * @Title: 测试用户分页接口
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:41:02
	 * @throws Exception
	 */
	@Test
	public void testPage() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/user/page").param("page", "0").param("size", "1").accept(MediaType.APPLICATION_JSON);
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	}
	
}
