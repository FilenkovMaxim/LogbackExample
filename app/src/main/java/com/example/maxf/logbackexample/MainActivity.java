package com.example.maxf.logbackexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;

public class MainActivity extends AppCompatActivity {

  private static final Logger LOG = LoggerFactory.getLogger(MainActivity.class);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LOG.debug("onCreate()");
    setContentView(R.layout.activity_main);
    findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        resetLogs();
      }
    });
  }

  private void resetLogs() {
    LOG.debug("resetLogs()");
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    ContextInitializer ci = new ContextInitializer(lc);
    lc.reset();
    try {
      ci.autoConfig();
    } catch (JoranException e) {
      LOG.error("resetLogs() ci.autoConfig() fault: {}", e);
    }
  }
}
