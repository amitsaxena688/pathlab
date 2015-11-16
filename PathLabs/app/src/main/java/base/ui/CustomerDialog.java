package base.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.RelativeLayout;

import com.pathlabs.R;

import base.listeners.MapInfoListener;


/**
 * Created by Sumit on 24-09-2015.
 */
public class CustomerDialog implements View.OnClickListener {
    Dialog dialog;
    Context context;
    MapInfoListener mapInfoListener;
    RelativeLayout rlUpdateStatus,rlDistance;
    public CustomerDialog(Context context,MapInfoListener mapInfoListener)
    {
        this.context = context;
        this.mapInfoListener = mapInfoListener;
    }
    public void showDialog() {
        dialog = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;

        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mapInfoListener.changeMarkerIcon();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }
}
