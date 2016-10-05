package com.project5.snakeintheforest.ActivitiesListeners;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class QuitDialogListener implements OnClickListener{
    private Activity activity;

   public QuitDialogListener(Activity activity) {
        this.activity = activity;
    }

        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    activity.finish();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
}
