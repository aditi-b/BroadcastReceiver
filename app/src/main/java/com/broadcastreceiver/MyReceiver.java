package com.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if ((intent.getAction()) != null) {

            switch (intent.getAction()) {

                case "android.intent.action.AIRPLANE_MODE":        // for airplane mode broadcast

                    boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                    if (isAirplaneModeOn) {

                        Toast.makeText(context, "Airplane mode On", Toast.LENGTH_SHORT).show();
                        break;

                    } else {
                        Toast.makeText(context, "Airplane mode off", Toast.LENGTH_SHORT).show();
                        break;

                    }

                case "com.broadcastreceiver.custom_broadcast":   // for custom broadcast

                    Toast.makeText(context, "Second activity started", Toast.LENGTH_SHORT).show();
                    break;

                case WifiManager.WIFI_STATE_CHANGED_ACTION:      // for wi-fi broadcast

                    int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_ENABLED);

                    if (wifiStateExtra == WifiManager.WIFI_STATE_ENABLED) {
                        Toast.makeText(context, "Wi-fi on", Toast.LENGTH_SHORT).show();
                    } else if (wifiStateExtra == WifiManager.WIFI_STATE_DISABLED) {
                        Toast.makeText(context, "Wi-fi off", Toast.LENGTH_SHORT).show();
                    }

                    break;


            }
        }


    }
}


