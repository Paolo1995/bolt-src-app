package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ConnectIntegrations {

    /* renamed from: a  reason: collision with root package name */
    private final MixpanelAPI f19094a;

    /* renamed from: b  reason: collision with root package name */
    private Context f19095b;

    /* renamed from: c  reason: collision with root package name */
    private String f19096c;

    /* renamed from: d  reason: collision with root package name */
    private int f19097d;

    public ConnectIntegrations(MixpanelAPI mixpanelAPI, Context context) {
        this.f19094a = mixpanelAPI;
        this.f19095b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Object invoke = Class.forName("com.urbanairship.UAirship").getMethod("shared", new Class[0]).invoke(null, new Object[0]);
            Object invoke2 = invoke.getClass().getMethod("getPushManager", new Class[0]).invoke(invoke, new Object[0]);
            String str = (String) invoke2.getClass().getMethod("getChannelId", new Class[0]).invoke(invoke2, new Object[0]);
            if (str != null && !str.isEmpty()) {
                this.f19097d = 0;
                String str2 = this.f19096c;
                if (str2 == null || !str2.equals(str)) {
                    this.f19094a.C().g("$android_urban_airship_channel_id", str);
                    this.f19096c = str;
                }
            } else {
                int i8 = this.f19097d + 1;
                this.f19097d = i8;
                if (i8 <= 3) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mixpanel.android.mpmetrics.ConnectIntegrations.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ConnectIntegrations.this.c();
                        }
                    }, 2000L);
                }
            }
        } catch (ClassNotFoundException e8) {
            MPLog.l("MixpanelAPI.CnctInts", "Airship SDK not found but Urban Airship is integrated on Mixpanel", e8);
        } catch (IllegalAccessException e9) {
            MPLog.d("MixpanelAPI.CnctInts", "method invocation failed", e9);
        } catch (NoSuchMethodException e10) {
            MPLog.d("MixpanelAPI.CnctInts", "Airship SDK class exists but methods do not", e10);
        } catch (InvocationTargetException e11) {
            MPLog.d("MixpanelAPI.CnctInts", "method invocation failed", e11);
        } catch (Exception e12) {
            MPLog.d("MixpanelAPI.CnctInts", "Error setting Airship people property", e12);
        }
    }

    private void d() {
        try {
            Object invoke = Class.forName("com.appboy.Appboy").getMethod("getInstance", Context.class).invoke(null, this.f19095b);
            String str = (String) invoke.getClass().getMethod("getDeviceId", new Class[0]).invoke(invoke, new Object[0]);
            Object invoke2 = invoke.getClass().getMethod("getCurrentUser", new Class[0]).invoke(invoke, new Object[0]);
            if (invoke2 == null) {
                MPLog.k("MixpanelAPI.CnctInts", "Make sure Braze is initialized properly before Mixpanel.");
                return;
            }
            String str2 = (String) invoke2.getClass().getMethod("getUserId", new Class[0]).invoke(invoke2, new Object[0]);
            if (str != null && !str.isEmpty()) {
                MixpanelAPI mixpanelAPI = this.f19094a;
                mixpanelAPI.l(str, mixpanelAPI.y());
                this.f19094a.C().g("$braze_device_id", str);
            }
            if (str2 != null && !str2.isEmpty()) {
                MixpanelAPI mixpanelAPI2 = this.f19094a;
                mixpanelAPI2.l(str2, mixpanelAPI2.y());
                this.f19094a.C().g("$braze_external_id", str2);
            }
        } catch (ClassNotFoundException e8) {
            MPLog.l("MixpanelAPI.CnctInts", "Braze SDK not found but Braze is integrated on Mixpanel", e8);
        } catch (IllegalAccessException e9) {
            MPLog.d("MixpanelAPI.CnctInts", "method invocation failed", e9);
        } catch (NoSuchMethodException e10) {
            MPLog.d("MixpanelAPI.CnctInts", "Braze SDK class exists but methods do not", e10);
        } catch (InvocationTargetException e11) {
            MPLog.d("MixpanelAPI.CnctInts", "method invocation failed", e11);
        } catch (Exception e12) {
            MPLog.d("MixpanelAPI.CnctInts", "Error setting braze people properties", e12);
        }
    }

    public void b() {
        this.f19096c = null;
        this.f19097d = 0;
    }

    public void e(Set<String> set) {
        if (set.contains("urbanairship")) {
            c();
        }
        if (set.contains("braze")) {
            d();
        }
    }
}
