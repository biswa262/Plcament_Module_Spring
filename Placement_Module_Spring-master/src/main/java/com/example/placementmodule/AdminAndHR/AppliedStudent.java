package com.example.placementmodule.AdminAndHR;

import jakarta.persistence.*;
import lombok.Data;

@Table(name ="studentapplied" )
@Data
@Entity
public class AppliedStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first name",nullable = false)
    private String firsname;  //first alphabet of column should be 'lowercase'

    @Column(name = "last name",nullable = false)
    private String lastname;

    @Column(name = "email",nullable = false)
    private String email;


    @Column(name="phone number",nullable = false)
    private Long phonenumber;

    @Column(name = "companyname",nullable = false)
    private String companyname;

    @Column(name = "skills",nullable = false)
    private String skills;

    @Column(name = "certification",nullable = false)
    private String certification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Override
    public String toString() {
        return "AppliedStudent{" +
                "id=" + id +
                ", firsname='" + firsname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber=" + phonenumber +
                ", companyname='" + companyname + '\'' +
                ", skills='" + skills + '\'' +
                ", certification='" + certification + '\'' +
                '}';
    }
}
