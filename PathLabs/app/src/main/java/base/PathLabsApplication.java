package base;

import android.app.Application;
import android.content.Context;


public class PathLabsApplication extends Application {

	private static boolean isGcmLoaded;
	private boolean isAppInVisible;
    public static Context mContext ;
	private Object location;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();


	}

	public static boolean isGcmLoaded() {
		return isGcmLoaded;
	}

	public boolean isAppInVisible() {
		return isAppInVisible;
	}

	public void setAppInVisible(boolean isAppInVisible) {
		this.isAppInVisible = isAppInVisible;
	}

	public static void setGcmLoaded(boolean isGcmLoaded) {
		PathLabsApplication.isGcmLoaded = isGcmLoaded;

	}



}
