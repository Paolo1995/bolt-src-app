package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public final class zzd implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zze f15444a;

    public zzd(zze zzeVar) {
        this.f15444a = zzeVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzhf
    public final void onEvent(String str, String str2, Bundle bundle, long j8) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (!this.f15444a.f15445a.contains(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("events", zzc.c(str2));
        analyticsConnectorListener = this.f15444a.f15446b;
        analyticsConnectorListener.a(2, bundle2);
    }
}
