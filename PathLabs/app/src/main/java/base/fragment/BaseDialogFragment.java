package base.fragment;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import base.constents.AppConstent;
import base.listeners.DateTimeListeners;

/**
 * Created by Sumit on 05-10-2015.
 */
public class BaseDialogFragment extends DialogFragment {

    public void showDialogFragment(DialogFragment dialogFragment, String tag, DateTimeListeners dateTimeListeners) {

        int mStackLevel = 0;
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag(tag);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Listener", dateTimeListeners);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(ft, AppConstent.STATUS_UPDATE_DIALOG);
    }

    public void dismissDialog(String tag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag(tag);
        if (prev != null) {
           ft.remove(prev).commit();
        }
    }
}
