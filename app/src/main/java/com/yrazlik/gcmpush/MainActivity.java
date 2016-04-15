package com.yrazlik.gcmpush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yrazlik.gcmpush.client.MyGCMRegistrationListenerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerGCM();
    }

    private void registerGCM(){
        Intent intent = new Intent(this, MyGCMRegistrationListenerService.class);
        startService(intent);
    }
}
