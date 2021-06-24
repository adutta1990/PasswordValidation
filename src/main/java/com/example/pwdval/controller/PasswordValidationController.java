package com.example.pwdval.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pwdval.model.ResponseModel;
import com.example.pwdval.service.PasswordValidationService;

/**
 * @author Arindam Dutta
 *
 */
@RestController
@RequestMapping("/validatePassword")
public class PasswordValidationController {

	@Autowired
	private PasswordValidationService passwordValidationService;

	@PostMapping
	public String validatePassword(@RequestBody Map<String, String> map) {
		passwordValidationService.validatePassword(map, null);
		return ResponseModel.validPasswordResponse;
	}

	@PostMapping("/feature1")
	public String validatePassword2(@RequestBody Map<String, String> map) {
		return passwordValidationService.validatePassword2(map);
	}

	@PostMapping("/feature2")
	public String validatePassword3(@RequestBody Map<String, String> map) {
		return passwordValidationService.validatePassword3(map);
	}
}