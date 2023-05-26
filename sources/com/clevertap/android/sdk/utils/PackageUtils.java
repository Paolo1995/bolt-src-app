package com.clevertap.android.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* loaded from: classes.dex */
public class PackageUtils {
    public static boolean a(@NonNull Context context) {
        try {
            String str = GooglePlayServicesUtil.GMS_ERROR_DIALOG;
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(@NonNull Context context) {
        if (!c(context, "com.android.vending") && !c(context, "com.google.market")) {
            return false;
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
