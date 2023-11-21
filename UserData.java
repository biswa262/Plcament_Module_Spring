package com.example.placementmodule;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;
@Table(name ="User Details" )
@Data
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first name",nullable = false)
    private String firsname;  //first alphabet of column should be 'lowercase'

    @Column(name = "last name",nullable = false)
    private String lastname;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String Password;
    @Column(name = "confirm password",nullable = false)
    private String conpassword;

    @Column(nullable = false)
    private String dreamcompany;

    @Column(name="phone number",nullable = false)
    private Long phonenumber;

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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }

    public String getDreamcompany() {
        return dreamcompany;
    }

    public void setDreamcompany(String dreamcompany) {
        this.dreamcompany = dreamcompany;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
}
