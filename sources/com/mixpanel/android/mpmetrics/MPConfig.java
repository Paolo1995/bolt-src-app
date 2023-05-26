package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.OfflineMode;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class MPConfig {
    public static boolean F = false;
    private static MPConfig G;
    private static final Object H = new Object();
    private final int A;
    private final String B;
    private final String C;
    private SSLSocketFactory D;
    private OfflineMode E;

    /* renamed from: a  reason: collision with root package name */
    private final int f19180a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19181b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19182c;

    /* renamed from: d  reason: collision with root package name */
    private final long f19183d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19184e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19185f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f19186g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f19187h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f19188i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f19189j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f19190k;

    /* renamed from: l  reason: collision with root package name */
    private final String[] f19191l;

    /* renamed from: m  reason: collision with root package name */
    private String f19192m;

    /* renamed from: n  reason: collision with root package name */
    private String f19193n;

    /* renamed from: o  reason: collision with root package name */
    private String f19194o;

    /* renamed from: p  reason: collision with root package name */
    private String f19195p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f19196q;

    /* renamed from: r  reason: collision with root package name */
    private final String f19197r;

    /* renamed from: s  reason: collision with root package name */
    private final String f19198s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f19199t;

    /* renamed from: u  reason: collision with root package name */
    private final int f19200u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f19201v;

    /* renamed from: w  reason: collision with root package name */
    private final int f19202w;

    /* renamed from: x  reason: collision with root package name */
    private final int f19203x;

    /* renamed from: y  reason: collision with root package name */
    private final int f19204y;

    /* renamed from: z  reason: collision with root package name */
    private final boolean f19205z;

    MPConfig(Bundle bundle, Context context) {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e8) {
            MPLog.f("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", e8);
        }
        this.D = sSLSocketFactory;
        boolean z7 = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        F = z7;
        if (z7) {
            MPLog.g(2);
        }
        if (bundle.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
            MPLog.k("MixpanelAPI.Conf", "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml.");
        }
        this.f19180a = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.f19181b = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.f19182c = bundle.getBoolean("com.mixpanel.android.MPConfig.FlushOnBackground", true);
        this.f19184e = bundle.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        this.f19198s = bundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.f19186g = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
        this.f19187h = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
        this.f19188i = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.f19189j = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
        this.f19199t = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.f19190k = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableExceptionHandler", false);
        this.f19200u = bundle.getInt("com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor", 10);
        this.f19201v = bundle.getBoolean("com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor", false);
        this.f19196q = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        this.f19202w = bundle.getInt("com.mixpanel.android.MPConfig.NotificationDefaults", 0);
        this.f19203x = bundle.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
        this.f19204y = bundle.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f19205z = bundle.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
        this.f19185f = bundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        this.A = bundle.getInt("com.mixpanel.android.MPConfig.NotificationChannelImportance", 3);
        Object obj = bundle.get("com.mixpanel.android.MPConfig.DataExpiration");
        long j8 = 432000000;
        if (obj != null) {
            try {
                if (obj instanceof Integer) {
                    j8 = ((Integer) obj).intValue();
                } else if (obj instanceof Float) {
                    j8 = ((Float) obj).floatValue();
                } else {
                    throw new NumberFormatException(obj.toString() + " is not a number.");
                }
            } catch (Exception e9) {
                MPLog.d("MixpanelAPI.Conf", "Error parsing com.mixpanel.android.MPConfig.DataExpiration meta-data value", e9);
            }
        }
        this.f19183d = j8;
        String string = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelId");
        this.B = string == null ? "mp" : string;
        String string2 = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelName");
        this.C = string2 == null ? SystemInformation.g(context).a() : string2;
        String string3 = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (string3 != null) {
            I(string3);
        } else {
            L();
        }
        String string4 = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        if (string4 != null) {
            O(string4);
        } else {
            N();
        }
        String string5 = bundle.getString("com.mixpanel.android.MPConfig.GroupsEndpoint");
        if (string5 != null) {
            J(string5);
        } else {
            M();
        }
        String string6 = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        if (string6 != null) {
            H(string6);
        } else {
            K();
        }
        String string7 = bundle.getString("com.mixpanel.android.MPConfig.EditorUrl");
        this.f19197r = string7 == null ? "wss://switchboard.mixpanel.com/connect/" : string7;
        int i8 = bundle.getInt("com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects", -1);
        if (i8 != -1) {
            this.f19191l = context.getResources().getStringArray(i8);
        } else {
            this.f19191l = new String[0];
        }
        MPLog.i("MixpanelAPI.Conf", toString());
    }

    static MPConfig G(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new MPConfig(bundle, context);
        } catch (PackageManager.NameNotFoundException e8) {
            throw new RuntimeException("Can't configure Mixpanel with package name " + packageName, e8);
        }
    }

    public static MPConfig s(Context context) {
        synchronized (H) {
            if (G == null) {
                G = G(context.getApplicationContext());
            }
        }
        return G;
    }

    public String A() {
        return this.f19193n;
    }

    public String B() {
        return this.f19198s;
    }

    public synchronized SSLSocketFactory C() {
        return this.D;
    }

    public int D() {
        return this.f19204y;
    }

    public boolean E() {
        return this.f19185f;
    }

    public boolean F() {
        return this.f19205z;
    }

    public void H(String str) {
        this.f19195p = str;
    }

    public void I(String str) {
        this.f19192m = str;
    }

    public void J(String str) {
        this.f19194o = str;
    }

    public void K() {
        H("https://decide.mixpanel.com/decide");
    }

    public void L() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.mixpanel.com/track?ip=");
        if (F()) {
            str = "1";
        } else {
            str = "0";
        }
        sb.append(str);
        I(sb.toString());
    }

    public void M() {
        J("https://api.mixpanel.com/groups");
    }

    public void N() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.mixpanel.com/engage?ip=");
        if (F()) {
            str = "1";
        } else {
            str = "0";
        }
        sb.append(str);
        O(sb.toString());
    }

    public void O(String str) {
        this.f19193n = str;
    }

    public boolean a() {
        return this.f19196q;
    }

    public int b() {
        return this.f19180a;
    }

    public long c() {
        return this.f19183d;
    }

    public String d() {
        return this.f19195p;
    }

    public boolean e() {
        return this.f19188i;
    }

    public boolean f() {
        return this.f19199t;
    }

    public boolean g() {
        return this.f19187h;
    }

    public boolean h() {
        return this.f19190k;
    }

    public boolean i() {
        return this.f19186g;
    }

    public boolean j() {
        return this.f19189j;
    }

    public String[] k() {
        return this.f19191l;
    }

    public String l() {
        return this.f19197r;
    }

    public String m() {
        return this.f19192m;
    }

    public int n() {
        return this.f19181b;
    }

    public boolean o() {
        return this.f19182c;
    }

    public String p() {
        return this.f19194o;
    }

    public boolean q() {
        return this.f19201v;
    }

    public int r() {
        return this.f19200u;
    }

    public int t() {
        return this.f19184e;
    }

    public String toString() {
        return "Mixpanel (5.8.5) configured with:\n    AutoShowMixpanelUpdates " + a() + "\n    BulkUploadLimit " + b() + "\n    FlushInterval " + n() + "\n    DataExpiration " + c() + "\n    MinimumDatabaseLimit " + t() + "\n    DisableAppOpenEvent " + e() + "\n    DisableViewCrawler " + j() + "\n    DisableGestureBindingUI " + i() + "\n    DisableEmulatorBindingUI " + g() + "\n    EnableDebugLogging " + F + "\n    TestMode " + E() + "\n    EventsEndpoint " + m() + "\n    PeopleEndpoint " + A() + "\n    DecideEndpoint " + d() + "\n    EditorUrl " + l() + "\n    ImageCacheMaxMemoryFactor " + r() + "\n    DisableDecideChecker " + f() + "\n    IgnoreInvisibleViewsEditor " + q() + "\n    NotificationDefaults " + y() + "\n    MinimumSessionDuration: " + u() + "\n    SessionTimeoutDuration: " + D() + "\n    DisableExceptionHandler: " + h() + "\n    NotificationChannelId: " + v() + "\n    NotificationChannelName: " + x() + "\n    NotificationChannelImportance: " + w() + "\n    FlushOnBackground: " + o();
    }

    public int u() {
        return this.f19203x;
    }

    public String v() {
        return this.B;
    }

    public int w() {
        return this.A;
    }

    public String x() {
        return this.C;
    }

    public int y() {
        return this.f19202w;
    }

    public synchronized OfflineMode z() {
        return this.E;
    }
}
