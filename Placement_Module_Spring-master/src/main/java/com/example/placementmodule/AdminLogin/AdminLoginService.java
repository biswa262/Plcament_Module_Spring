package com.example.placementmodule.AdminLogin;

import com.example.placementmodule.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
    private AdminDetailRepo adminDetailRepo;
@Autowired
    public AdminLoginService(AdminDetailRepo adminDetailRepo) {
        this.adminDetailRepo = adminDetailRepo;
    }



    public AdminDetails loginuser(UserData user) {
        return adminDetailRepo.findByEmail(user.getEmail());

    }
}
