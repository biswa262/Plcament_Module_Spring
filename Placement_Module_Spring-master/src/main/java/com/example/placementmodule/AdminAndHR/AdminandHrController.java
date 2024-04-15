package com.example.placementmodule.AdminAndHR;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Transactional
public class AdminandHrController {
    private AdminandHrServiceLayer adminandHrServiceLayer;

    public AdminandHrController(AdminandHrServiceLayer adminandHrServiceLayer) {
        this.adminandHrServiceLayer = adminandHrServiceLayer;
    }
    @PostMapping("/user/apply")
    public ResponseEntity<AppliedStudent> savedat(@RequestBody AppliedStudent appliedStudent){
        return new ResponseEntity<AppliedStudent>(adminandHrServiceLayer.savedata(appliedStudent), HttpStatus.CREATED);
    }

    @GetMapping("/user/applied/{cp}")
    public List<AppliedStudent> whoapp(@PathVariable("cp") String cp){
        return adminandHrServiceLayer.appwho(cp);
    }

    @GetMapping("/user/companyapplied") //to get unqiue company
    public List<String > allapp(){

        return adminandHrServiceLayer.cpapplied();
    }
    @GetMapping("/user/companyapplied/{email}")
    public List<String> studentcansee(@PathVariable("email") String email){
        return adminandHrServiceLayer.cansee(email);
    }
    @RequestMapping ("/admin/search")
    @GetMapping
    public List<AppliedStudent> search(@RequestParam(required = false) String name){
        if(name==null){
            return adminandHrServiceLayer.searchallnot();
        }
        else{
            return adminandHrServiceLayer.searchall(name);
        }
    }
    @RequestMapping ("/admin/searchbyname")
    @GetMapping
    public List<AppliedStudent> searchname(@RequestParam(required = false) String name){
        if(name==null){
            return adminandHrServiceLayer.searchallnot();
        }
        else{
            return adminandHrServiceLayer.searchname(name);
        }
    }

    @GetMapping(value = "/table/csv")
    public void getadminTableAsCsv(HttpServletResponse response) {
        adminandHrServiceLayer.getTable(response);
    }
    @GetMapping(value = "/hrgettable/csv/{companyname}")
    public void getHrTableAs(@PathVariable("companyname") String companyname,HttpServletResponse response) {
        adminandHrServiceLayer.gethrTable(companyname,response);
    }


}
