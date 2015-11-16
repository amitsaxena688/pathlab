package base.listeners;

import android.os.Parcelable;

/**
 * Created by sam on 10/4/2015.
 */
public interface DateTimeListeners extends Parcelable {
    public void setTime(int hourOfDay, int minute);

    public void setDate(int day, int month, int year);
}
