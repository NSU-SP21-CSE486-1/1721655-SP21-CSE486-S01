package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingItems extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.shoppinglistapp.extra.REPLY";
    private Button item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11;
    private Intent itemIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_items);
        item1 = findViewById(R.id.item_1);
        item2 = findViewById(R.id.item_2);
        item3 = findViewById(R.id.item_3);
        item4 = findViewById(R.id.item_4);
        item5 = findViewById(R.id.item_5);
        item6 = findViewById(R.id.item_6);
        item7 = findViewById(R.id.item_7);
        item8 = findViewById(R.id.item_8);
        item9 = findViewById(R.id.item_9);
        item10 = findViewById(R.id.item_10);
        item11 = findViewById(R.id.item_11);

    }


    public void addItem1(View view) {
        item1 = (Button)view;
        String item = item1.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();


    }
    public void addItem2(View view) {
        item2 = (Button)view;
        String item = item2.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem3(View view) {
        item3 = (Button)view;
        String item = item3.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem4(View view) {
        item4 = (Button)view;
        String item = item4.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem5(View view) {
        item5 = (Button)view;
        String item = item5.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem6(View view) {
        item6 = (Button)view;
        String item = item6.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem7(View view) {
        item7 = (Button)view;
        String item = item7.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem8(View view) {
        item8 = (Button)view;
        String item = item8.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem9(View view) {
        item9 = (Button)view;
        String item = item9.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem10(View view) {
        item10 = (Button)view;
        String item = item10.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();

    }
    public void addItem11(View view) {
        item11 = (Button)view;
        String item = item11.getText().toString();
        itemIntent.putExtra(EXTRA_REPLY,item);
        setResult(RESULT_OK,itemIntent);
        finish();
    }
}