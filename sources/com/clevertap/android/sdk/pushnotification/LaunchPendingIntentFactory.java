package com.clevertap.android.sdk.pushnotification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.Utils;

/* loaded from: classes.dex */
class LaunchPendingIntentFactory {
    LaunchPendingIntentFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PendingIntent a(@NonNull Bundle bundle, @NonNull Context context) {
        Intent launchIntentForPackage;
        int i8 = Build.VERSION.SDK_INT;
        int i9 = 201326592;
        if (i8 >= 31) {
            if (bundle.containsKey("wzrk_dl")) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("wzrk_dl")));
                Utils.w(context, launchIntentForPackage);
            } else {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                if (launchIntentForPackage == null) {
                    return null;
                }
            }
            launchIntentForPackage.setFlags(872415232);
            launchIntentForPackage.putExtras(bundle);
            launchIntentForPackage.removeExtra("wzrk_acts");
            return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), launchIntentForPackage, 201326592);
        }
        Intent intent = new Intent(context, CTPushNotificationReceiver.class);
        intent.putExtras(bundle);
        intent.removeExtra("wzrk_acts");
        if (i8 < 23) {
            i9 = 134217728;
        }
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, i9);
    }
}
