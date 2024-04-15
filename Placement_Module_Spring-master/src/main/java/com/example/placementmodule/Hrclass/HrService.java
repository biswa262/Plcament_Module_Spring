package com.example.placementmodule.Hrclass;

import org.springframework.stereotype.Service;

@Service
public class HrService {
    private HrDataRepo hrDataRepo;

    public HrService(HrDataRepo hrDataRepo) {
        this.hrDataRepo = hrDataRepo;
    }
    public HrDetail logindata(HrDetail hrDetail){
        return hrDataRepo.findByEmail(hrDetail.getEmail());
    }

    public HrDetail getcp(String cp){
        return hrDataRepo.findByEmail(cp);
    }

}
