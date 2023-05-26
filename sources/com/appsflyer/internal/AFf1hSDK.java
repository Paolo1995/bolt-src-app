package com.appsflyer.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFf1hSDK {
    public static final String AFKeystoreWrapper;
    public static final String AFLogger;
    public static String AFVersionDeclaration;
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK(null);
    public static String afDebugLog;
    public static final String afErrorLog;
    private static final String afErrorLogForExcManagerOnly;
    public static String afInfoLog;
    public static String afRDLog;
    public static String getLevel;
    public static final String valueOf;
    public static final String values;
    public final AFc1vSDK AFInAppEventParameterName;
    public final AFf1fSDK AFInAppEventType;

    /* loaded from: classes.dex */
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(AFb1xSDK.AFKeystoreWrapper);
        sb.append("/androidevent?app_id=");
        String obj = sb.toString();
        afErrorLogForExcManagerOnly = obj;
        StringBuilder sb2 = new StringBuilder("https://%sattr.%s/api/v");
        sb2.append(obj);
        AFKeystoreWrapper = sb2.toString();
        valueOf = "https://%sadrevenue.%s/api/v2/generic/v6.10.2/android?app_id=";
        StringBuilder sb3 = new StringBuilder("https://%sconversions.%s/api/v");
        sb3.append(obj);
        values = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%slaunches.%s/api/v");
        sb4.append(obj);
        AFLogger = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%sinapps.%s/api/v");
        sb5.append(obj);
        afErrorLog = sb5.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AFf1hSDK(AFc1vSDK aFc1vSDK) {
        this(aFc1vSDK, null, 2, null);
        Intrinsics.f(aFc1vSDK, "");
    }

    private AFf1hSDK(AFc1vSDK aFc1vSDK, AFf1fSDK aFf1fSDK) {
        Intrinsics.f(aFc1vSDK, "");
        Intrinsics.f(aFf1fSDK, "");
        this.AFInAppEventParameterName = aFc1vSDK;
        this.AFInAppEventType = aFf1fSDK;
    }

    public static String AFInAppEventType(String str, boolean z7) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!z7) {
            str2 = "&buildnumber=6.10.2";
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public /* synthetic */ AFf1hSDK(AFc1vSDK aFc1vSDK, AFf1fSDK aFf1fSDK, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1vSDK, (i8 & 2) != 0 ? new AFf1eSDK() : aFf1fSDK);
    }
}
