package com.example.placementmodule.Hrclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HrDataRepo extends JpaRepository<HrDetail,Long> {
    HrDetail findByEmail(String email);
}
