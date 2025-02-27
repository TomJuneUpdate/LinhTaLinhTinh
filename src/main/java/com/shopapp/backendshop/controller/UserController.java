package com.shopapp.backendshop.controller;

import com.shopapp.backendshop.config.Translator;
import com.shopapp.backendshop.dto.request.UserRequestDTO;
import com.shopapp.backendshop.dto.response.ResponseData;
import com.shopapp.backendshop.dto.response.ResponseSuccess;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
@Validated // Bắt buộc để validation method parameters hoạt động
public class UserController {

    @PostMapping()
//  @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO user) {
            System.out.println("Adding user: " + user.getFirstName());
            return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("add.user"), 1);
    }

    @PutMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseData<?> updateUser(@PathVariable @Min(value = 1, message = "UserId must be than 1") int userId, @Valid @RequestBody UserRequestDTO user) {
        System.out.println("Request update userId=" + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @PatchMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess changeStatusUser(@PathVariable("userId") @Min(1)  int id, @RequestParam(required = false) boolean status) {
        System.out.println("User change status  " + id);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User change status successfully");
    }

    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseSuccess deleteUser(@PathVariable("userId") int id) {
        System.out.println("delete user " + id);
        return new ResponseSuccess(HttpStatus.NO_CONTENT, "User delete successfully");
    }

    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getUserById(@PathVariable("userId") int id) {
        System.out.println("user " + id);
        return new ResponseSuccess(HttpStatus.OK, "User found successfully", id);
    }

    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
    public ResponseData<List<UserRequestDTO>> getAllUser(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Max(10) int size) {

        System.out.println("get user " + page + " " + size);
        return new ResponseData<>(HttpStatus.OK.value(), "Get all user successfully", new ArrayList<>());
    }
}
