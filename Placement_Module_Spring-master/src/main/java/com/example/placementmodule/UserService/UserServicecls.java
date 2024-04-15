package com.example.placementmodule.UserService;

import com.example.placementmodule.AdminData;
import com.example.placementmodule.ExceptionFound;
import com.example.placementmodule.UserData;
import com.example.placementmodule.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicecls implements UserServiceInter{
    private UserRepository userRepository;

    @Autowired
    public UserServicecls(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserData saveUserdata(UserData userData) {
        return userRepository.save(userData);
    }


    public UserData loginuser(UserData user) {
       return userRepository.findByEmail(user.getEmail());

    }public UserData datauser(String email) {
        return userRepository.findByEmail(email);
    }


}
