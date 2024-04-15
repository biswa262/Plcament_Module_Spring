package com.example.placementmodule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData,Long> {
    UserData findByEmail(String email);

}
