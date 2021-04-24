package com.example.headsetreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "Unknown Broadcast";

            if(intent.getIntExtra("state",0)==1)
                toastMessage = "Headset Connected";
            else if(intent.getIntExtra("state",0)==0)
                toastMessage = "Headset Disconnected";


            Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();


        }


    }

}


