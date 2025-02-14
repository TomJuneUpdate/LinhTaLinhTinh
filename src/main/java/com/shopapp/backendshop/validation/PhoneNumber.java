package com.shopapp.backendshop.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PhoneValidator.class) // Xác định class xử lý validation
@Target({ElementType.FIELD}) // Áp dụng cho biến (Field)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "Invalid phone number"; // Thông báo lỗi mặc định

    Class<?>[] groups() default {}; // Cho phép nhóm các ràng buộc

    Class<? extends Payload>[] payload() default {}; // Chứa metadata bổ sung
}
