package com.example.zz.servicethatstartsitself;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Zolboo Erdenebaatar
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

    @Override
    public void onDestroy(){
        Intent intent= new Intent(getApplicationContext(), BroadcastToRestartService.class);
        sendBroadcast(intent);
        super.onDestroy();
    }
}
