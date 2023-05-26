package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import j$.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class CrashlyticsCore {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15647a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f15648b;

    /* renamed from: c  reason: collision with root package name */
    private final DataCollectionArbiter f15649c;

    /* renamed from: f  reason: collision with root package name */
    private CrashlyticsFileMarker f15652f;

    /* renamed from: g  reason: collision with root package name */
    private CrashlyticsFileMarker f15653g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15654h;

    /* renamed from: i  reason: collision with root package name */
    private CrashlyticsController f15655i;

    /* renamed from: j  reason: collision with root package name */
    private final IdManager f15656j;

    /* renamed from: k  reason: collision with root package name */
    private final FileStore f15657k;

    /* renamed from: l  reason: collision with root package name */
    public final BreadcrumbSource f15658l;

    /* renamed from: m  reason: collision with root package name */
    private final AnalyticsEventLogger f15659m;

    /* renamed from: n  reason: collision with root package name */
    private final ExecutorService f15660n;

    /* renamed from: o  reason: collision with root package name */
    private final CrashlyticsBackgroundWorker f15661o;

    /* renamed from: p  reason: collision with root package name */
    private final CrashlyticsNativeComponent f15662p;

    /* renamed from: e  reason: collision with root package name */
    private final long f15651e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    private final OnDemandCounter f15650d = new OnDemandCounter();

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, FileStore fileStore, ExecutorService executorService) {
        this.f15648b = firebaseApp;
        this.f15649c = dataCollectionArbiter;
        this.f15647a = firebaseApp.j();
        this.f15656j = idManager;
        this.f15662p = crashlyticsNativeComponent;
        this.f15658l = breadcrumbSource;
        this.f15659m = analyticsEventLogger;
        this.f15660n = executorService;
        this.f15657k = fileStore;
        this.f15661o = new CrashlyticsBackgroundWorker(executorService);
    }

    private void d() {
        try {
            this.f15654h = Boolean.TRUE.equals((Boolean) Utils.d(this.f15661o.h(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(CrashlyticsCore.this.f15655i.s());
                }
            })));
        } catch (Exception unused) {
            this.f15654h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> f(SettingsProvider settingsProvider) {
        n();
        try {
            this.f15658l.a(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.b
                @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                public final void a(String str) {
                    CrashlyticsCore.this.k(str);
                }
            });
            if (!settingsProvider.b().f16158b.f16165a) {
                Logger.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f15655i.z(settingsProvider)) {
                Logger.f().k("Previous sessions could not be finalized.");
            }
            return this.f15655i.P(settingsProvider.a());
        } catch (Exception e8) {
            Logger.f().e("Crashlytics encountered a problem during asynchronous initialization.", e8);
            return Tasks.forException(e8);
        } finally {
            m();
        }
    }

    private void h(final SettingsProvider settingsProvider) {
        Future<?> submit = this.f15660n.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.2
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsCore.this.f(settingsProvider);
            }
        });
        Logger.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e8) {
            Logger.f().e("Crashlytics was interrupted during initialization.", e8);
        } catch (ExecutionException e9) {
            Logger.f().e("Crashlytics encountered a problem during initialization.", e9);
        } catch (TimeoutException e10) {
            Logger.f().e("Crashlytics timed out during initialization.", e10);
        }
    }

    public static String i() {
        return "18.2.12";
    }

    static boolean j(String str, boolean z7) {
        if (!z7) {
            Logger.f().i("Configured not to require a build ID.");
            return true;
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        } else {
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".     |  | ");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".   \\ |  | /");
            Log.e("FirebaseCrashlytics", ".    \\    /");
            Log.e("FirebaseCrashlytics", ".     \\  /");
            Log.e("FirebaseCrashlytics", ".      \\/");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".      /\\");
            Log.e("FirebaseCrashlytics", ".     /  \\");
            Log.e("FirebaseCrashlytics", ".    /    \\");
            Log.e("FirebaseCrashlytics", ".   / |  | \\");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".");
            return false;
        }
    }

    boolean e() {
        return this.f15652f.c();
    }

    public Task<Void> g(final SettingsProvider settingsProvider) {
        return Utils.e(this.f15660n, new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Task<Void> call() throws Exception {
                return CrashlyticsCore.this.f(settingsProvider);
            }
        });
    }

    public void k(String str) {
        this.f15655i.T(System.currentTimeMillis() - this.f15651e, str);
    }

    public void l(@NonNull Throwable th) {
        this.f15655i.S(Thread.currentThread(), th);
    }

    void m() {
        this.f15661o.h(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    boolean d8 = CrashlyticsCore.this.f15652f.d();
                    if (!d8) {
                        Logger.f().k("Initialization marker file was not properly removed.");
                    }
                    return Boolean.valueOf(d8);
                } catch (Exception e8) {
                    Logger.f().e("Problem encountered deleting Crashlytics initialization marker.", e8);
                    return Boolean.FALSE;
                }
            }
        });
    }

    void n() {
        this.f15661o.b();
        this.f15652f.a();
        Logger.f().i("Initialization marker file was created.");
    }

    public boolean o(AppData appData, SettingsProvider settingsProvider) {
        if (j(appData.f15560b, CommonUtils.k(this.f15647a, "com.crashlytics.RequireBuildId", true))) {
            String clsuuid = new CLSUUID(this.f15656j).toString();
            try {
                this.f15653g = new CrashlyticsFileMarker("crash_marker", this.f15657k);
                this.f15652f = new CrashlyticsFileMarker("initialization_marker", this.f15657k);
                UserMetadata userMetadata = new UserMetadata(clsuuid, this.f15657k, this.f15661o);
                LogFileManager logFileManager = new LogFileManager(this.f15657k);
                this.f15655i = new CrashlyticsController(this.f15647a, this.f15661o, this.f15656j, this.f15649c, this.f15657k, this.f15653g, appData, userMetadata, logFileManager, SessionReportingCoordinator.g(this.f15647a, this.f15656j, this.f15657k, appData, logFileManager, userMetadata, new MiddleOutFallbackStrategy(Spliterator.IMMUTABLE, new RemoveRepeatsStrategy(10)), settingsProvider, this.f15650d), this.f15662p, this.f15659m);
                boolean e8 = e();
                d();
                this.f15655i.x(clsuuid, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider);
                if (e8 && CommonUtils.c(this.f15647a)) {
                    Logger.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    h(settingsProvider);
                    return false;
                }
                Logger.f().b("Successfully configured exception handler.");
                return true;
            } catch (Exception e9) {
                Logger.f().e("Crashlytics was not started due to an exception during initialization", e9);
                this.f15655i = null;
                return false;
            }
        }
        throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    }

    public void p(Boolean bool) {
        this.f15649c.g(bool);
    }

    public void q(String str, String str2) {
        this.f15655i.N(str, str2);
    }

    public void r(String str) {
        this.f15655i.O(str);
    }
}
