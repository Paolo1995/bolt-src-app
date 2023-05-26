package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class FirebaseCrashlytics {

    /* renamed from: a  reason: collision with root package name */
    final CrashlyticsCore f15532a;

    private FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.f15532a = crashlyticsCore;
    }

    @NonNull
    public static FirebaseCrashlytics a() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.k().i(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FirebaseCrashlytics b(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseInstallationsApi firebaseInstallationsApi, @NonNull Deferred<CrashlyticsNativeComponent> deferred, @NonNull Deferred<AnalyticsConnector> deferred2) {
        Context j8 = firebaseApp.j();
        String packageName = j8.getPackageName();
        Logger f8 = Logger.f();
        f8.g("Initializing Firebase Crashlytics " + CrashlyticsCore.i() + " for " + packageName);
        FileStore fileStore = new FileStore(j8);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        IdManager idManager = new IdManager(j8, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred2);
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, analyticsDeferredProxy.e(), analyticsDeferredProxy.d(), fileStore, ExecutorUtils.c("Crashlytics Exception Handler"));
        String c8 = firebaseApp.m().c();
        String n8 = CommonUtils.n(j8);
        Logger f9 = Logger.f();
        f9.b("Mapping file ID is: " + n8);
        try {
            AppData a8 = AppData.a(j8, idManager, c8, n8, new DevelopmentPlatformProvider(j8));
            Logger f10 = Logger.f();
            f10.i("Installer package name is: " + a8.f15561c);
            ExecutorService c9 = ExecutorUtils.c("com.google.firebase.crashlytics.startup");
            final SettingsController l8 = SettingsController.l(j8, c8, idManager, new HttpRequestFactory(), a8.f15563e, a8.f15564f, fileStore, dataCollectionArbiter);
            l8.p(c9).continueWith(c9, new Continuation<Void, Object>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.1
                @Override // com.google.android.gms.tasks.Continuation
                public Object then(@NonNull Task<Void> task) throws Exception {
                    if (!task.isSuccessful()) {
                        Logger.f().e("Error fetching settings.", task.getException());
                        return null;
                    }
                    return null;
                }
            });
            final boolean o8 = crashlyticsCore.o(a8, l8);
            Tasks.call(c9, new Callable<Void>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.2
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() throws Exception {
                    if (o8) {
                        crashlyticsCore.g(l8);
                        return null;
                    }
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e8) {
            Logger.f().e("Error retrieving app package info.", e8);
            return null;
        }
    }

    public void c(@NonNull String str) {
        this.f15532a.k(str);
    }

    public void d(@NonNull Throwable th) {
        if (th == null) {
            Logger.f().k("A null value was passed to recordException. Ignoring.");
        } else {
            this.f15532a.l(th);
        }
    }

    public void e(boolean z7) {
        this.f15532a.p(Boolean.valueOf(z7));
    }

    public void f(@NonNull String str, @NonNull String str2) {
        this.f15532a.q(str, str2);
    }

    public void g(@NonNull String str) {
        this.f15532a.r(str);
    }
}
