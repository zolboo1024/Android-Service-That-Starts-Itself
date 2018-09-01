package com.example.zz.servicethatstartsitself;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Zolboo Erdenebaatar
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
