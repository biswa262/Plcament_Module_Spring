package com.example.placementmodule;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Table(name = "AdminData")
@Entity
public class AdminData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Comapanyname",nullable = false)
    private String companyname;

//    @Column(name = "Date",nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Europe/Zagreb",shape = JsonFormat.Shape.STRING)
//    private Date date;
    @Column(name = "Date",nullable = false)
    private String date;
    @Column(name = "Time",nullable = false)
    private String time;

//    @Column(name = "Time",nullable = false)
//    @Temporal(TemporalType.TIME)
//    private Date time;

    @Column(name = "Requirement",nullable = false)
    private String requirement;
    @Column(name = "Place",nullable = false)
    private String place;

    @Override
    public String toString() {
        return "AdminData{" +
                "id=" + id +
                ", comapanyName='" + companyname + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", requirement='" + requirement + '\'' +
                ", place='" + place + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
