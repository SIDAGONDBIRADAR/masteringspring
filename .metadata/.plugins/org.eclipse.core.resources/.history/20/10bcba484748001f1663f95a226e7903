package com.eazybytes.eazyschool.validations;

import org.springframework.beans.BeanWrapperImpl;

import com.eazybytes.eazyschool.annotations.FieldsValueMatch;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

	private String field;
	private String fieldmatch;

	@Override
	public void initialize(FieldsValueMatch constarintAnnotation) {
		this.field = constarintAnnotation.field();
		this.fieldmatch = constarintAnnotation.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldmatch);
		if (fieldValue != null) {
			return fieldValue.equals(fieldMatchValue);
		} else {
			return fieldMatchValue == null;
		}
	}

}
