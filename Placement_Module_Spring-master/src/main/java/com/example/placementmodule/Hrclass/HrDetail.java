package com.example.placementmodule.Hrclass;

import jakarta.persistence.*;
import lombok.Data;

@Table(name ="Hrdetails" )
@Data
@Entity
public class HrDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String Password;

    @Column(name = "comapanyname",nullable = false)
    private String companyname;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "HrDetail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
