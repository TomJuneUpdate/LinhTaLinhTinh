package com.shopapp.backendshop.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext context) {
        if (phoneNo == null || phoneNo.isBlank()) {
            return false; // Nếu null hoặc rỗng thì không hợp lệ
        }

        // Danh sách regex kiểm tra số điện thoại hợp lệ
        String[] patterns = {
                "^\\d{10}$", // 10 chữ số: 0902345345
                "^\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}$", // 090-234-4567, 090.234.4567, 090 234 4567
                "^\\d{3}-\\d{3}-\\d{4}\\s(x|ext)\\d{3,5}$", // 090-234-4567 ext1234
                "^\\(\\d{3}\\)-\\d{3}-\\d{4}$" // (090)-234-4567
        };

        // Kiểm tra nếu phoneNo khớp với bất kỳ mẫu nào
        for (String pattern : patterns) {
            if (phoneNo.matches(pattern)) {
                return true;
            }
        }

        return false; // Nếu không khớp với mẫu nào thì không hợp lệ
    }
}
