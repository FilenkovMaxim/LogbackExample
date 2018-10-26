package com.example.maxf.logbackexample;

import android.app.Application;
import android.os.StrictMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App extends Application {

  private static final Logger LOG = LoggerFactory.getLogger(App.class);

  @Override
  public void onCreate() {
    super.onCreate();
    LOG.debug("onCreate()");
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
        .detectAll()
        .penaltyLog()
        .build());
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
        .detectAll()
        .penaltyLog()
        .build());
  }
}
