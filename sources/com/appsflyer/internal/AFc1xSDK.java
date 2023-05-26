package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
public final class AFc1xSDK implements AFc1ySDK {
    private final SharedPreferences AFInAppEventType;

    public AFc1xSDK(SharedPreferences sharedPreferences) {
        this.AFInAppEventType = sharedPreferences;
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final long AFInAppEventParameterName(String str, long j8) {
        try {
            return this.AFInAppEventType.getLong(str, j8);
        } catch (ClassCastException e8) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e8);
            return j8;
        }
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final void AFInAppEventType(String str, boolean z7) {
        this.AFInAppEventType.edit().putBoolean(str, z7).apply();
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final boolean AFKeystoreWrapper(String str) {
        try {
            return this.AFInAppEventType.getBoolean(str, false);
        } catch (ClassCastException e8) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e8);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final void valueOf(String str, String str2) {
        this.AFInAppEventType.edit().putString(str, str2).apply();
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final String values(String str, String str2) {
        try {
            return this.AFInAppEventType.getString(str, str2);
        } catch (ClassCastException e8) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e8);
            return str2;
        }
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final void AFInAppEventType(String str, long j8) {
        this.AFInAppEventType.edit().putLong(str, j8).apply();
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final void valueOf(String str) {
        this.AFInAppEventType.edit().remove(str).apply();
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final int AFInAppEventType(String str, int i8) {
        try {
            return this.AFInAppEventType.getInt(str, i8);
        } catch (ClassCastException e8) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e8);
            return i8;
        }
    }

    @Override // com.appsflyer.internal.AFc1ySDK
    public final void AFKeystoreWrapper(String str, int i8) {
        this.AFInAppEventType.edit().putInt(str, i8).apply();
    }
}
