package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AnalyticsDeferredProxy {

    /* renamed from: a  reason: collision with root package name */
    private final Deferred<AnalyticsConnector> f15526a;

    /* renamed from: b  reason: collision with root package name */
    private volatile AnalyticsEventLogger f15527b;

    /* renamed from: c  reason: collision with root package name */
    private volatile BreadcrumbSource f15528c;

    /* renamed from: d  reason: collision with root package name */
    private final List<BreadcrumbHandler> f15529d;

    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred) {
        this(deferred, new DisabledBreadcrumbSource(), new UnavailableAnalyticsEventLogger());
    }

    private void f() {
        this.f15526a.a(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.c
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void a(Provider provider) {
                AnalyticsDeferredProxy.this.i(provider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, Bundle bundle) {
        this.f15527b.a(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(BreadcrumbHandler breadcrumbHandler) {
        synchronized (this) {
            if (this.f15528c instanceof DisabledBreadcrumbSource) {
                this.f15529d.add(breadcrumbHandler);
            }
            this.f15528c.a(breadcrumbHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Provider provider) {
        Logger.f().b("AnalyticsConnector now available.");
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) provider.get();
        CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
        CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
        if (j(analyticsConnector, crashlyticsAnalyticsListener) != null) {
            Logger.f().b("Registered Firebase Analytics listener.");
            BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
            BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, TimeUnit.MILLISECONDS);
            synchronized (this) {
                for (BreadcrumbHandler breadcrumbHandler : this.f15529d) {
                    breadcrumbAnalyticsEventReceiver.a(breadcrumbHandler);
                }
                crashlyticsAnalyticsListener.d(breadcrumbAnalyticsEventReceiver);
                crashlyticsAnalyticsListener.e(blockingAnalyticsEventLogger);
                this.f15528c = breadcrumbAnalyticsEventReceiver;
                this.f15527b = blockingAnalyticsEventLogger;
            }
            return;
        }
        Logger.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle j(@NonNull AnalyticsConnector analyticsConnector, @NonNull CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle g8 = analyticsConnector.g("clx", crashlyticsAnalyticsListener);
        if (g8 == null) {
            Logger.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            g8 = analyticsConnector.g(AppMeasurement.CRASH_ORIGIN, crashlyticsAnalyticsListener);
            if (g8 != null) {
                Logger.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return g8;
    }

    public AnalyticsEventLogger d() {
        return new AnalyticsEventLogger() { // from class: com.google.firebase.crashlytics.b
            @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
            public final void a(String str, Bundle bundle) {
                AnalyticsDeferredProxy.this.g(str, bundle);
            }
        };
    }

    public BreadcrumbSource e() {
        return new BreadcrumbSource() { // from class: com.google.firebase.crashlytics.a
            @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
            public final void a(BreadcrumbHandler breadcrumbHandler) {
                AnalyticsDeferredProxy.this.h(breadcrumbHandler);
            }
        };
    }

    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred, @NonNull BreadcrumbSource breadcrumbSource, @NonNull AnalyticsEventLogger analyticsEventLogger) {
        this.f15526a = deferred;
        this.f15528c = breadcrumbSource;
        this.f15529d = new ArrayList();
        this.f15527b = analyticsEventLogger;
        f();
    }
}
