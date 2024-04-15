package com.example.placementmodule;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminData,Long> {
    void deleteByCompanyname(String companyname);

    Optional<AdminData> findBycompanyname(String companyname);

    List<AdminData> findByCompanyname(String companyname);

//    AdminData findbycompanyname(String companyname);
}
