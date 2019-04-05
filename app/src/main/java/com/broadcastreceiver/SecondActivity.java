package com.broadcastreceiver;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    MyReceiver myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.broadcastreceiver.custom_broadcast");      // action for the broadcast

        myReceiver = new MyReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, filter);      //registering to receive the broadcast

    }
}
