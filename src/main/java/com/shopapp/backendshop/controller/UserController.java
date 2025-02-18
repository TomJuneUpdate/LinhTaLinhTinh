package com.shopapp.backendshop.controller;

import com.shopapp.backendshop.dto.request.UserRequestDTO;
import com.shopapp.backendshop.dto.response.ResponseSuccess;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
//  @ResponseStatus(HttpStatus.CREATED)
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDTO user) {
        System.out.println("Adding user: " + user.getFirstName());
        return new ResponseSuccess(HttpStatus.CREATED, "User added successfully");
    }

    @PutMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateUser(@PathVariable("userId") int id, @RequestBody UserRequestDTO user) {
        System.out.println("User update " + id);
        return "User update" + id;
    }

    @PatchMapping("/{userId}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public String changeStatusUser(@PathVariable("userId") int id, @RequestParam(required = false) boolean status) {
        System.out.println("User change status  " + id);
        return "Update status " + id;
    }

    @DeleteMapping("/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable("userId") int id) {
        System.out.println("delete user " + id);
        return "Delete user" + id;
    }

    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
    public String getUserById(@PathVariable("userId") @Min(1) int id) {
        System.out.println("delete user " + id);
        return "Get user by " + id;
    }

    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
    public String getAllUser(@RequestParam(required = false) String email,
                             @RequestParam(defaultValue = "0") @Min(0) int page,
                             @RequestParam(defaultValue = "10") @Max(10) int size) {
        System.out.println("get user " + page + " " + size);
        return "Get all users";
    }
}
