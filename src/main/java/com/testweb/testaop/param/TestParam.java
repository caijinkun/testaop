package com.testweb.testaop.param;

import org.hibernate.validator.constraints.NotBlank;

public class TestParam {
	@NotBlank(groups = {Add.class})
	private String prop1;
	
	
	@NotBlank(groups = {Edit.class})
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
