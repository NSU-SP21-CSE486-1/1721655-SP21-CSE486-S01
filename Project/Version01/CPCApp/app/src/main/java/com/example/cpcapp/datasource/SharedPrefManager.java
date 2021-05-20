package com.example.cpcapp.datasource;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    static SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;

    public static final String IS_LOGIN = "isLoggedIn";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    public SharedPrefManager(Context context) {
        mContext = context;
        sharedPreferences = mContext.getSharedPreferences("userSession", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void userLogin(String email, String password) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);

        editor.apply();
    }
    public String getEmail(){
        String email;
        email = sharedPreferences.getString(KEY_EMAIL,"");
        return email;
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }

    public boolean checkLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


}
