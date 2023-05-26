package com.clevertap.android.sdk.pushnotification;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;

@Deprecated(since = "4.3.0")
/* loaded from: classes.dex */
public class CTNotificationIntentService extends IntentService {
    public static final String MAIN_ACTION = "com.clevertap.PUSH_EVENT";
    public static final String TYPE_BUTTON_CLICK = "com.clevertap.ACTION_BUTTON_CLICK";

    public CTNotificationIntentService() {
        super("CTNotificationIntentService");
    }

    @SuppressLint({"MissingPermission"})
    private void handleActionButtonClick(Bundle bundle) {
        Intent launchIntentForPackage;
        NotificationManager notificationManager;
        try {
            boolean z7 = bundle.getBoolean("autoCancel", false);
            int i8 = bundle.getInt("notificationId", -1);
            String string = bundle.getString("dl");
            Context applicationContext = getApplicationContext();
            if (string != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW", Uri.parse(string));
                Utils.w(applicationContext, launchIntentForPackage);
            } else {
                launchIntentForPackage = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
            }
            if (launchIntentForPackage == null) {
                Logger.n("CTNotificationService: create launch intent.");
                return;
            }
            launchIntentForPackage.setFlags(872415232);
            launchIntentForPackage.putExtras(bundle);
            launchIntentForPackage.removeExtra("dl");
            if (z7 && i8 > -1 && (notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification")) != null) {
                notificationManager.cancel(i8);
            }
            sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            startActivity(launchIntentForPackage);
        } catch (Throwable th) {
            Logger.n("CTNotificationService: unable to process action button click:  " + th.getLocalizedMessage());
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (TYPE_BUTTON_CLICK.equals(extras.getString("ct_type"))) {
            Logger.n("CTNotificationIntentService handling com.clevertap.ACTION_BUTTON_CLICK");
            handleActionButtonClick(extras);
            return;
        }
        Logger.n("CTNotificationIntentService: unhandled intent " + intent.getAction());
    }
}
