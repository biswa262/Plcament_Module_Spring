package com.example.placementmodule.Hrclass;

import com.example.placementmodule.AdminLogin.AdminDetails;
import com.example.placementmodule.UserData;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Transactional
public class HrloginController {
    private HrService hrService;

    public HrloginController(HrService hrService) {
        this.hrService = hrService;
    }

    @PostMapping("/hr/login")
    public ResponseEntity<?> login(@RequestBody HrDetail loginData) {

        HrDetail hr  = hrService.logindata(loginData);
        if (hr != null && hr.getPassword().equals(loginData.getPassword())) {
            // Login successful
            return ResponseEntity.ok().build();
        } else {
            // Login failed
            return ResponseEntity.status(401).build();
        }

    }

    @GetMapping("/hr/detail/{email}")
    public ResponseEntity<HrDetail> getcoma(@PathVariable("email")String email){
        return new ResponseEntity<>(hrService.getcp(email),HttpStatus.OK);
    }
}
