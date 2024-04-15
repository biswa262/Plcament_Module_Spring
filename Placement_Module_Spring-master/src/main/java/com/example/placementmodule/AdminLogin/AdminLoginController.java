package com.example.placementmodule.AdminLogin;

import com.example.placementmodule.AdminService.AdminServicecls;
import com.example.placementmodule.UserData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Transactional
public class AdminLoginController {

    private AdminLoginService adminLoginService;
    @Autowired
    public AdminLoginController(AdminLoginService adminLoginService) {
        this.adminLoginService = adminLoginService;
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> login(@RequestBody UserData loginData) {

       AdminDetails admin = adminLoginService.loginuser(loginData);

        if (admin != null && admin.getPassword().equals(loginData.getPassword())) {
            // Login successful
            return ResponseEntity.ok().build();
        } else {
            // Login failed
            return ResponseEntity.status(401).build();
        }

    }
}
