package com.yrazlik.gcmpush.client;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

/**
 * Created by yrazlik on 15/04/16.
 */
public class MyGCMRegistrationListenerService extends IntentService{

    private static final String TAG = "GCM_SERVICE";
    private static final String GCM_SENDER_ID = "326448635390";

    public MyGCMRegistrationListenerService() {
        super("");
    }

    public MyGCMRegistrationListenerService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        try {
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(GCM_SENDER_ID, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            if(token != null && !TextUtils.isEmpty(token)){
                //saveGCMRegisterID(this);//Maybe you want to save token to shared preferences
                Log.d(TAG, "Token: " + token);
            }
        } catch (Exception e) {
        }
    }
}
