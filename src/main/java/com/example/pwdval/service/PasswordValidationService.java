package com.example.pwdval.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.example.pwdval.exception.BadRequestException;
import com.example.pwdval.exception.MandatoryParamException;
import com.example.pwdval.exception.ResourceFormatException;
import com.example.pwdval.model.ResponseModel;

/**
 * 
 * @author Arindam Dutta
 *
 */
@Service
public class PasswordValidationService {

	private static final String PASSWORD = "password";
	private static final String LOWER_CASE_REGEX = "^(?=.*[a-z]).+$";
	private static final String UPPER_CASE_REGEX = "^(?=.*[A-Z]).+$";
	private static final String NUMBER_REGEX = "^(?=.*\\d).+$";

	public ResponseModel validatePassword(Map<String, String> map, String validatePassword2) {

		int count = 0;
		ResponseModel response = new ResponseModel();
		final String password = map.get(PASSWORD);

		if (password == null) {
			if (validatePassword2 == null) {
				throw new MandatoryParamException("Password cannot be null or empty.");
			}
		} else {
			count++;
		}

		if (password.length() <= 8) {
			if (validatePassword2 == null) {
				throw new ResourceFormatException("Password should be greater than 8 characters.");
			}
		} else {
			count++;
		}

		if (isMatched(password, UPPER_CASE_REGEX)) {
			count++;
		} else {
			if (validatePassword2 == null) {
				throw new BadRequestException("Password should contain atleast one upper case character.");
			}
		}

		if (isMatched(password, LOWER_CASE_REGEX)
				&& (validatePassword2 == null || validatePassword2 != null && count < 3)) {
			response.setIsContainsLowerCase(true);
			count++;
		} else {
			if (validatePassword2 == null) {
				throw new BadRequestException("Password should contain atleast one lower case character.");
			}
		}

		if (isMatched(password, NUMBER_REGEX)
				&& (validatePassword2 == null || validatePassword2 != null && count < 3)) {
			count++;
		} else {
			if (validatePassword2 == null) {
				throw new BadRequestException("Password should contain atleast one number.");
			}
		}
		response.setCount(count);
		return response;
	}

	private boolean isMatched(String password, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);

		if (m.matches()) {
			return true;
		}
		return false;
	}

	public String validatePassword2(Map<String, String> map) {
		ResponseModel response = validatePassword(map, "validatePassword2");
		if (response.getCount() >= 3) {
			return ResponseModel.validPasswordResponse;
		}
		return ResponseModel.invalidPasswordResponse;
	}

	public String validatePassword3(Map<String, String> map) {
		final String password = map.get(PASSWORD);
		if (isMatched(password, LOWER_CASE_REGEX)) {
			return ResponseModel.validPasswordResponse;
		}
		return ResponseModel.invalidPasswordResponse;
	}
}
