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
