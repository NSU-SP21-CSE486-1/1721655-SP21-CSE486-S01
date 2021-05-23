package com.example.cpcapp.datasource;

public class PDFData {

    private String userEmail;
    private String url;

    public PDFData(String userEmail,String url){
        this.userEmail = userEmail;
        this.url = url;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
