package com.example.timedatepickerapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button dateButton,timeButton;
    private TextView dateText,timeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);
        final int hour = c.get(Calendar.HOUR_OF_DAY);
        final int minute = c.get(Calendar.MINUTE);

        dateText = findViewById(R.id.date_textView);
        timeText = findViewById(R.id.time_textView);
        dateButton = findViewById(R.id.button_date);
        timeButton = findViewById(R.id.button_time);


        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String month_string = Integer.toString(month+1);
                        String day_string = Integer.toString(day);
                        String year_string = Integer.toString(year);

                        String date = day_string + "/" + month_string + "/" + year_string;
                        dateText.setText(date);

                    }
                },year,month,day);

                datePicker.show();

            }
        });

        timeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TimePickerDialog timePicker = new TimePickerDialog(MainActivity.this ,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute){
                        String hour_string = Integer.toString(hour);
                        String minute_string = Integer.toString(minute);
                        String time = hour_string + ":" + minute_string;
                        timeText.setText(time);
                    }
                },hour,minute,false);
                timePicker.show();
            }
        });

    }




}