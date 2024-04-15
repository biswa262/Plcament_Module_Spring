package com.example.placementmodule.UserController;

import com.example.placementmodule.UserData;
import com.example.placementmodule.UserService.UserServicecls;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@RestController
@CrossOrigin
@Transactional
public class UserControllercls {
    private UserServicecls userServicecls;

    @Autowired
    public UserControllercls(UserServicecls userServicecls) {
        this.userServicecls = userServicecls;
    }

    @PostMapping("/user/register")
    public UserData saveUserData(@RequestBody UserData userData) {
        userServicecls.saveUserdata(userData);
        return this.userServicecls.saveUserdata(userData);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserData loginData) {

        UserData user = userServicecls.loginuser(loginData);
        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            // Login successful

            return ResponseEntity.ok().build();
        } else {
            // Login failed
            return ResponseEntity.status(401).build();
        }

    }
    @GetMapping("/getSession")
    public String getSession(HttpSession session) {
//        session = request.getAttribute();
        return (String) session.getAttribute("user");
    }

    @GetMapping("/user/getdata/{email}")
    public ResponseEntity<UserData> userodata(@PathVariable String email){
        UserData user = userServicecls.datauser(email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
