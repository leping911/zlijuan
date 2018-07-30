package com.zlp.zlijuan.commons.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Title: 文件读取工具类
 * @ClassName: FileUtils.java  
 * @Package: com.zlp.zlijuan.commons.utils
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午7:04:09
 * @version: V1.0
 */
public class FileUtils {
	
	/**
	 * @Title: 从文件读取json对象
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午7:12:19
	 * @param filePath 文件路径
	 * @return: JSONObject json对象
	 */
	public static JSONObject getJSONObjectFromClasspathFile(String filePath) {
		JSONObject jsonObject = null;
		try {
			File file = ResourceUtils.getFile("classpath:" + filePath);
			String content = org.apache.commons.io.FileUtils.readFileToString(file, Charset.defaultCharset());
			jsonObject = JSON.parseObject(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
