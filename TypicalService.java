package com.example.zz.servicethatstartsitself;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Zolboo Erdenebaatar 08/31/2018
 * Here's a simple service that we have for a sake of example. 
 * This service is designed to start a count and keep counting 
 * as long as the service is not killed. 
 * The important part is onDestroy() method. 
 */
public class TypicalService extends Service {
    int i;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID){
        i= 0;
        CountDownTimer countDownTimer= new CountDownTimer(20000, 1000) {
            //As long as the service is running, the count should be going up
            @Override
            public void onTick(long l) {
                ++i;
                Log.d(this.getClass().getSimpleName(), ""+i);
            }

            @Override
            public void onFinish() {}
        }.start();
        return START_STICKY;
    }
    /**
     * onDestroy() method is called JUST before the service is about to shut down (not just service but 
     * any other UI or background activity that Android provides). Just before it shuts down, it sends 
     * a broadcast to the BroadcastToRestartService.java so that they can start this service again.
     * It is important to have super.onDestroy() AFTER you send the broadcast
     */
    @Override
    public void onDestroy(){
        Intent intent= new Intent(getApplicationContext(), BroadcastToRestartService.class);
        sendBroadcast(intent);
        super.onDestroy();
    }
}
