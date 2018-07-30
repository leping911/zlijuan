package com.zlp.zlijuan.web.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zlp.zlijuan.commons.exception.ErrorInfo;
import com.zlp.zlijuan.commons.exception.FailedException;

/**
 * @Title: 全局异常处理类
 * @ClassName: GlobalExceptionHandler.java  
 * @Package: com.zlp.zlijuan.web.config
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author: leping.zeng
 * @date: 2018年7月29日 下午8:28:07
 * @version: V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public static final String DEFAULT_ERROR_VIEW = "error";

	/**
	 * @Title: 默认异常处理
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:28:24
	 * @param req http请求对象
	 * @param e 异常
	 * @return ModelAndView
	 */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		logger.error(e.getMessage(), e);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	/**
	 * @Title: 处理FailedException
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:29:52
	 * @param req http请求对象
	 * @param e 异常
	 * @return ErrorInfo<String> 错误数据
	 */
	@ExceptionHandler(value = FailedException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, FailedException e) {
		logger.error(e.getMessage(), e);
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}

	/**
	 * @Title: 处理所有接口数据验证异常
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: leping.zeng
	 * @date: 2018年7月29日 下午8:30:35
	 * @param req http请求对象
	 * @param e 异常
	 * @return ErrorInfo<String> 错误数据
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ErrorInfo<String> handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
}
