package edu.northwestern.cbits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.database.Cursor;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

/*
 * This class sends an Intent to start Purple Robot.
 */
public class PurpleRobotIntent extends CordovaPlugin {
  private static final String SEND = "send";
  private static final String PURPLE_ROBOT =
    "edu.northwestern.cbits.purple_robot_manager";

  public static final Uri PR_LAST_KNOWN_PROBE_VALUES = Uri.parse("content://edu.northwestern.cbits.purple_robot_manager.content/recent_probe_values");

  @Override
  public boolean execute(String action, String _rawArgs,
                         CallbackContext _callbackContext) {
    boolean result = false;

    if (SEND.equals(action)) {
      Activity activity = cordova.getActivity();

      Cursor c = activity.getContentResolver().query(PurpleRobotIntent.PR_LAST_KNOWN_PROBE_VALUES, null, null, null, null);
      
      Log.e("HW", "CURSOR: " + c.getCount());
      
      c.close();

    }

    return result;
  }
}
