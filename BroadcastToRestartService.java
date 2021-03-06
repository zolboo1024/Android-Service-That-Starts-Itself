package com.example.zz.servicethatstartsitself;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Zolboo Erdenebaatar
 * Here's a simple BroadcastReceiver that 
 * receives a signal when a service is killed or stopped without 
 * your application knowing it. Then, it calls the same 
 * service that just got killed to create a process that is not 
 * to be stopped by Android Memory Manager. 
 */
public class BroadcastToRestartService extends BroadcastReceiver {
    Intent newIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent newIntent= new Intent(context, TypicalService.class);
        context.startService(newIntent);
        Log.d(this.getClass().getSimpleName(), "Service has started again!");
    }
}
