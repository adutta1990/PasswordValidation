package com.example.pwdval.exception;

import java.util.Arrays;
import java.util.List;


public class MandatoryParamException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String message;
	private final List<String> data;

	public MandatoryParamException(String message) {
		super();
		this.message = message;
		this.data = null;
	}

	public MandatoryParamException(String message, Exception e) {
		super(e);
		this.message = message;
		this.data = null;
	}

	public MandatoryParamException(String message, List<String> data) {
		super();
		this.message = message;
		this.data = data;
	}

	public MandatoryParamException(String message, String data) {
		super();
		this.message = message;
		this.data = Arrays.asList(data.split(","));
	}

	public MandatoryParamException(String message, List<String> data, Exception e) {
		super(e);
		this.message = message;
		this.data = data;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public List<String> getData() {
		return data;
	}


}
