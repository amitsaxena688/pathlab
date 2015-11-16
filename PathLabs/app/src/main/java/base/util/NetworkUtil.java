package base.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkUtil {
	public static boolean checkInternetConnection(Context context) {

		ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		// ARE WE CONNECTED TO THE NET
		if (conMgr.getActiveNetworkInfo() != null

		&& conMgr.getActiveNetworkInfo().isAvailable()

		&& conMgr.getActiveNetworkInfo().isConnected()) {

			return true;

		} else {
			return false;
		}
	}
}
