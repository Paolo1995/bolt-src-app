package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CrashlyticsController {

    /* renamed from: s  reason: collision with root package name */
    static final FilenameFilter f15600s = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.a
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean I;
            I = CrashlyticsController.I(file, str);
            return I;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Context f15601a;

    /* renamed from: b  reason: collision with root package name */
    private final DataCollectionArbiter f15602b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsFileMarker f15603c;

    /* renamed from: d  reason: collision with root package name */
    private final UserMetadata f15604d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashlyticsBackgroundWorker f15605e;

    /* renamed from: f  reason: collision with root package name */
    private final IdManager f15606f;

    /* renamed from: g  reason: collision with root package name */
    private final FileStore f15607g;

    /* renamed from: h  reason: collision with root package name */
    private final AppData f15608h;

    /* renamed from: i  reason: collision with root package name */
    private final LogFileManager f15609i;

    /* renamed from: j  reason: collision with root package name */
    private final CrashlyticsNativeComponent f15610j;

    /* renamed from: k  reason: collision with root package name */
    private final AnalyticsEventLogger f15611k;

    /* renamed from: l  reason: collision with root package name */
    private final SessionReportingCoordinator f15612l;

    /* renamed from: m  reason: collision with root package name */
    private CrashlyticsUncaughtExceptionHandler f15613m;

    /* renamed from: n  reason: collision with root package name */
    private SettingsProvider f15614n = null;

    /* renamed from: o  reason: collision with root package name */
    final TaskCompletionSource<Boolean> f15615o = new TaskCompletionSource<>();

    /* renamed from: p  reason: collision with root package name */
    final TaskCompletionSource<Boolean> f15616p = new TaskCompletionSource<>();

    /* renamed from: q  reason: collision with root package name */
    final TaskCompletionSource<Void> f15617q = new TaskCompletionSource<>();

    /* renamed from: r  reason: collision with root package name */
    final AtomicBoolean f15618r = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements SuccessContinuation<Boolean, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Task f15630a;

        AnonymousClass4(Task task) {
            this.f15630a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: a */
        public Task<Void> then(final Boolean bool) throws Exception {
            return CrashlyticsController.this.f15605e.i(new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Task<Void> call() throws Exception {
                    if (!bool.booleanValue()) {
                        Logger.f().i("Deleting cached crash reports...");
                        CrashlyticsController.r(CrashlyticsController.this.J());
                        CrashlyticsController.this.f15612l.u();
                        CrashlyticsController.this.f15617q.trySetResult(null);
                        return Tasks.forResult(null);
                    }
                    Logger.f().b("Sending cached crash reports...");
                    CrashlyticsController.this.f15602b.c(bool.booleanValue());
                    final Executor c8 = CrashlyticsController.this.f15605e.c();
                    return AnonymousClass4.this.f15630a.onSuccessTask(c8, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1.1
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        @NonNull
                        /* renamed from: a */
                        public Task<Void> then(Settings settings) throws Exception {
                            if (settings != null) {
                                CrashlyticsController.this.L();
                                CrashlyticsController.this.f15612l.v(c8);
                                CrashlyticsController.this.f15617q.trySetResult(null);
                                return Tasks.forResult(null);
                            }
                            Logger.f().k("Received null app settings at app startup. Cannot send cached reports");
                            return Tasks.forResult(null);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger) {
        this.f15601a = context;
        this.f15605e = crashlyticsBackgroundWorker;
        this.f15606f = idManager;
        this.f15602b = dataCollectionArbiter;
        this.f15607g = fileStore;
        this.f15603c = crashlyticsFileMarker;
        this.f15608h = appData;
        this.f15604d = userMetadata;
        this.f15609i = logFileManager;
        this.f15610j = crashlyticsNativeComponent;
        this.f15611k = analyticsEventLogger;
        this.f15612l = sessionReportingCoordinator;
    }

    private static boolean A() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B() {
        SortedSet<String> n8 = this.f15612l.n();
        if (!n8.isEmpty()) {
            return n8.first();
        }
        return null;
    }

    private static long C() {
        return E(System.currentTimeMillis());
    }

    @NonNull
    static List<NativeSessionFile> D(NativeSessionFileProvider nativeSessionFileProvider, String str, FileStore fileStore, byte[] bArr) {
        File o8 = fileStore.o(str, "user-data");
        File o9 = fileStore.o(str, "keys");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.c()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.f()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.d()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.a()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.e()));
        arrayList.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.b()));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", o8));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", "keys", o9));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long E(long j8) {
        return j8 / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean I(File file, String str) {
        return str.startsWith(".ae");
    }

    private Task<Void> K(final long j8) {
        if (A()) {
            Logger.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        Logger.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.8
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt("fatal", 1);
                bundle.putLong("timestamp", j8);
                CrashlyticsController.this.f15611k.a("_ae", bundle);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> L() {
        ArrayList arrayList = new ArrayList();
        for (File file : J()) {
            try {
                arrayList.add(K(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger f8 = Logger.f();
                f8.k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    private Task<Boolean> Q() {
        if (this.f15602b.d()) {
            Logger.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f15615o.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        Logger.f().b("Automatic data collection is disabled.");
        Logger.f().i("Notifying that unsent reports are available.");
        this.f15615o.trySetResult(Boolean.TRUE);
        Task<TContinuationResult> onSuccessTask = this.f15602b.i().onSuccessTask(new SuccessContinuation<Void, Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.3
            @Override // com.google.android.gms.tasks.SuccessContinuation
            @NonNull
            /* renamed from: a */
            public Task<Boolean> then(Void r12) throws Exception {
                return Tasks.forResult(Boolean.TRUE);
            }
        });
        Logger.f().b("Waiting for send/deleteUnsentReports to be called.");
        return Utils.i(onSuccessTask, this.f15616p.getTask());
    }

    private void R(String str) {
        List<ApplicationExitInfo> historicalProcessExitReasons;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            historicalProcessExitReasons = ((ActivityManager) this.f15601a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            if (historicalProcessExitReasons.size() != 0) {
                this.f15612l.t(str, historicalProcessExitReasons, new LogFileManager(this.f15607g, str), UserMetadata.i(str, this.f15607g, this.f15605e));
                return;
            }
            Logger f8 = Logger.f();
            f8.i("No ApplicationExitInfo available. Session: " + str);
            return;
        }
        Logger f9 = Logger.f();
        f9.i("ANR feature enabled, but device is API " + i8);
    }

    private static StaticSessionData.AppData o(IdManager idManager, AppData appData) {
        return StaticSessionData.AppData.b(idManager.f(), appData.f15563e, appData.f15564f, idManager.a(), DeliveryMechanism.a(appData.f15561c).c(), appData.f15565g);
    }

    private static StaticSessionData.DeviceData p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.c(CommonUtils.l(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.s(), statFs.getBlockCount() * statFs.getBlockSize(), CommonUtils.y(), CommonUtils.m(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static StaticSessionData.OsData q() {
        return StaticSessionData.OsData.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(List<File> list) {
        for (File file : list) {
            file.delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(boolean z7, SettingsProvider settingsProvider) {
        ArrayList arrayList = new ArrayList(this.f15612l.n());
        if (arrayList.size() <= z7) {
            Logger.f().i("No open sessions to be closed.");
            return;
        }
        String str = (String) arrayList.get(z7 ? 1 : 0);
        if (settingsProvider.b().f16158b.f16166b) {
            R(str);
        } else {
            Logger.f().i("ANR feature disabled.");
        }
        if (this.f15610j.d(str)) {
            y(str);
        }
        String str2 = null;
        if (z7 != 0) {
            str2 = (String) arrayList.get(0);
        }
        this.f15612l.i(C(), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        long C = C();
        Logger f8 = Logger.f();
        f8.b("Opening a new session with ID " + str);
        this.f15610j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.i()), C, StaticSessionData.b(o(this.f15606f, this.f15608h), q(), p()));
        this.f15609i.e(str);
        this.f15612l.o(str, C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j8) {
        try {
            FileStore fileStore = this.f15607g;
            if (!fileStore.e(".ae" + j8).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e8) {
            Logger.f().l("Could not create app exception marker file.", e8);
        }
    }

    private void y(String str) {
        Logger f8 = Logger.f();
        f8.i("Finalizing native report for session " + str);
        NativeSessionFileProvider a8 = this.f15610j.a(str);
        File b8 = a8.b();
        if (b8 != null && b8.exists()) {
            long lastModified = b8.lastModified();
            LogFileManager logFileManager = new LogFileManager(this.f15607g, str);
            File i8 = this.f15607g.i(str);
            if (!i8.isDirectory()) {
                Logger.f().k("Couldn't create directory to store native session files, aborting.");
                return;
            }
            w(lastModified);
            List<NativeSessionFile> D = D(a8, str, this.f15607g, logFileManager.b());
            NativeSessionFileGzipper.b(i8, D);
            Logger.f().b("CrashlyticsController#finalizePreviousNativeSession");
            this.f15612l.h(str, D);
            logFileManager.a();
            return;
        }
        Logger f9 = Logger.f();
        f9.k("No minidump data found for session " + str);
    }

    void F(@NonNull SettingsProvider settingsProvider, @NonNull Thread thread, @NonNull Throwable th) {
        G(settingsProvider, thread, th, false);
    }

    synchronized void G(@NonNull final SettingsProvider settingsProvider, @NonNull final Thread thread, @NonNull final Throwable th, final boolean z7) {
        Logger f8 = Logger.f();
        f8.b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            Utils.d(this.f15605e.i(new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Task<Void> call() throws Exception {
                    long E = CrashlyticsController.E(currentTimeMillis);
                    final String B = CrashlyticsController.this.B();
                    if (B == null) {
                        Logger.f().d("Tried to write a fatal exception while no session was open.");
                        return Tasks.forResult(null);
                    }
                    CrashlyticsController.this.f15603c.a();
                    CrashlyticsController.this.f15612l.r(th, thread, B, E);
                    CrashlyticsController.this.w(currentTimeMillis);
                    CrashlyticsController.this.t(settingsProvider);
                    CrashlyticsController.this.v(new CLSUUID(CrashlyticsController.this.f15606f).toString());
                    if (!CrashlyticsController.this.f15602b.d()) {
                        return Tasks.forResult(null);
                    }
                    final Executor c8 = CrashlyticsController.this.f15605e.c();
                    return settingsProvider.a().onSuccessTask(c8, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2.1
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        @NonNull
                        /* renamed from: a */
                        public Task<Void> then(Settings settings) throws Exception {
                            String str = null;
                            if (settings == null) {
                                Logger.f().k("Received null app settings, cannot send reports at crash time.");
                                return Tasks.forResult(null);
                            }
                            Task[] taskArr = new Task[2];
                            taskArr[0] = CrashlyticsController.this.L();
                            SessionReportingCoordinator sessionReportingCoordinator = CrashlyticsController.this.f15612l;
                            Executor executor = c8;
                            if (z7) {
                                str = B;
                            }
                            taskArr[1] = sessionReportingCoordinator.w(executor, str);
                            return Tasks.whenAll(taskArr);
                        }
                    });
                }
            }));
        } catch (TimeoutException unused) {
            Logger.f().d("Cannot send reports. Timed out while fetching settings.");
        } catch (Exception e8) {
            Logger.f().e("Error handling uncaught exception", e8);
        }
    }

    boolean H() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f15613m;
        if (crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.a()) {
            return true;
        }
        return false;
    }

    List<File> J() {
        return this.f15607g.f(f15600s);
    }

    void M(final String str) {
        this.f15605e.h(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                CrashlyticsController.this.v(str);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(String str, String str2) {
        try {
            this.f15604d.l(str, str2);
        } catch (IllegalArgumentException e8) {
            Context context = this.f15601a;
            if (context != null && CommonUtils.w(context)) {
                throw e8;
            }
            Logger.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(String str) {
        this.f15604d.m(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> P(Task<Settings> task) {
        if (!this.f15612l.l()) {
            Logger.f().i("No crash reports are available to be sent.");
            this.f15615o.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        Logger.f().i("Crash reports are available to be sent.");
        return Q().onSuccessTask(new AnonymousClass4(task));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(@NonNull final Thread thread, @NonNull final Throwable th) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f15605e.g(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.6
            @Override // java.lang.Runnable
            public void run() {
                if (!CrashlyticsController.this.H()) {
                    long E = CrashlyticsController.E(currentTimeMillis);
                    String B = CrashlyticsController.this.B();
                    if (B == null) {
                        Logger.f().k("Tried to write a non-fatal exception while no session was open.");
                    } else {
                        CrashlyticsController.this.f15612l.s(th, thread, B, E);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(final long j8, final String str) {
        this.f15605e.h(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                if (!CrashlyticsController.this.H()) {
                    CrashlyticsController.this.f15609i.g(j8, str);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        if (!this.f15603c.c()) {
            String B = B();
            if (B != null && this.f15610j.d(B)) {
                return true;
            }
            return false;
        }
        Logger.f().i("Found previous crash marker.");
        this.f15603c.d();
        return true;
    }

    void t(SettingsProvider settingsProvider) {
        u(false, settingsProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsProvider settingsProvider) {
        this.f15614n = settingsProvider;
        M(str);
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.1
            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener
            public void a(@NonNull SettingsProvider settingsProvider2, @NonNull Thread thread, @NonNull Throwable th) {
                CrashlyticsController.this.F(settingsProvider2, thread, th);
            }
        }, settingsProvider, uncaughtExceptionHandler, this.f15610j);
        this.f15613m = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(SettingsProvider settingsProvider) {
        this.f15605e.b();
        if (H()) {
            Logger.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.f().i("Finalizing previously open sessions.");
        try {
            u(true, settingsProvider);
            Logger.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e8) {
            Logger.f().e("Unable to finalize previously open sessions.", e8);
            return false;
        }
    }
}
