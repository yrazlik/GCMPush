package com.yrazlik.gcmpush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.yrazlik.gcmpush.client.MyGCMRegistrationListenerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkPlayServices()) {
            registerGCM();
        }
    }

    private void registerGCM(){
        Intent intent = new Intent(this, MyGCMRegistrationListenerService.class);
        startService(intent);
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, 9000).show();//9000 is the play services resolution request
            } else {
                Log.i("PLAY_SERVICES", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }
}
