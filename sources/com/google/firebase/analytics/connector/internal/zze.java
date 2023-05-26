package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public final class zze {

    /* renamed from: a  reason: collision with root package name */
    final Set f15445a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticsConnector.AnalyticsConnectorListener f15446b;

    /* renamed from: c  reason: collision with root package name */
    private final AppMeasurementSdk f15447c;

    /* renamed from: d  reason: collision with root package name */
    private final zzd f15448d;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f15446b = analyticsConnectorListener;
        this.f15447c = appMeasurementSdk;
        zzd zzdVar = new zzd(this);
        this.f15448d = zzdVar;
        appMeasurementSdk.registerOnMeasurementEventListener(zzdVar);
        this.f15445a = new HashSet();
    }
}
