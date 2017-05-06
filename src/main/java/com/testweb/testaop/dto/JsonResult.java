package com.testweb.testaop.dto;

import com.testweb.testaop.enums.ResultCode;

public class JsonResult {
	private Integer code;
	private String msg;
	private Object data;
	
	public JsonResult(){}
	public JsonResult(ResultCode resultCode){
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
	}
	public JsonResult(ResultCode resultCode, Object data){
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.setData(data);
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static JsonResult success(){
		return new JsonResult(ResultCode.SUCCESS); 
	}
	
	public static JsonResult success(Object data){
		return new JsonResult(ResultCode.SUCCESS, data);
	}
	
	public static JsonResult fail(){
		return new JsonResult(ResultCode.FAIL);
	}
	
	public static JsonResult fail(Object data){
		return new JsonResult(ResultCode.FAIL, data);
	}
}
