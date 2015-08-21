package edu.northwestern.cbits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

/*
 * This class sends an Intent to start Purple Robot.
 */
public class PurpleRobotIntent extends CordovaPlugin {
  private static final String SEND = "send";
  private static final String PURPLE_ROBOT =
    "edu.northwestern.cbits.purple_robot_manager";

  @Override
  public boolean execute(String action, String _rawArgs,
                         CallbackContext _callbackContext) {
    boolean result = false;

    if (SEND.equals(action)) {
      Activity activity = cordova.getActivity();
      Context context = activity.getApplicationContext();
      PackageManager manager = context.getPackageManager();
      Intent i = manager.getLaunchIntentForPackage(PURPLE_ROBOT);

      if (i != null) {
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        context.startActivity(i);
        result = true;
      }
    }

    return result;
  }
}
