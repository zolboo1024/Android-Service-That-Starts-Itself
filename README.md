# Android Service That Starts Itself
Creating an android service that doesn't get killed by GM

This is a simple example of an application that implements a service that 
does NOT get killed by the Android Memory Manager. An application gets killed 
for a lot of reason (if the app is a third party app, not a root app):

if the application is taking too much of the phone's memory
or if the application has simply been open too long. 

Now here's a simple concept of how to create a service that lasts as long 
as the phone is on: 

You create the Service that you don't want killed and in the onDestroy() 
method, you send a signal to a simple BroadcastReceiver. Then

You create a BroadcastReceiver that is set up to receive signal when 
the service is destroyed and starts the same service that just got killed!

Hope you find something useful here! Cheers!
