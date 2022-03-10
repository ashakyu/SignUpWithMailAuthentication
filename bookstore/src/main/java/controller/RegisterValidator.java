package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		
		ValidationUtils.rejectIfEmpty(errors, "isbn", "required","필수 정보입니다.");
		ValidationUtils.rejectIfEmpty(errors, "name", "required","필수 정보입니다.");
		ValidationUtils.rejectIfEmpty(errors, "auth", "required","필수 정보입니다.");
		ValidationUtils.rejectIfEmpty(errors, "publisher","required", "필수 정보입니다.");
		ValidationUtils.rejectIfEmpty(errors, "price", "required","필수 정보입니다.");
		ValidationUtils.rejectIfEmpty(errors, "description","required", "필수 정보입니다.");
		ValidationUtils.rejectIfEmpty(errors, "image", "required", "필수 정보입니다.");
	}

}
