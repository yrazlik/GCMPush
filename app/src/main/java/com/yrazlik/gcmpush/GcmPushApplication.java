package com.yrazlik.gcmpush;

import android.app.Application;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.yrazlik.gcmpush.client.MyGCMRegistrationListenerService;

import java.io.IOException;

/**
 * Created by yrazlik on 15/04/16.
 */
public class GcmPushApplication extends Application{

    @Override
    public void onTerminate() {
        try {
            InstanceID.getInstance(this).deleteToken(MyGCMRegistrationListenerService.GCM_SENDER_ID, GoogleCloudMessaging.INSTANCE_ID_SCOPE);
        }catch (IOException e){}
        super.onTerminate();
    }
}
