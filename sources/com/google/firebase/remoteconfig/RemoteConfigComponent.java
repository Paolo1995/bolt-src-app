package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@KeepForSdk
/* loaded from: classes3.dex */
public class RemoteConfigComponent {

    /* renamed from: j  reason: collision with root package name */
    private static final Clock f17038j = DefaultClock.getInstance();

    /* renamed from: k  reason: collision with root package name */
    private static final Random f17039k = new Random();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseRemoteConfig> f17040a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17041b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f17042c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseApp f17043d;

    /* renamed from: e  reason: collision with root package name */
    private final FirebaseInstallationsApi f17044e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseABTesting f17045f;

    /* renamed from: g  reason: collision with root package name */
    private final AnalyticsConnector f17046g;

    /* renamed from: h  reason: collision with root package name */
    private final String f17047h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f17048i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector) {
        this(context, Executors.newCachedThreadPool(), firebaseApp, firebaseInstallationsApi, firebaseABTesting, analyticsConnector, true);
    }

    private ConfigCacheClient c(String str, String str2) {
        return ConfigCacheClient.f(Executors.newCachedThreadPool(), ConfigStorageClient.c(this.f17041b, String.format("%s_%s_%s_%s.json", "frc", this.f17047h, str, str2)));
    }

    private ConfigGetParameterHandler g(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.f17042c, configCacheClient, configCacheClient2);
    }

    static ConfigMetadataClient h(Context context, String str, String str2) {
        return new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    private static Personalization i(FirebaseApp firebaseApp, String str, AnalyticsConnector analyticsConnector) {
        if (k(firebaseApp) && str.equals("firebase") && analyticsConnector != null) {
            return new Personalization(analyticsConnector);
        }
        return null;
    }

    private static boolean j(FirebaseApp firebaseApp, String str) {
        if (str.equals("firebase") && k(firebaseApp)) {
            return true;
        }
        return false;
    }

    private static boolean k(FirebaseApp firebaseApp) {
        return firebaseApp.l().equals("[DEFAULT]");
    }

    synchronized FirebaseRemoteConfig a(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        FirebaseABTesting firebaseABTesting2;
        if (!this.f17040a.containsKey(str)) {
            Context context = this.f17041b;
            if (j(firebaseApp, str)) {
                firebaseABTesting2 = firebaseABTesting;
            } else {
                firebaseABTesting2 = null;
            }
            FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(context, firebaseApp, firebaseInstallationsApi, firebaseABTesting2, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
            firebaseRemoteConfig.s();
            this.f17040a.put(str, firebaseRemoteConfig);
        }
        return this.f17040a.get(str);
    }

    @KeepForSdk
    public synchronized FirebaseRemoteConfig b(String str) {
        ConfigCacheClient c8;
        ConfigCacheClient c9;
        ConfigCacheClient c10;
        ConfigMetadataClient h8;
        ConfigGetParameterHandler g8;
        c8 = c(str, "fetch");
        c9 = c(str, "activate");
        c10 = c(str, "defaults");
        h8 = h(this.f17041b, this.f17047h, str);
        g8 = g(c9, c10);
        Personalization i8 = i(this.f17043d, str, this.f17046g);
        if (i8 != null) {
            g8.a(RemoteConfigComponent$$Lambda$4.a(i8));
        }
        return a(this.f17043d, str, this.f17044e, this.f17045f, this.f17042c, c8, c9, c10, e(str, c8, h8), g8, h8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig d() {
        return b("firebase");
    }

    synchronized ConfigFetchHandler e(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        AnalyticsConnector analyticsConnector;
        firebaseInstallationsApi = this.f17044e;
        if (k(this.f17043d)) {
            analyticsConnector = this.f17046g;
        } else {
            analyticsConnector = null;
        }
        return new ConfigFetchHandler(firebaseInstallationsApi, analyticsConnector, this.f17042c, f17038j, f17039k, configCacheClient, f(this.f17043d.m().b(), str, configMetadataClient), configMetadataClient, this.f17048i);
    }

    ConfigFetchHttpClient f(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.f17041b, this.f17043d.m().c(), str, str2, configMetadataClient.b(), configMetadataClient.b());
    }

    protected RemoteConfigComponent(Context context, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, AnalyticsConnector analyticsConnector, boolean z7) {
        this.f17040a = new HashMap();
        this.f17048i = new HashMap();
        this.f17041b = context;
        this.f17042c = executorService;
        this.f17043d = firebaseApp;
        this.f17044e = firebaseInstallationsApi;
        this.f17045f = firebaseABTesting;
        this.f17046g = analyticsConnector;
        this.f17047h = firebaseApp.m().c();
        if (z7) {
            Tasks.call(executorService, RemoteConfigComponent$$Lambda$1.a(this));
        }
    }
}
