/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author nuha
 */
public class Profile {
    private int id;
    private String name;
    private String email;
    private String password;
    private String ic;
    private String gender;
    private String kpi;
    private String contact;
    private String staffid;
    private String grade;    
    private String address;

    public Profile() {
    }

    public Profile(String name, String email, String password, String ic, String gender, String kpi, String contact, String staffid, String grade, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ic = ic;
        this.gender = gender;
        this.kpi = kpi;
        this.contact = contact;
        this.staffid = staffid;
        this.grade = grade;
        this.address = address;
    }

    public Profile(int id, String name, String email, String password, String ic, String gender, String kpi, String contact, String staffid, String grade, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.ic = ic;
        this.gender = gender;
        this.kpi = kpi;
        this.contact = contact;
        this.staffid = staffid;
        this.grade = grade;
        this.address = address;
    }

    public Profile(int id, String name, String email, String ic, String gender, String kpi, String contact, String staffid, String grade, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ic = ic;
        this.gender = gender;
        this.kpi = kpi;
        this.contact = contact;
        this.staffid = staffid;
        this.grade = grade;
        this.address = address;
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getIc() {
        return ic;
    }

    public String getGender() {
        return gender;
    }

    public String getKpi() {
        return kpi;
    }

    public String getContact() {
        return contact;
    }

    public String getStaffid() {
        return staffid;
    }

    public String getGrade() {
        return grade;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}