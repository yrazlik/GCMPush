# GCMPush
Steps for push notification integration


- A full GCM implementation requires both a client implementation and a server implementation.

- At a minimum, a GCM client app must include code to register (and thereby get a registration token), and a receiver to receive messages sent by GCM.

- To verify that client app can send and receive messages, client apps must register with GCM. In this process, the client obtains a unique registration token and passes it to the app server, which stores the token and sends an acknowledgement back to the client app. The registration token exchanged in this process is the same client app instance identifier that the app server uses to send messages to the particular client.

- To register with GCM: 
  - The client app obtains a registration token using the Instance ID API. The call to this API must have the authorized entity set to your app server's sender ID, and the scope set to the appropriate value for GCM (depending on your platform). 
  - The client app passes the registration token to the app server.
  - The app server saves the registration token and acknowledges to the client app that the process completed successfully.
  
- If the app server fails to complete its part of the registration handshake, the client app should retry sending registration token to the server or delete the registration token.

- Add the following to your build.gradle file to use google play services:
  
          `compile "com.google.android.gms:play-services-gcm:8.4.0"`

- Add the following to your application's manifest:

  - Your `<application-package-name> + ".permission.C2D_MESSAGE"` permission to prevent other Android applications from registering and receiving the Android application's messages. The permission name must exactly match this pattern—otherwise the Android application will not receive the messages.

  - A declaration of `GcmReceiver`, which handles messages sent from GCM to your application. Because this service needs permission to receive messages from GCM, add `com.google.android.c2dm.permission.SEND` to the receiver.
  
  - A declaration of `GcmListenerService`, which enables various aspects of handling messages such as detecting different downstream message types, determining upstream send status, and automatically displaying simple notifications on the app’s behalf.

  - A service that extends `InstanceIDListenerService`, to handle the creation, rotation, and updating of registration tokens. Optionally, the `android.permission.WAKE_LOCK` permission if the application needs to keep the processor from sleeping when a message is received.

- See the manifest file in the code for an example.
