package com.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNext;                       // button to move to the SecondActivity

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myReceiver = new MyReceiver();
        btnNext = findViewById(R.id.button1);
        btnNext.setOnClickListener(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);  //broadcast for wi-fi state change
        this.registerReceiver(myReceiver, intentFilter);
    }

    /**
     * sending a custom broadcast receiver
     */
    public void sendData() {
        Intent intent = new Intent("com.broadcastreceiver.custom_broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /**
     * moving to second activity on button click
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                sendData();
                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(in);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
