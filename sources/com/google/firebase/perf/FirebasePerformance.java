package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class FirebasePerformance {

    /* renamed from: e  reason: collision with root package name */
    private static final AndroidLogger f16647e = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f16648a;

    /* renamed from: b  reason: collision with root package name */
    private final ConfigResolver f16649b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableBundle f16650c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f16651d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider2) {
        this(firebaseApp, provider, firebaseInstallationsApi, provider2, RemoteConfigManager.getInstance(), ConfigResolver.f(), GaugeManager.getInstance());
    }

    private static ImmutableBundle a(Context context) {
        Bundle bundle;
        ImmutableBundle immutableBundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e8) {
            Log.d("isEnabled", "No perf enable meta data found " + e8.getMessage());
            bundle = null;
        }
        if (bundle != null) {
            immutableBundle = new ImmutableBundle(bundle);
        } else {
            immutableBundle = new ImmutableBundle();
        }
        return immutableBundle;
    }

    @NonNull
    public static FirebasePerformance c() {
        return (FirebasePerformance) FirebaseApp.k().i(FirebasePerformance.class);
    }

    @NonNull
    public Map<String, String> b() {
        return new HashMap(this.f16648a);
    }

    @NonNull
    public Trace d(@NonNull String str) {
        return Trace.c(str);
    }

    FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver, GaugeManager gaugeManager) {
        this.f16648a = new ConcurrentHashMap();
        this.f16651d = null;
        if (firebaseApp == null) {
            this.f16651d = Boolean.FALSE;
            this.f16649b = configResolver;
            this.f16650c = new ImmutableBundle(new Bundle());
            return;
        }
        TransportManager.e().l(firebaseApp, firebaseInstallationsApi, provider2);
        Context j8 = firebaseApp.j();
        ImmutableBundle a8 = a(j8);
        this.f16650c = a8;
        remoteConfigManager.setFirebaseRemoteConfigProvider(provider);
        this.f16649b = configResolver;
        configResolver.O(a8);
        configResolver.M(j8);
        gaugeManager.setApplicationContext(j8);
        this.f16651d = configResolver.h();
    }
}
