package com.example.pwdval.exception;

import java.util.Arrays;
import java.util.List;

public class ResourceFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String message;
	private final List<String> data;

	public ResourceFormatException(String message, Exception ex) {
		super(ex);
		this.message = message;
		this.data=null;
	}

	public ResourceFormatException(String message) {
		this.message = message;
		this.data=null;
	}

	public ResourceFormatException(String message, List<String> data) {
		super();
		this.message = message;
		this.data = data;
	}

	public ResourceFormatException(String message, String data) {
		super();
		this.message = message;
		this.data = Arrays.asList(data.split(","));
	}

	public ResourceFormatException(String message, List<String> data, Exception e) {
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
