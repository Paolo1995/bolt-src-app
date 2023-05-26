package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public final class zzf implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzg f15449a;

    public zzf(zzg zzgVar) {
        this.f15449a = zzgVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzhf
    public final void onEvent(String str, String str2, Bundle bundle, long j8) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str != null && !str.equals(AppMeasurement.CRASH_ORIGIN) && zzc.h(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j8);
            bundle2.putBundle("params", bundle);
            analyticsConnectorListener = this.f15449a.f15450a;
            analyticsConnectorListener.a(3, bundle2);
        }
    }
}
