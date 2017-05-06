package com.testweb.testaop.param;

import org.hibernate.validator.constraints.NotBlank;

public class TestParam {
	@NotBlank(message = "prop1 不能为空")
	private String prop1;
	@NotBlank(message = "prop2 不能为空")
	private String prop2;
	
	public String getProp1() {
		return prop1;
	}
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
	public String getProp2() {
		return prop2;
	}
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}
}
