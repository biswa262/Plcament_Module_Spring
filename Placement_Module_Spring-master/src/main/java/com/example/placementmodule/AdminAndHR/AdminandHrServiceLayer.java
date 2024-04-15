package com.example.placementmodule.AdminAndHR;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class AdminandHrServiceLayer implements AdminandHrInterface{
    private AppliedStudentRepo appliedStudentRepo;

    public AdminandHrServiceLayer(AppliedStudentRepo appliedStudentRepo) {
        this.appliedStudentRepo = appliedStudentRepo;
    }

    public AppliedStudent savedata(AppliedStudent appliedStudent){
        return appliedStudentRepo.save(appliedStudent);
    }
    public List<AppliedStudent> appwho(String cp){
        return appliedStudentRepo.findByCompanyname(cp);
    }

    @Override
    public List<String> cpapplied() {

        return appliedStudentRepo.findDistinctByCompanyname();
    }

    public List<String> cansee(String email){
        return appliedStudentRepo.findDistinctCompanyNamesByEmail(email);
    }

    @Override
    public List<AppliedStudent> searchall(String name) {
        List<AppliedStudent> ap= appliedStudentRepo.findByCompanynameContaining(name);
        if(ap.isEmpty()){
            ap = appliedStudentRepo.findByFirsnameContaining(name);
        }
        return ap;
    }
    public List<AppliedStudent> searchallnot() {
        return appliedStudentRepo.findAll();
    }
    @Override
    public List<AppliedStudent> searchname(String name) {
        return appliedStudentRepo.findByFirsnameContaining(name);
    }



    public void getTable(HttpServletResponse response) {
        try {
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"table.csv\"");

            StatefulBeanToCsv<AppliedStudent> writer = new StatefulBeanToCsvBuilder<AppliedStudent>(response.getWriter()).build();
            List<AppliedStudent> tableData = appliedStudentRepo.findAll();

            writer.write(tableData);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to export table data to CSV", ex);
        }
    }

    @Override
    public void gethrTable(String companyname, HttpServletResponse response) {
        try {
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"table.csv\"");

            StatefulBeanToCsv<AppliedStudent> writer = new StatefulBeanToCsvBuilder<AppliedStudent>(response.getWriter()).build();
            List<AppliedStudent> tableData = appliedStudentRepo.findByCompanyname(companyname);

            writer.write(tableData);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to export table data to CSV", ex);
        }
    }

}
