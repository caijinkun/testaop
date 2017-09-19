package com.testweb.testaop.aop;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.testweb.testaop.dto.JsonResult;
import com.testweb.testaop.enums.ResultCode;

@Aspect
public class TestAOP {
	/**
	 * bean名以Controller结尾的
	 */
	@Pointcut("bean(*Controller)")
	public void controllerSuffix(){
		
	}
	
	/**
	 * controller包中的public方法
	 */
	@Pointcut("execution(public * com.testweb.testaop.controller..*.* (..))") 
    public void controllerPackage() {

    }
	
	/**
	 * 包含BindingResult参数
	 */
	@Pointcut("execution(public * com.testweb.testaop.controller..*.* (.., org.springframework.validation.BindingResult, ..))") 
	public void bindingResultArgs() {
		
	}
	
	/**
	 * 检查bindingResult中是否 hasErrors
	 * @param pJoinPoint
	 */
	@Around(value="controllerSuffix() && bindingResultArgs()")
	public Object checkBindingResult(ProceedingJoinPoint pJoinPoint) throws Throwable{
		Map<String, String> errMsg = new LinkedHashMap<>();
		boolean hasErr = false;
		
		for(Object arg : pJoinPoint.getArgs()){
			if(!(arg instanceof BindingResult)){
				continue;
			}
			BindingResult br = (BindingResult) arg;
			if(br.hasErrors()){
				hasErr = true;
				List<FieldError> fieldErrors = br.getFieldErrors();
				for(FieldError fieldError:fieldErrors){
					errMsg.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
			}
		}
		if(hasErr){
			return new JsonResult(ResultCode.PARAM_INVALID, errMsg);
		}
		Object result = pJoinPoint.proceed();
		return result;
	}
}
