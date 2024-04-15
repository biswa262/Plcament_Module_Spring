package com.example.placementmodule.AdminService;

import com.example.placementmodule.AdminData;

import java.util.List;
import java.util.Optional;

public interface AdminServiceInter {
    AdminData saveAdminData(AdminData adminData);
    List<AdminData> getAdminDataList();
    AdminData updateAdminData(String name,AdminData adminData);

    void deletecompany(String name);
    AdminData getdataid(Long id);

   List<AdminData> getdatacp(String companyname);

   Optional<AdminData> toupdate(String companyname);
}
