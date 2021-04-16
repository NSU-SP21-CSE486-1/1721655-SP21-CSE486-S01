package com.example.android.hellosharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.hellosharedprefs";
    // Key for current count
    private final String COUNT_KEY = "count";
    // Key for current color
    private final String COLOR_KEY = "color";
    private int mCount = 0;
    private int mColor;
    private String sColor;
    private ToggleButton toggleButton ;
    private Spinner colorSpinner;
    private ArrayAdapter<String> arrayAdapterColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        toggleButton = findViewById(R.id.settings_toggleButton);
        colorSpinner = findViewById(R.id.settings_spinner);
        colorSpinner.setOnItemSelectedListener(this);
        final String[] colors = getResources().getStringArray(R.array.color_name);
        arrayAdapterColor = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,colors);
        arrayAdapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Intent intent = getIntent();
        String sCount = intent.getStringExtra(MainActivity.COUNT_S);
        sColor = intent.getStringExtra(MainActivity.COLOR_S);
        mCount =  Integer.parseInt(sCount);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(toggleButton.isChecked()){
                    colorSpinner.setAdapter(arrayAdapterColor);
                }else{
                    mColor =  Integer.parseInt(sColor);
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            mColor = Color.parseColor("#CC0000");
        }else
            if(position == 1){
                mColor = Color.parseColor("#0099CC");
            }else
                if(position == 2){
                    mColor = Color.parseColor("#669900");
                }else
                    if(position == 3)
                        mColor = Color.parseColor("#E0E0E0");
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    public void reset(View view) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }

    public void save(View view) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
        Toast.makeText(this, "Preferences Saved",Toast.LENGTH_SHORT).show();
    }
}