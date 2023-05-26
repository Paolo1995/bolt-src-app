package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AFa1sSDK {
    Map<String, Object> AFInAppEventParameterName;
    public Application AFInAppEventType;
    public final Map<String, Object> AFKeystoreWrapper;
    String AFLogger;
    private byte[] AFLogger$LogLevel;
    private final boolean AFVersionDeclaration;
    String afDebugLog;
    public String afErrorLog;
    public int afInfoLog;
    public String afRDLog;
    String valueOf;
    public AppsFlyerRequestListener values;

    public AFa1sSDK() {
        this(null, null, null, null);
    }

    public final boolean AFInAppEventParameterName() {
        return this.afDebugLog == null && this.afRDLog == null;
    }

    public final AFa1sSDK AFInAppEventType(byte[] bArr) {
        this.AFLogger$LogLevel = bArr;
        return this;
    }

    public abstract AFd1rSDK AFInAppEventType();

    public AFa1sSDK AFKeystoreWrapper(String str) {
        this.afErrorLog = str;
        return this;
    }

    public boolean AFLogger() {
        return true;
    }

    public boolean afDebugLog() {
        return true;
    }

    public boolean afErrorLog() {
        return true;
    }

    public boolean afRDLog() {
        return false;
    }

    public final boolean valueOf() {
        return this.AFVersionDeclaration;
    }

    public final byte[] values() {
        return this.AFLogger$LogLevel;
    }

    public AFa1sSDK(String str, String str2, Boolean bool, Context context) {
        this.AFKeystoreWrapper = new HashMap();
        this.afDebugLog = str;
        this.afErrorLog = str2;
        this.AFVersionDeclaration = bool != null ? bool.booleanValue() : true;
        if (context != null) {
            this.AFInAppEventType = (Application) context.getApplicationContext();
        }
    }

    public static boolean values(double d8) {
        if (d8 < 0.0d || d8 >= 1.0d) {
            return false;
        }
        if (d8 == 0.0d) {
            return true;
        }
        int i8 = (int) (1.0d / d8);
        int i9 = i8 + 1;
        if (i9 > 0) {
            return ((int) ((Math.random() * ((double) (i9 - 1))) + 1.0d)) != i8;
        }
        throw new IllegalArgumentException("Unsupported max value");
    }

    public final AFa1sSDK AFInAppEventParameterName(int i8) {
        this.afInfoLog = i8;
        synchronized (this.AFKeystoreWrapper) {
            if (this.AFKeystoreWrapper.containsKey("counter")) {
                this.AFKeystoreWrapper.put("counter", Integer.toString(i8));
            }
            if (this.AFKeystoreWrapper.containsKey("launch_counter")) {
                this.AFKeystoreWrapper.put("launch_counter", Integer.toString(i8));
            }
        }
        return this;
    }

    public final AFa1sSDK AFKeystoreWrapper(Map<String, ?> map) {
        synchronized (map) {
            this.AFKeystoreWrapper.putAll(map);
        }
        return this;
    }

    public final AFa1sSDK AFKeystoreWrapper(String str, Object obj) {
        synchronized (this.AFKeystoreWrapper) {
            this.AFKeystoreWrapper.put(str, obj);
        }
        return this;
    }

    public final Map<String, Object> AFKeystoreWrapper() {
        return this.AFKeystoreWrapper;
    }
}
