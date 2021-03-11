package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView itemList1,itemList2,itemList3,itemList4,itemList5,itemList6,itemList7,itemList8,itemList9,itemList10;
    public static final int TEXT_REQUEST = 1;
    private EditText mLocationEditText;
    //public static final String EXTRA_STORE = "com.example.android.shoppinglistapp.extra.STORE";
    private final Intent storeIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList1 = findViewById(R.id.list_item_1);
        itemList2 = findViewById(R.id.list_item_2);
        itemList3 = findViewById(R.id.list_item_3);
        itemList4 = findViewById(R.id.list_item_4);
        itemList5 = findViewById(R.id.list_item_5);
        itemList6 = findViewById(R.id.list_item_6);
        itemList7 = findViewById(R.id.list_item_7);
        itemList8 = findViewById(R.id.list_item_8);
        itemList9 = findViewById(R.id.list_item_9);
        itemList10 = findViewById(R.id.list_item_10);

        mLocationEditText = findViewById(R.id.locate_edit_text);

        if (savedInstanceState != null) {
            itemList1.setText(savedInstanceState.getString("reply_text_1"));
            itemList1.setVisibility(View.VISIBLE);
            itemList2.setText(savedInstanceState.getString("reply_text_2"));
            itemList2.setVisibility(View.VISIBLE);
            itemList3.setText(savedInstanceState.getString("reply_text_3"));
            itemList3.setVisibility(View.VISIBLE);
            itemList4.setText(savedInstanceState.getString("reply_text_4"));
            itemList4.setVisibility(View.VISIBLE);
            itemList5.setText(savedInstanceState.getString("reply_text_5"));
            itemList5.setVisibility(View.VISIBLE);
            itemList6.setText(savedInstanceState.getString("reply_text_6"));
            itemList6.setVisibility(View.VISIBLE);
            itemList7.setText(savedInstanceState.getString("reply_text_7"));
            itemList7.setVisibility(View.VISIBLE);
            itemList8.setText(savedInstanceState.getString("reply_text_8"));
            itemList8.setVisibility(View.VISIBLE);
            itemList9.setText(savedInstanceState.getString("reply_text_9"));
            itemList9.setVisibility(View.VISIBLE);
            itemList10.setText(savedInstanceState.getString("reply_text_10"));
            itemList10.setVisibility(View.VISIBLE);
            }
        }


    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intentLocation = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intentLocation.resolveActivity(getPackageManager()) != null) {
            startActivity(intentLocation);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }


    public void shoppingList(View view) {
        Intent intent = new Intent(this, ShoppingItems.class);
        startActivityForResult(intent, TEXT_REQUEST);


    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                if(itemList1.getText().toString().equals("") && itemList1.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList1.setText(reply);
                    itemList1.setVisibility(View.VISIBLE);
                }
                else if(itemList2.getText().toString().equals("") && itemList2.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList2.setText(reply);
                    itemList2.setVisibility(View.VISIBLE);
                }
                else if(itemList3.getText().toString().equals("") && itemList3.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList3.setText(reply);
                    itemList3.setVisibility(View.VISIBLE);
                }
                else if(itemList4.getText().toString().equals("") && itemList4.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList4.setText(reply);
                    itemList4.setVisibility(View.VISIBLE);
                }
                else if(itemList5.getText().toString().equals("") && itemList5.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList5.setText(reply);
                    itemList5.setVisibility(View.VISIBLE);
                }
                else if(itemList6.getText().toString().equals("") && itemList6.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList6.setText(reply);
                    itemList6.setVisibility(View.VISIBLE);
                }
                else if(itemList7.getText().toString().equals("") && itemList7.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList7.setText(reply);
                    itemList7.setVisibility(View.VISIBLE);
                }
                else if(itemList8.getText().toString().equals("") && itemList8.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList8.setText(reply);
                    itemList8.setVisibility(View.VISIBLE);
                }
                else if(itemList9.getText().toString().equals("") && itemList9.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList9.setText(reply);
                    itemList9.setVisibility(View.VISIBLE);
                }
                else if(itemList10.getText().toString().equals("") && itemList10.getText().length() == 0) {
                    String reply = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                    itemList10.setText(reply);
                    itemList10.setVisibility(View.VISIBLE);
                }
            }
        }
    }




    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
            outState.putString("reply_text_1", itemList1.getText().toString());
            outState.putString("reply_text_2", itemList2.getText().toString());
            outState.putString("reply_text_3", itemList3.getText().toString());
            outState.putString("reply_text_4", itemList4.getText().toString());
            outState.putString("reply_text_5", itemList5.getText().toString());
            outState.putString("reply_text_6", itemList6.getText().toString());
            outState.putString("reply_text_7", itemList7.getText().toString());
            outState.putString("reply_text_8", itemList8.getText().toString());
            outState.putString("reply_text_9", itemList9.getText().toString());
            outState.putString("reply_text_10", itemList10.getText().toString());
        }
        
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }



}