package com.example.placementmodule.AdminAndHR;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppliedStudentRepo extends JpaRepository<AppliedStudent,Long> {

    List<AppliedStudent> findByCompanyname(String cp);
    @Query(value = "SELECT DISTINCT companyname FROM studentapplied", nativeQuery = true)
    List<String > findDistinctByCompanyname();

    @Query(value = "SELECT DISTINCT companyname FROM studentapplied  WHERE email = :email", nativeQuery = true)
    List<String> findDistinctCompanyNamesByEmail(@Param("email") String email);

List<AppliedStudent> findByCompanynameContaining(String name);
List<AppliedStudent> findByFirsnameContaining(String name);


}
