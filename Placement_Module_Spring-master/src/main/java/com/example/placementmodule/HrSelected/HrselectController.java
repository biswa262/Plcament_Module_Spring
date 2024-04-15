package com.example.placementmodule.HrSelected;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Transactional
public class HrselectController {
    private SelectService selectService;

    public HrselectController(SelectService selectService) {
        this.selectService = selectService;
    }
@PostMapping("/selected/save")
    public void savedata(@RequestBody List<Selectedstudents>selectedstudents){
        selectService.tosaveslected(selectedstudents);
    }
    @GetMapping("/selected/getall")
    public List<Selectedstudents> getall(){
        return selectService.getallselected();
    }
    @GetMapping(value = "/table/allselected/csv")
    public void getadminTableAsCsv(HttpServletResponse response){
        selectService.getTable(response);
    }

    @GetMapping("/table/selected/count")
    public int getselcted(){
        return selectService.getselectedcount();
    }
    @GetMapping("/table/allstudent/count")
    public int getnotselcted(){
        return selectService.getallcount();
    }

    //no NEED
@GetMapping("/table/notselected/feedback")
    public List<Selectedstudents> getnotselect(){
        return selectService.getnotselectedstudent();
}
@PutMapping("/overall/feedback/data/{feedback}")
    public ResponseEntity<Selectedstudents> savefeedback(@PathVariable("feedback") String feedback) {
    List<Selectedstudents> ss = selectService.overall(feedback);
    if (ss != null) {
        return new ResponseEntity<>(HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    @GetMapping("/student/get/{email}")
        public List<Selectedstudents> getstatus(@PathVariable("email")String email){
        return selectService.studentstatus(email);
    }
    @PutMapping("/indiviual/feedback/{email}/{companyname}")
public ResponseEntity<Selectedstudents> indivial(@PathVariable String email,String companyname){
        Selectedstudents s = selectService.indiviualfeedback(email,companyname);
        if(s!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}

}
