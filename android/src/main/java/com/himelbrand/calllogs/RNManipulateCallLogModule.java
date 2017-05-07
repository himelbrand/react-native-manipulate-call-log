package com.himelbrand.calllogs;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;


/**
 * {@link NativeModule} that allows JS to open the default browser
 *  for an url.
 */
public class RNManipulateCallLogModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNManipulateCallLogModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "CallLogs";
  }

  @ReactMethod
  public void addIncomingCallLog(String phone,int duration) {
   if (ActivityCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED)
        ActivityCompat.requestPermissions(getCurrentActivity(), new String[]{Manifest.permission.WRITE_CALL_LOG}, 101);
   else{
       ContentValues values = new ContentValues();
       values.put(CallLog.Calls.CACHED_NUMBER_TYPE, 0);
       values.put(CallLog.Calls.TYPE, Calls.INCOMING_TYPE);
       values.put(CallLog.Calls.DATE, System.currentTimeMillis());
       values.put(CallLog.Calls.DURATION, duration);
       values.put(CallLog.Calls.NUMBER, phone);
       reactContext.getApplicationContext().getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
    }
  }
  @ReactMethod
  public void addIncomingCallLogAt(String phone,int duration,double timeInMillis) {
   if (ActivityCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED)
        ActivityCompat.requestPermissions(getCurrentActivity(), new String[]{Manifest.permission.WRITE_CALL_LOG}, 101);
   else{
       ContentValues values = new ContentValues();
       values.put(CallLog.Calls.CACHED_NUMBER_TYPE, 0);
       values.put(CallLog.Calls.TYPE, Calls.INCOMING_TYPE);
       values.put(CallLog.Calls.DATE, timeInMillis);
       values.put(CallLog.Calls.DURATION, duration);
       values.put(CallLog.Calls.NUMBER, phone);
       reactContext.getApplicationContext().getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
    }
  }

  @ReactMethod
  public void addMissedCallLog(String phone) {
    if (ActivityCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED)
         ActivityCompat.requestPermissions(getCurrentActivity(), new String[]{Manifest.permission.WRITE_CALL_LOG}, 101);
    else{
      ContentValues values = new ContentValues();
      values.put(CallLog.Calls.CACHED_NUMBER_TYPE, 0);
      values.put(CallLog.Calls.TYPE, Calls.MISSED_TYPE);
      values.put(CallLog.Calls.DATE, System.currentTimeMillis());
      values.put(CallLog.Calls.NUMBER, phone);
      reactContext.getApplicationContext().getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
    }
  }

  @ReactMethod
  public void addMissedCallLogAt(String phone,double timeInMillis) {
    if (ActivityCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.WRITE_CALL_LOG) != PackageManager.PERMISSION_GRANTED)
      ActivityCompat.requestPermissions(getCurrentActivity(), new String[]{Manifest.permission.WRITE_CALL_LOG}, 101);
    else{
      ContentValues values = new ContentValues();
      values.put(CallLog.Calls.CACHED_NUMBER_TYPE, 0);
      values.put(CallLog.Calls.TYPE, Calls.MISSED_TYPE);
      values.put(CallLog.Calls.DATE, timeInMillis);
      values.put(CallLog.Calls.NUMBER, phone);
      reactContext.getApplicationContext().getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
    }
  }
}