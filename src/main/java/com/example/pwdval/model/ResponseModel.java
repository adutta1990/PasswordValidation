package com.example.pwdval.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String validPasswordResponse = "Password is Valid";
	public static final String invalidPasswordResponse = "Password is Invalid";
	private Integer count = 0;
	private Boolean isContainsLowerCase = false;
	
	public Boolean getIsContainsLowerCase() {
		return isContainsLowerCase;
	}
	public void setIsContainsLowerCase(Boolean isContainsLowerCase) {
		this.isContainsLowerCase = isContainsLowerCase;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
