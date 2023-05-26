package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
public final class AFa1hSDK {

    /* loaded from: classes.dex */
    static final class AFa1zSDK {
        final String AFInAppEventParameterName;
        final String AFInAppEventType;
        final String AFKeystoreWrapper;

        AFa1zSDK(@NonNull String str, String str2, String str3) {
            this.AFKeystoreWrapper = str;
            this.AFInAppEventType = str2;
            this.AFInAppEventParameterName = str3;
        }
    }

    private static boolean AFInAppEventType(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public final AFa1zSDK valueOf(@NonNull Context context) {
        String str;
        String str2;
        TelephonyManager telephonyManager;
        String str3 = "unknown";
        String str4 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                int length = allNetworks.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i8]);
                    if (AFInAppEventType(networkInfo)) {
                        if (1 == networkInfo.getType()) {
                            str3 = "WIFI";
                        } else if (networkInfo.getType() == 0) {
                            str3 = "MOBILE";
                        }
                    } else {
                        i8++;
                    }
                }
            }
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str2 = telephonyManager.getSimOperatorName();
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            str4 = telephonyManager.getNetworkOperatorName();
            if (str4 == null || str4.isEmpty()) {
                if (2 == telephonyManager.getPhoneType()) {
                    str4 = "CDMA";
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str = str4;
            str4 = str2;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            String str5 = str;
            str2 = str4;
            str4 = str5;
            return new AFa1zSDK(str3, str4, str2);
        }
        return new AFa1zSDK(str3, str4, str2);
    }
}
