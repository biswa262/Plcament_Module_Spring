package com.example.placementmodule.AdminLogin;

import jakarta.persistence.*;
import lombok.Data;

@Table(name ="admindetails" )
@Data
@Entity
public class AdminDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String Password;

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
        return "AdminDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
