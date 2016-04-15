package com.yrazlik.gcmpush.client;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by yrazlik on 15/04/16.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService{
    private static final String TAG = "GCM_SERVICE";

    @Override
    public void onTokenRefresh() {
        Log.d(TAG, "onTokenRefresh");
        Intent intent = new Intent(this, MyGCMRegistrationListenerService.class);
        startService(intent);
    }
}
