package com.example.zz.servicethatstartsitself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
/** 
 * Create by Zolboo Erdenebaatar 08/31/2018
 * Here's the entry point for the application. 
 * On this activity, we have a single button thats
 * only purpose is to start the service that is not 
 * to be stopped. 
 */
public class MainActivity extends AppCompatActivity {
    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton= (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), TypicalService.class);
                //We start the service here.
                startService(intent);
                Log.d(this.getClass().getSimpleName(), "Service has started from the MainActivity");
            }
        });
    }
}
