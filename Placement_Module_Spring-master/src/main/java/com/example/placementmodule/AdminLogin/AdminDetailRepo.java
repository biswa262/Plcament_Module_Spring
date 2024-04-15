package com.example.placementmodule.AdminLogin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDetailRepo extends JpaRepository<AdminDetails,Long> {
AdminDetails findByEmail(String email);
}
