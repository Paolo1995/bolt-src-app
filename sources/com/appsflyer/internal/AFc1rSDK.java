package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AFc1rSDK implements AFc1oSDK, AFc1wSDK, AFd1uSDK {
    private static String AFInAppEventType;
    private static String valueOf;
    @NonNull
    private final String AFInAppEventParameterName;
    private final byte[] AFKeystoreWrapper;
    private boolean AFLogger;
    private int AFVersionDeclaration;
    private boolean afDebugLog;
    private boolean afErrorLog;
    private final boolean afInfoLog;
    @NonNull
    private final Map<String, String> afRDLog;
    @NonNull
    private final String values;

    public AFc1rSDK() {
    }

    public AFc1rSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z7) {
        this.afErrorLog = true;
        this.afDebugLog = false;
        this.AFLogger = true;
        this.AFVersionDeclaration = -1;
        this.AFInAppEventParameterName = str;
        this.AFKeystoreWrapper = bArr;
        this.values = str2;
        this.afRDLog = map;
        this.afInfoLog = z7;
    }

    public static void AFInAppEventParameterName(String str) {
        if (AFInAppEventType == null) {
            AFKeystoreWrapper(AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().getLevel().values);
        }
        String str2 = AFInAppEventType;
        if (str2 != null) {
            AFLogger.afInfoLog(str.replace(str2, valueOf));
        }
    }

    public static void AFKeystoreWrapper(String str) {
        AFInAppEventType = str;
        if (str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < str.length(); i8++) {
            if (i8 != 0 && i8 != str.length() - 1) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i8));
            }
        }
        valueOf = sb.toString();
    }

    public byte[] AFInAppEventType() {
        return this.AFKeystoreWrapper;
    }

    @NonNull
    public Map<String, String> AFLogger() {
        return this.afRDLog;
    }

    public boolean AFLogger$LogLevel() {
        return this.AFLogger;
    }

    @NonNull
    public String afDebugLog() {
        return this.values;
    }

    public boolean afErrorLog() {
        return this.afInfoLog;
    }

    public AFc1rSDK afErrorLogForExcManagerOnly() {
        this.AFLogger = false;
        return this;
    }

    public boolean afInfoLog() {
        return this.afErrorLog;
    }

    public int afRDLog() {
        return this.AFVersionDeclaration;
    }

    public boolean afWarnLog() {
        return this.afDebugLog;
    }

    @NonNull
    public String valueOf() {
        return this.AFInAppEventParameterName;
    }

    public AFc1rSDK valueOf(int i8) {
        this.AFVersionDeclaration = i8;
        return this;
    }

    public AFc1rSDK AFKeystoreWrapper(boolean z7) {
        this.afDebugLog = z7;
        return this;
    }

    public AFc1rSDK(String str, String str2) {
        this(str, null, str2, new HashMap(), false);
    }
}
