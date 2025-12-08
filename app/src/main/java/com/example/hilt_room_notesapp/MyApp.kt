package com.example.hilt_room_notesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApp: Application() {

}










/*

In the AndroidManifest.xml file, the attribute android:name=".MyApp" within the <application>
tag serves a specific and powerful purpose: it defines the entry point class for your entire application process.

Here is the breakdown of what it actually does and why it is used.

1. It replaces the default Application class:

   By default, Android uses the standard android.app.Application class to manage your app's lifecycle.
   When you add android:name=".MyApp", you are telling the Android system:

   "Don't use the default class. Instead, please instantiate my custom subclass called MyApp when the process starts."

2. It is the first thing to run:

   This class is instantiated before any Activity, Service, or Receiver is created.
   This makes it the perfect place for global initialization.
 */