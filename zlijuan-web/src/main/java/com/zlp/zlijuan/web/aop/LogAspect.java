package com.zlp.zlijuan.web.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.zlp.zlijuan.commons.domain.LogInfo;
import com.zlp.zlijuan.commons.enums.LogTypeEnum;
import com.zlp.zlijuan.service.LogInfoService;
import com.zlp.zlijuan.web.annotation.UserLog;

/**
 * @Title: 日志切面类
 * @ClassName: LogAspect.java  
 * @Package: com.zlp.zlijuan.web.aop
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:23:26
 * @version: V1.0
 */
@Aspect
@Component
public class LogAspect {
	
	@Autowired
	LogInfoService logInfoService;
	
	private static final Logger logger = LogManager.getLogger(LogAspect.class);
	
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	/**
	 * @Title: 切入点
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:25:38
	 */
	@Pointcut("@annotation(com.zlp.zlijuan.web.annotation.UserLog)")
	public void controllerAspect() {
	}

	/**
	 * @Title: 切入前执行，记录请求开始时间
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:24:34
	 * @param joinPoint 切面对象
	 * @throws Throwable
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
	}

	/**
	 * @Title: 返回后执行
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:26:23
	 * @param joinPoint 切面对象
	 * @param ret 返回对象
	 * @throws Throwable
	 */
	@AfterReturning(returning = "ret", pointcut = "controllerAspect()")
	public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		//类名.方法
		String klass_method = ms.getDeclaringTypeName() + "." + ms.getName();
		// 入参value
		String args = Arrays.toString(joinPoint.getArgs());

		Method method = ms.getMethod();
		// 方法的注解对象
		UserLog userLog = method.getAnnotation(UserLog.class);
		
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		String url = request.getRequestURL().toString();
		String http_method = request.getMethod();
		String ip = request.getRemoteAddr();
		
		LogInfo logInfo = new LogInfo();
		logInfo.setModuleType(userLog.module());
		logInfo.setOperationType(userLog.type());
		logInfo.setOperationName(userLog.name());
		logInfo.setDescription(userLog.description());
		logInfo.setArgs(args);
		logInfo.setKlassMethod(klass_method);
		logInfo.setHttpMethod(http_method);
		logInfo.setRequestIp(ip);
		logInfo.setRequestUrl(url);
		logInfo.setLogType(LogTypeEnum.NORMAL);
		logInfo.setJsonResult(JSONObject.toJSONString(ret));
		logInfo.setConsumeTime(System.currentTimeMillis() - startTime.get());
		saveLogInfo(logInfo);
	}

	/**
	 * @Title: 后置异常通知
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:26:56
	 * @param joinPoint 切面对象
	 * @param ex 异常
	 */
	@AfterThrowing(throwing = "ex", pointcut = "controllerAspect()")
	public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
		
		logger.error("错误信息", ex);
		
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		//类名.方法
		String klass_method = ms.getDeclaringTypeName() + "." + ms.getName();
		// 入参value
		String args = Arrays.toString(joinPoint.getArgs());

		Method method = ms.getMethod();
		// 方法的注解对象
		UserLog userLog = method.getAnnotation(UserLog.class);
		
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		String url = request.getRequestURL().toString();
		String http_method = request.getMethod();
		String ip = request.getRemoteAddr();
		
		LogInfo logInfo = new LogInfo();
		logInfo.setModuleType(userLog.module());
		logInfo.setOperationType(userLog.type());
		logInfo.setOperationName(userLog.name());
		logInfo.setDescription(userLog.description());
		logInfo.setArgs(args);
		logInfo.setKlassMethod(klass_method);
		logInfo.setHttpMethod(http_method);
		logInfo.setRequestIp(ip);
		logInfo.setRequestUrl(url);
		logInfo.setLogType(LogTypeEnum.ERROR);
		logInfo.setExceptionCode(HttpServletResponse.SC_BAD_REQUEST);
		logInfo.setExceptionDetail(ex.getMessage());
		logInfo.setConsumeTime(System.currentTimeMillis() - startTime.get());
		saveLogInfo(logInfo);
	}
	
	/**
	 * @Title: 异步保存日志
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:27:20
	 * @param logInfo
	 */
	@Async
	private void saveLogInfo(LogInfo logInfo) {
		logInfoService.save(logInfo);
	}
}
