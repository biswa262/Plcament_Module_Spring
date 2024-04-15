package com.example.placementmodule.UserService;

import com.example.placementmodule.UserData;

public interface UserServiceInter {
    UserData saveUserdata(UserData userData);
    UserData loginuser(UserData user);
    UserData datauser(String email);
}
