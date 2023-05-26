package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public final class zzg {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsConnector.AnalyticsConnectorListener f15450a;

    /* renamed from: b  reason: collision with root package name */
    private final AppMeasurementSdk f15451b;

    /* renamed from: c  reason: collision with root package name */
    private final zzf f15452c;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f15450a = analyticsConnectorListener;
        this.f15451b = appMeasurementSdk;
        zzf zzfVar = new zzf(this);
        this.f15452c = zzfVar;
        appMeasurementSdk.registerOnMeasurementEventListener(zzfVar);
    }
}
