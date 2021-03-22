package com.example.studentsignupapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "student")
public class StudentEntity {

    @PrimaryKey @NonNull
    private String student_id;

    @ColumnInfo(name = "student_name")
    private String student_name;

    @ColumnInfo(name = "school")
    private String school;

    @ColumnInfo(name = "department")
    private String department;

    @ColumnInfo(name = "dob")
    private String dob;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "nid")
    private String nid;

    @ColumnInfo(name = "pres_country")
    private String presCountry;

    @ColumnInfo(name = "pres_district")
    private String pres_district;

    @ColumnInfo(name = "pres_post_office")
    private String pres_post_office;

    @ColumnInfo(name = "pres_police_station")
    private String  pres_police_station;

    @ColumnInfo(name = "pres_postal_code")
    private String pres_postal_code;

    @ColumnInfo(name = "pres_hvc")
    private String pres_hvc;

    @ColumnInfo(name = "pres_rbs")
    private String pres_rbs;

    @ColumnInfo(name = "perm_country")
    private String permCountry;

    @ColumnInfo(name = "perm_district")
    private String perm_district;

    @ColumnInfo(name = "perm_post_office")
    private String perm_post_office;

    @ColumnInfo(name = "perm_police_station")
    private String  perm_police_station;

    @ColumnInfo(name = "perm_postal_code")
    private String perm_postal_code;

    @ColumnInfo(name = "perm_hvc")
    private String perm_hvc;

    @ColumnInfo(name = "perm_rbs")
    private String perm_rbs;


    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPresCountry() {
        return presCountry;
    }

    public void setPresCountry(String presCountry) {
        this.presCountry = presCountry;
    }

    public String getPres_district() {
        return pres_district;
    }

    public void setPres_district(String pres_district) {
        this.pres_district = pres_district;
    }

    public String getPres_post_office() {
        return pres_post_office;
    }

    public void setPres_post_office(String pres_post_office) {
        this.pres_post_office = pres_post_office;
    }

    public String getPres_police_station() {
        return pres_police_station;
    }

    public void setPres_police_station(String pres_police_station) {
        this.pres_police_station = pres_police_station;
    }

    public String getPres_postal_code() {
        return pres_postal_code;
    }

    public void setPres_postal_code(String pres_postal_code) {
        this.pres_postal_code = pres_postal_code;
    }

    public String getPres_hvc() {
        return pres_hvc;
    }

    public void setPres_hvc(String pres_hvc) {
        this.pres_hvc = pres_hvc;
    }

    public String getPres_rbs() {
        return pres_rbs;
    }

    public void setPres_rbs(String pres_rbs) {
        this.pres_rbs = pres_rbs;
    }

    public String getPermCountry() {
        return permCountry;
    }

    public void setPermCountry(String permCountry) {
        this.permCountry = permCountry;
    }

    public String getPerm_district() {
        return perm_district;
    }

    public void setPerm_district(String perm_district) {
        this.perm_district = perm_district;
    }

    public String getPerm_post_office() {
        return perm_post_office;
    }

    public void setPerm_post_office(String perm_post_office) {
        this.perm_post_office = perm_post_office;
    }

    public String getPerm_police_station() {
        return perm_police_station;
    }

    public void setPerm_police_station(String perm_police_station) {
        this.perm_police_station = perm_police_station;
    }

    public String getPerm_postal_code() {
        return perm_postal_code;
    }

    public void setPerm_postal_code(String perm_postal_code) {
        this.perm_postal_code = perm_postal_code;
    }

    public String getPerm_hvc() {
        return perm_hvc;
    }

    public void setPerm_hvc(String perm_hvc) {
        this.perm_hvc = perm_hvc;
    }

    public String getPerm_rbs() {
        return perm_rbs;
    }

    public void setPerm_rbs(String perm_rbs) {
        this.perm_rbs = perm_rbs;
    }
}
