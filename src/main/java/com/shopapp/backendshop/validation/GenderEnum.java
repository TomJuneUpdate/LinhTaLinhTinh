package com.shopapp.backendshop.validation;

import com.shopapp.backendshop.enums.Gender;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = GenderValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenderEnum {
    Gender[] value();
    String message() default "Gender must be one of {MALE, FEMALE, OTHER}"; // Thông báo lỗi
    Class<?>[] groups() default {};  // Cho phép sử dụng trong các nhóm validation
    Class<? extends Payload>[] payload() default {}; // Thêm thông tin tùy chỉnh nếu cần
}