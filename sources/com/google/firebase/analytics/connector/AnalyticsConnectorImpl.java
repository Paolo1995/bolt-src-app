package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {

    /* renamed from: c  reason: collision with root package name */
    private static volatile AnalyticsConnector f15432c;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final AppMeasurementSdk f15433a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Map f15434b;

    AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f15433a = appMeasurementSdk;
        this.f15434b = new ConcurrentHashMap();
    }

    @NonNull
    @KeepForSdk
    public static AnalyticsConnector h(@NonNull FirebaseApp firebaseApp, @NonNull Context context, @NonNull Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f15432c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (f15432c == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.t()) {
                        subscriber.b(DataCollectionDefaultChange.class, new Executor() { // from class: com.google.firebase.analytics.connector.zza
                            @Override // java.util.concurrent.Executor
                            public final void execute(Runnable runnable) {
                                runnable.run();
                            }
                        }, new EventHandler() { // from class: com.google.firebase.analytics.connector.zzb
                            @Override // com.google.firebase.events.EventHandler
                            public final void a(Event event) {
                                AnalyticsConnectorImpl.i(event);
                            }
                        });
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.s());
                    }
                    f15432c = new AnalyticsConnectorImpl(zzee.zzg(context, null, null, null, bundle).zzd());
                }
            }
        }
        return f15432c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(Event event) {
        boolean z7 = ((DataCollectionDefaultChange) event.a()).f15373a;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(f15432c)).f15433a.zza(z7);
        }
    }

    private final boolean j(@NonNull String str) {
        if (!str.isEmpty() && this.f15434b.containsKey(str) && this.f15434b.get(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void a(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (!zzc.f(conditionalUserProperty)) {
            return;
        }
        this.f15433a.setConditionalUserProperty(zzc.a(conditionalUserProperty));
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void b(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!zzc.i(str) || !zzc.g(str2, bundle) || !zzc.e(str, str2, bundle)) {
            return;
        }
        zzc.d(str, str2, bundle);
        this.f15433a.logEvent(str, str2, bundle);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void c(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (!zzc.i(str) || !zzc.j(str, str2)) {
            return;
        }
        this.f15433a.setUserProperty(str, str2, obj);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (str2 != null && !zzc.g(str2, bundle)) {
            return;
        }
        this.f15433a.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    @KeepForSdk
    public Map<String, Object> d(boolean z7) {
        return this.f15433a.getUserProperties(null, null, z7);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public int e(@NonNull String str) {
        return this.f15433a.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> f(@NonNull String str, @NonNull String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.f15433a.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzc.b(bundle));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle g(@NonNull final String str, @NonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object zzgVar;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.i(str) || j(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.f15433a;
        if (AppMeasurement.FIAM_ORIGIN.equals(str)) {
            zzgVar = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else if (!AppMeasurement.CRASH_ORIGIN.equals(str) && !"clx".equals(str)) {
            zzgVar = null;
        } else {
            zzgVar = new zzg(appMeasurementSdk, analyticsConnectorListener);
        }
        if (zzgVar == null) {
            return null;
        }
        this.f15434b.put(str, zzgVar);
        return new AnalyticsConnector.AnalyticsConnectorHandle() { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
        };
    }
}
