package com.example.placementmodule.HrSelected;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectedStudentRepository extends JpaRepository<Selectedstudents,Long> {

List<Selectedstudents> findByStatus(String selected);

Selectedstudents findBystatus(String selected);

List<Selectedstudents> findByEmail(String email);

Selectedstudents findByEmailAndAndCompanyname(String email,String companyname);
}
