package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class ManifestInfo {

    /* renamed from: b  reason: collision with root package name */
    private static String f11066b;

    /* renamed from: c  reason: collision with root package name */
    private static String f11067c;

    /* renamed from: d  reason: collision with root package name */
    private static String f11068d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f11069e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f11070f;

    /* renamed from: g  reason: collision with root package name */
    private static String f11071g;

    /* renamed from: h  reason: collision with root package name */
    private static ManifestInfo f11072h;

    /* renamed from: i  reason: collision with root package name */
    private static String f11073i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f11074j;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f11075k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f11076l;

    /* renamed from: m  reason: collision with root package name */
    private static String f11077m;

    /* renamed from: n  reason: collision with root package name */
    private static String f11078n;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f11079o;

    /* renamed from: p  reason: collision with root package name */
    private static String f11080p;

    /* renamed from: q  reason: collision with root package name */
    private static String f11081q;

    /* renamed from: r  reason: collision with root package name */
    private static String f11082r;

    /* renamed from: a  reason: collision with root package name */
    private final String[] f11083a;

    private ManifestInfo(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (Throwable unused) {
            bundle = null;
        }
        bundle = bundle == null ? new Bundle() : bundle;
        if (f11066b == null) {
            f11066b = a(bundle, "CLEVERTAP_ACCOUNT_ID");
        }
        if (f11067c == null) {
            f11067c = a(bundle, "CLEVERTAP_TOKEN");
        }
        if (f11068d == null) {
            f11068d = a(bundle, "CLEVERTAP_REGION");
        }
        f11071g = a(bundle, "CLEVERTAP_NOTIFICATION_ICON");
        f11069e = "1".equals(a(bundle, "CLEVERTAP_USE_GOOGLE_AD_ID"));
        f11070f = "1".equals(a(bundle, "CLEVERTAP_DISABLE_APP_LAUNCHED"));
        f11073i = a(bundle, "CLEVERTAP_INAPP_EXCLUDE");
        f11074j = "1".equals(a(bundle, "CLEVERTAP_SSL_PINNING"));
        f11075k = "1".equals(a(bundle, "CLEVERTAP_BACKGROUND_SYNC"));
        f11076l = "1".equals(a(bundle, "CLEVERTAP_USE_CUSTOM_ID"));
        String a8 = a(bundle, "FCM_SENDER_ID");
        f11077m = a8;
        if (a8 != null) {
            f11077m = a8.replace("id:", "");
        }
        f11078n = a(bundle, "CLEVERTAP_APP_PACKAGE");
        f11079o = "1".equals(a(bundle, "CLEVERTAP_BETA"));
        if (f11080p == null) {
            f11080p = a(bundle, "CLEVERTAP_INTENT_SERVICE");
        }
        f11081q = a(bundle, "CLEVERTAP_XIAOMI_APP_KEY");
        f11082r = a(bundle, "CLEVERTAP_XIAOMI_APP_ID");
        this.f11083a = q(bundle);
    }

    private static String a(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, String str3) {
        f11066b = str;
        f11067c = str2;
        f11068d = str3;
    }

    public static synchronized ManifestInfo i(Context context) {
        ManifestInfo manifestInfo;
        synchronized (ManifestInfo.class) {
            if (f11072h == null) {
                f11072h = new ManifestInfo(context);
            }
            manifestInfo = f11072h;
        }
        return manifestInfo;
    }

    private String[] q(Bundle bundle) {
        String a8 = a(bundle, "CLEVERTAP_IDENTIFIER");
        if (!TextUtils.isEmpty(a8)) {
            return a8.split(",");
        }
        return Constants.f10929e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return f11079o;
    }

    public String d() {
        return f11066b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return f11068d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return f11067c;
    }

    public String g() {
        return f11073i;
    }

    public String h() {
        return f11077m;
    }

    public String j() {
        return f11080p;
    }

    public String k() {
        return f11071g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return f11078n;
    }

    public String[] m() {
        return this.f11083a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return f11070f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return f11075k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return f11074j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return f11076l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return f11069e;
    }
}
