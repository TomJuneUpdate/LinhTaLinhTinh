package com.shopapp.backendshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${jwt.secretKey}") // Giúp tìm kiếm giá trị trong tệp cấu hình application.yml
    String key;

    @GetMapping("helloworld")
    public String sayHello() {
        return "Hello World" + key;
    }

}
