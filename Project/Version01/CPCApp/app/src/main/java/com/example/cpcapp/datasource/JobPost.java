package com.example.cpcapp.datasource;

public class JobPost {

    private String company_name;
    private String position_name;
    private String job_type;
    private String salary_range;
    private String job_description;
    private String application_date;
    private String recruiter_email;

    public JobPost(){

    }

    public JobPost(String company_name, String position_name, String job_type, String salary_range, String job_description, String application_date, String recruiter_email) {
        this.company_name = company_name;
        this.position_name = position_name;
        this.job_type = job_type;
        this.salary_range = salary_range;
        this.job_description = job_description;
        this.application_date = application_date;
        this.recruiter_email = recruiter_email;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getSalary_range() {
        return salary_range;
    }

    public void setSalary_range(String salary_range) {
        this.salary_range = salary_range;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getApplication_date() {
        return application_date;
    }

    public void setApplication_date(String application_date) {
        this.application_date = application_date;
    }

    public String getRecruiter_email() {
        return recruiter_email;
    }

    public void setRecruiter_email(String recruiter_email) {
        this.recruiter_email = recruiter_email;
    }
}
