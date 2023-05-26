package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.mixpanel.android.util.MPLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
class InstallReferrerPlay implements InstallReferrerStateListener {

    /* renamed from: j  reason: collision with root package name */
    private static String f19167j = "MixpanelAPI.InstallReferrerPlay";

    /* renamed from: k  reason: collision with root package name */
    protected static final Pattern f19168k = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");

    /* renamed from: l  reason: collision with root package name */
    private static boolean f19169l = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f19174e;

    /* renamed from: f  reason: collision with root package name */
    private ReferrerCallback f19175f;

    /* renamed from: g  reason: collision with root package name */
    private InstallReferrerClient f19176g;

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f19170a = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f19171b = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");

    /* renamed from: c  reason: collision with root package name */
    private final Pattern f19172c = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");

    /* renamed from: d  reason: collision with root package name */
    private final Pattern f19173d = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

    /* renamed from: h  reason: collision with root package name */
    private int f19177h = 0;

    /* renamed from: i  reason: collision with root package name */
    private Timer f19178i = new Timer();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface ReferrerCallback {
        void a();
    }

    public InstallReferrerPlay(Context context, ReferrerCallback referrerCallback) {
        this.f19174e = context;
        this.f19175f = referrerCallback;
    }

    private String c(Matcher matcher) {
        String group;
        if (matcher.find() && (group = matcher.group(2)) != null) {
            try {
                return URLDecoder.decode(group, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                MPLog.c(f19167j, "Could not decode a parameter into UTF-8");
                return null;
            }
        }
        return null;
    }

    private void d() {
        if (this.f19177h > 5) {
            MPLog.a(f19167j, "Already retried 5 times. Disconnecting...");
            b();
            return;
        }
        this.f19178i.schedule(new TimerTask() { // from class: com.mixpanel.android.mpmetrics.InstallReferrerPlay.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                InstallReferrerPlay.this.a();
            }
        }, 2500L);
        this.f19177h++;
    }

    public void a() {
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(this.f19174e).build();
            this.f19176g = build;
            build.startConnection(this);
            f19169l = true;
        } catch (SecurityException e8) {
            MPLog.d(f19167j, "Install referrer client could not start connection", e8);
        }
    }

    public void b() {
        InstallReferrerClient installReferrerClient = this.f19176g;
        if (installReferrerClient != null && installReferrerClient.isReady()) {
            try {
                this.f19176g.endConnection();
            } catch (Exception e8) {
                MPLog.d(f19167j, "Error closing referrer connection", e8);
            }
        }
    }

    void e(String str) {
        if (str == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("referrer", str);
        String c8 = c(f19168k.matcher(str));
        if (c8 != null) {
            hashMap.put("utm_source", c8);
        }
        String c9 = c(this.f19170a.matcher(str));
        if (c9 != null) {
            hashMap.put("utm_medium", c9);
        }
        String c10 = c(this.f19171b.matcher(str));
        if (c10 != null) {
            hashMap.put("utm_campaign", c10);
        }
        String c11 = c(this.f19172c.matcher(str));
        if (c11 != null) {
            hashMap.put("utm_content", c11);
        }
        String c12 = c(this.f19173d.matcher(str));
        if (c12 != null) {
            hashMap.put("utm_term", c12);
        }
        PersistentIdentity.R(this.f19174e, "com.mixpanel.android.mpmetrics.ReferralInfo", hashMap);
        ReferrerCallback referrerCallback = this.f19175f;
        if (referrerCallback != null) {
            referrerCallback.a();
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
        MPLog.a(f19167j, "Install Referrer Service Disconnected.");
        d();
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerSetupFinished(int i8) {
        boolean z7 = true;
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            MPLog.a(f19167j, "Unexpected error.");
                        }
                    } else {
                        MPLog.a(f19167j, "API not available on the current Play Store app.");
                    }
                } else {
                    MPLog.a(f19167j, "Service is currently unavailable.");
                }
            } else {
                try {
                    e(this.f19176g.getInstallReferrer().getInstallReferrer());
                } catch (Exception e8) {
                    MPLog.b(f19167j, "There was an error fetching your referrer details.", e8);
                }
            }
            z7 = false;
        } else {
            MPLog.a(f19167j, "Service was disconnected unexpectedly.");
        }
        if (z7) {
            d();
        } else {
            b();
        }
    }
}
