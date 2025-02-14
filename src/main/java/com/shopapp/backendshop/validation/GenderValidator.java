package com.shopapp.backendshop.validation;

import com.shopapp.backendshop.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class GenderValidator implements ConstraintValidator<GenderEnum, Gender> {

    private Gender[] values;

    @Override
    public void initialize(GenderEnum constraintAnnotation) {
        this.values = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Gender gender, ConstraintValidatorContext constraintValidatorContext) {
        return values == null || Arrays.asList(values).contains(gender);
    }
}
