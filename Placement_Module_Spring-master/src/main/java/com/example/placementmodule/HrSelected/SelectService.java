package com.example.placementmodule.HrSelected;

import com.example.placementmodule.AdminAndHR.AppliedStudent;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;

@Service
public class SelectService {

    private SelectedStudentRepository selectedStudentRepository;

    public SelectService(SelectedStudentRepository selectedStudentRepository) {
        this.selectedStudentRepository = selectedStudentRepository;
    }

public void tosaveslected(List<Selectedstudents> selectedstudents){

        for(int i=0;i<selectedstudents.size();i++){
            Selectedstudents ch = selectedstudents.get(i);
            if(ch!=null){

                Selectedstudents fin = selectedStudentRepository.findByEmailAndAndCompanyname(ch.getEmail(), ch.getCompanyname());

                if(fin!=null){
                    fin.setStatus(ch.getStatus());
                    selectedStudentRepository.save(fin);
                }
                else{
                    selectedStudentRepository.save(ch);
                }
            }

        }
}

public List<Selectedstudents> getallselected(){
        return selectedStudentRepository.findAll();
}

    public void getTable(HttpServletResponse response) {
        try {
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"table.csv\"");

            StatefulBeanToCsv<Selectedstudents> writer = new StatefulBeanToCsvBuilder<Selectedstudents>(response.getWriter()).build();
            List<Selectedstudents> tableData = selectedStudentRepository.findAll();

            writer.write(tableData);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to export table data to CSV", ex);
        }
    }


    public int getselectedcount(){
        String s = "selected";
        List<Selectedstudents> lp = selectedStudentRepository.findByStatus(s);
        int c = lp.size();
        return c;
    }

    public int getallcount(){

        List<Selectedstudents> lp = selectedStudentRepository.findAll();
        int c = lp.size();
        return c;
    }

    public List<Selectedstudents> getnotselectedstudent(){
        String s = "not selected";
        return selectedStudentRepository.findByStatus(s);
    }

    public List<Selectedstudents> overall(String feedback){
        String s = "not selected";
        List<Selectedstudents> lp = selectedStudentRepository.findByStatus(s);

        String c = "selected";
        List<Selectedstudents> listselected = selectedStudentRepository.findByStatus(c);
        if(lp!=null){

            //not selected
            for (int i = 0; i < lp.size(); i++) {
               Selectedstudents sp =  lp.get(i);

                if(sp!=null){
                    sp.setFeedback(feedback);
                    selectedStudentRepository.save(sp);
                }
            }
        }
        //to congrates
        if(listselected!=null){
            for (int i = 0; i < listselected.size(); i++) {
                Selectedstudents sp1 =  listselected.get(i);

                if(sp1!=null){
                    sp1.setFeedback("Congratulations");
                    selectedStudentRepository.save(sp1);
                }
            }
        }
        return lp;
    }

    public List<Selectedstudents> studentstatus(String email){
        return selectedStudentRepository.findByEmail(email);
    }

    public Selectedstudents indiviualfeedback(String email, String companyname){
        return selectedStudentRepository.findByEmailAndAndCompanyname(email,companyname);
    }
}
