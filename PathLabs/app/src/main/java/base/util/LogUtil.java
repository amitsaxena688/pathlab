package base.util;

import android.util.Log;

import com.pathlabs.BuildConfig;


/**
 * Created by Sumit on 21-09-2015.
 */
public class LogUtil {
    public static void showErrorLog(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void showVerboseLog(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg);
        }
    }
}
