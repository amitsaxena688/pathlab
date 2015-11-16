package base.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sumit on 21-09-2015.
 */
public class ToastUtil {
    public static void showToastShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
