package com.example.studentsignupappv2.datascource;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    static SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;

    public static final String IS_LOGIN = "isLoggedIn";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    public static final String KEY_NAME = "name";
    public static final String KEY_ID = "id";
    public static final String KEY_SCHOOL = "school";
    public static final String KEY_DEPARTMENT = "department";
    public static final String KEY_DOB = "dob";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_NID = "nid";

    public static final String KEY_PRES_COUNTRY = "pres_country";
    public static final String KEY_PRES_DISTRICT = "pres_district";
    public static final String KEY_PRES_POST_OFFICE = "pres_post_office";
    public static final String KEY_PRES_POLICE_STATION = "pres_police_station";
    public static final String KEY_PRES_POSTAL_CODE = "pres_postal_code";
    public static final String KEY_PRES_HVC = "pres_hvc";
    public static final String KEY_PRES_RBS = "pres_rbs";

    public static final String KEY_PERM_COUNTRY = "perm_country";
    public static final String KEY_PERM_DISTRICT = "perm_district";
    public static final String KEY_PERM_POST_OFFICE = "perm_post_office";
    public static final String KEY_PERM_POLICE_STATION = "perm_police_station";
    public static final String KEY_PERM_POSTAL_CODE = "perm_postal_code";
    public static final String KEY_PERM_HVC = "perm_hvc";
    public static final String KEY_PERM_RBS = "perm_rbs";


    public SharedPrefManager(Context context) {
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences("userSession", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void userLogin(String email, String password) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);

        editor.apply();
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    public boolean checkLogin() {
        if (sharedPreferences.getBoolean(IS_LOGIN, false)) {
            return true;
        } else {
            return false;
        }
    }

    public void setDataForm(String name, String id, String dob, String phone, String nid
    ) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_ID, id);
        editor.putString(KEY_DOB, dob);
        editor.putString(KEY_PHONE, phone);
        editor.putString(KEY_NID, nid);

        editor.apply();
    }

    public void setSchoolSpinner(int school){
        editor.putInt(KEY_SCHOOL, school);
        editor.apply();

    }
    public void setDepartmentSpinner(int department){
        editor.putInt(KEY_DEPARTMENT, department);
        editor.apply();
    }

    public void setDataAddress(String presCountry, String presDistrict, String presPostOffice ,String presPoliceStation, String presPostalCode, String presHVC, String presRBS
            , String permCountry, String permDistrict, String permPostOffice, String permPoliceStation, String permPostalCode, String permHVC, String permRBS) {

        editor.putString(KEY_PRES_COUNTRY, presCountry);
        editor.putString(KEY_PRES_DISTRICT, presDistrict);
        editor.putString(KEY_PRES_POST_OFFICE, presPostOffice);
        editor.putString(KEY_PRES_POLICE_STATION, presPoliceStation);
        editor.putString(KEY_PRES_POSTAL_CODE, presPostalCode);
        editor.putString(KEY_PRES_HVC, presHVC);
        editor.putString(KEY_PRES_RBS, presRBS);

        editor.putString(KEY_PERM_COUNTRY, permCountry);
        editor.putString(KEY_PERM_DISTRICT, permDistrict);
        editor.putString(KEY_PERM_POST_OFFICE, permPostOffice);
        editor.putString(KEY_PERM_POLICE_STATION, permPoliceStation);
        editor.putString(KEY_PERM_POSTAL_CODE, permPostalCode);
        editor.putString(KEY_PERM_HVC, permHVC);
        editor.putString(KEY_PERM_RBS, permRBS);

        editor.apply();
    }

    public static String getKeyName() {

        return sharedPreferences.getString(KEY_NAME,"") ;
    }

    public static String getKeyId() {
        return sharedPreferences.getString(KEY_ID,"");
    }

    public static int getKeySchool() {
        return sharedPreferences.getInt(KEY_SCHOOL,0);
    }

    public static int getKeyDepartment() {
        return sharedPreferences.getInt(KEY_DEPARTMENT,0);
    }

    public static String getKeyDob() {
        return sharedPreferences.getString(KEY_DOB,"");
    }

    public static String getKeyPhone() {
        return sharedPreferences.getString(KEY_PHONE,"");
    }

    public static String getKeyNid() {
        return sharedPreferences.getString(KEY_NID,"");
    }

    public static String getKeyPresCountry() {
        return sharedPreferences.getString(KEY_PRES_COUNTRY,"");
    }

    public static String getKeyPresDistrict() {
        return sharedPreferences.getString(KEY_PRES_DISTRICT,"");
    }

    public static String getKeyPresPostOffice() {
        return sharedPreferences.getString(KEY_PRES_POST_OFFICE,"");
    }

    public static String getKeyPresPoliceStation() {
        return sharedPreferences.getString(KEY_PRES_POLICE_STATION,"");
    }

    public static String getKeyPresPostalCode() {
        return sharedPreferences.getString(KEY_PRES_POSTAL_CODE,"");
    }

    public static String getKeyPresHvc() {
        return sharedPreferences.getString(KEY_PRES_HVC,"");
    }

    public static String getKeyPresRbs() {
        return sharedPreferences.getString(KEY_PRES_RBS,"");
    }

    public static String getKeyPermCountry() {
        return sharedPreferences.getString(KEY_PERM_COUNTRY,"");
    }

    public static String getKeyPermDistrict() {
        return sharedPreferences.getString(KEY_PERM_DISTRICT,"");
    }

    public static String getKeyPermPostOffice() {
        return sharedPreferences.getString(KEY_PERM_POST_OFFICE,"");
    }

    public static String getKeyPermPoliceStation() {
        return sharedPreferences.getString(KEY_PERM_POLICE_STATION,"");
    }

    public static String getKeyPermPostalCode() {
        return sharedPreferences.getString(KEY_PERM_POSTAL_CODE,"");
    }

    public static String getKeyPermHvc() {
        return sharedPreferences.getString(KEY_PERM_HVC,"");
    }

    public static String getKeyPermRbs() {
        return sharedPreferences.getString(KEY_PERM_RBS,"");
    }

}
