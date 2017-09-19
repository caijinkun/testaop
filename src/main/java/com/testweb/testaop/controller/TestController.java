package com.testweb.testaop.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testweb.testaop.dto.JsonResult;
import com.testweb.testaop.param.Add;
import com.testweb.testaop.param.Edit;
import com.testweb.testaop.param.Test2Param;
import com.testweb.testaop.param.TestParam;

@RestController
@RequestMapping("/test")
public class TestController {
	/**
	 * SpringMVC校验:
	 * 如果@Valid后不加BindingResult参数，后端直接报错，这样前端无法接收错误信息;
	 * 若加BindingResult参数，后端不会报错，不过需要手动处理BindingResult:
	 * if(br.hasErrors()){
	 * 		List<FieldError> fieldErrors = br.getFieldErrors();
	 *		for(FieldError fieldError:fieldErrors){
	 *			...
	 *		}
	 * }
	 * 此处使用{@link com.testweb.testaop.aop.TestAOP}做通用处理
	 */
	@RequestMapping("/test1")
	public JsonResult test1(@Validated(Add.class) TestParam param, BindingResult br){

		return JsonResult.success("test1通过校验");
	}
	/**
	 * SpringMVC校验:
	 * 1、BindingResult的参数需要紧跟在@Valid后面；
	 * 2、多个@Valid需要对应多个BindingResult
	 */
	@RequestMapping("/test2")
	public JsonResult test2(@Validated({ Add.class, Edit.class }) TestParam param, BindingResult br,
			@Validated Test2Param param2, BindingResult br2) {
		return JsonResult.success("test2通过校验");
	}
}
