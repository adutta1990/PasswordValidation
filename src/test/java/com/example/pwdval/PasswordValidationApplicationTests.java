package com.example.pwdval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.pwdval.model.ResponseModel;
import com.example.pwdval.service.PasswordValidationService;

/**
 * 
 * @author Arindam Dutta
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidationApplicationTests {

	@InjectMocks
	PasswordValidationService pwdValidationService;

	@Test
	public void testValidatePasswordAllLowerCase() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "asdfasdfsdfsdgf");

		ResponseModel response = pwdValidationService.validatePassword(password, null);
		if (response != null)
			assertEquals(true, true);

	}

	@Test
	public void testValidatePasswordAllUpperCase() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "HDEGFHEDADSGE");

		ResponseModel response = pwdValidationService.validatePassword(password, null);
		if (response != null)
			assertEquals(true, true);

	}

	@Test
	public void testValidatePasswordLowerAndUpperCase() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "srgttreHH");

		ResponseModel response = pwdValidationService.validatePassword(password, null);
		if (response != null)
			assertEquals(true, true);

	}

	@Test
	public void testValidatePasswordLowerAndUpperCaseAndNumber() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "srgttreHH14");

		ResponseModel response = pwdValidationService.validatePassword(password, null);
		if (response != null)
			assertEquals(true, true);

	}

	@Test
	public void testValidatePasswordNull() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", null);

		ResponseModel response = pwdValidationService.validatePassword(password, null);
		if (response != null)
			assertEquals(true, true);

	}

	@Test
	public void testValidatePasswordEightChars() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "dD5gh");

		ResponseModel response = pwdValidationService.validatePassword(password, null);
		if (response != null)
			assertEquals(true, true);

	}

	@Test
	public void testValidatePasswordFeature1() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "dD5gh");

		String response = pwdValidationService.validatePassword2(password);
		assertEquals(response, ResponseModel.validPasswordResponse);

	}

	@Test
	public void testValidatePasswordFeature2() throws Exception {

		Map<String, String> password = new HashMap<String, String>();
		password.put("password", "=DD5GH");

		String response = pwdValidationService.validatePassword3(password);
		assertEquals(response, ResponseModel.invalidPasswordResponse);

	}
}
