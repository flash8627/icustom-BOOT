package com.gwtjs.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: GlobalExceptionHandler Description:
 */
public class GlobalExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = CustomException.class)
	@ResponseBody
	public ResponseEntity<String> defaultErrorHandler(HttpServletRequest req,
			CustomException e) throws Exception {
		return ResponseEntity.ok("ok");
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
}
