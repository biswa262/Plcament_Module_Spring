package com.example.placementmodule.AdminAndHR;

import jakarta.servlet.http.HttpServletResponse;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public interface AdminandHrInterface {
    AppliedStudent savedata(AppliedStudent appliedStudent);
    List<AppliedStudent> appwho(String cp);
    List<String> cpapplied();
    List<String > cansee(String email);

    List<AppliedStudent> searchall(String name);
    List<AppliedStudent> searchallnot();
    List<AppliedStudent> searchname(String name);

    void getTable(HttpServletResponse response);

    void gethrTable(String companyname,HttpServletResponse response);
}
