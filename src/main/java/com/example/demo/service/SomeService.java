package com.example.demo.service;

import com.example.demo.annotation.RoleAllowed;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    // ADMIN 권한만 접근 가능하도록 지정
    @RoleAllowed({"ADMIN"})
    public void adminTask() {
        System.out.println("Admin task executed");
    }

    // USER 또는 ADMIN 권한이면 접근 가능
    @RoleAllowed({"USER", "ADMIN"})
    public void userTask() {
        System.out.println("User task executed");
    }
}