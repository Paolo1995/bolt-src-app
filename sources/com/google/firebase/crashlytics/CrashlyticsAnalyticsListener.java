package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

/* loaded from: classes3.dex */
class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {

    /* renamed from: a  reason: collision with root package name */
    private AnalyticsEventReceiver f15530a;

    /* renamed from: b  reason: collision with root package name */
    private AnalyticsEventReceiver f15531b;

    private static void b(AnalyticsEventReceiver analyticsEventReceiver, @NonNull String str, @NonNull Bundle bundle) {
        if (analyticsEventReceiver == null) {
            return;
        }
        analyticsEventReceiver.b(str, bundle);
    }

    private void c(@NonNull String str, @NonNull Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        if ("clx".equals(bundle.getString("_o"))) {
            analyticsEventReceiver = this.f15530a;
        } else {
            analyticsEventReceiver = this.f15531b;
        }
        b(analyticsEventReceiver, str, bundle);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void a(int i8, Bundle bundle) {
        String string;
        Logger.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i8), bundle));
        if (bundle != null && (string = bundle.getString("name")) != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            c(string, bundle2);
        }
    }

    public void d(AnalyticsEventReceiver analyticsEventReceiver) {
        this.f15531b = analyticsEventReceiver;
    }

    public void e(AnalyticsEventReceiver analyticsEventReceiver) {
        this.f15530a = analyticsEventReceiver;
    }
}
