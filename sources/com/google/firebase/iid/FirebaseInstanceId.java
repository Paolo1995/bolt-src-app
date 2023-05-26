package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.RequestDeduplicator;
import com.google.firebase.iid.Store;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@Deprecated
/* loaded from: classes3.dex */
public class FirebaseInstanceId {

    /* renamed from: j  reason: collision with root package name */
    private static Store f16278j;
    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")

    /* renamed from: l  reason: collision with root package name */
    static ScheduledExecutorService f16280l;

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ int f16281m = 0;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Executor f16282a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f16283b;

    /* renamed from: c  reason: collision with root package name */
    private final Metadata f16284c;

    /* renamed from: d  reason: collision with root package name */
    private final GmsRpc f16285d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestDeduplicator f16286e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f16287f;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    private boolean f16288g;

    /* renamed from: h  reason: collision with root package name */
    private final List<FirebaseInstanceIdInternal.NewTokenListener> f16289h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f16277i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f16279k = Pattern.compile("\\AA[\\w-]{38}\\z");

    FirebaseInstanceId(FirebaseApp firebaseApp, Metadata metadata, Executor executor, Executor executor2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f16288g = false;
        this.f16289h = new ArrayList();
        if (Metadata.c(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f16278j == null) {
                    f16278j = new Store(firebaseApp.j());
                }
            }
            this.f16283b = firebaseApp;
            this.f16284c = metadata;
            this.f16285d = new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi);
            this.f16282a = executor2;
            this.f16286e = new RequestDeduplicator(executor);
            this.f16287f = firebaseInstallationsApi;
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    private static String A(String str) {
        if (!str.isEmpty() && !str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) && !str.equalsIgnoreCase("gcm")) {
            return str;
        }
        return "*";
    }

    private <T> T b(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e8) {
            Throwable cause = e8.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    B();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e8);
            }
        }
    }

    private static <T> T c(@NonNull Task<T> task) throws InterruptedException {
        Preconditions.checkNotNull(task, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(FirebaseInstanceId$$Lambda$1.f16293f, new OnCompleteListener(countDownLatch) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$2

            /* renamed from: a  reason: collision with root package name */
            private final CountDownLatch f16294a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16294a = countDownLatch;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task2) {
                this.f16294a.countDown();
            }
        });
        countDownLatch.await(DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS, TimeUnit.MILLISECONDS);
        return (T) l(task);
    }

    private static void e(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.m().e(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(firebaseApp.m().c(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(firebaseApp.m().b(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(u(firebaseApp.m().c()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(t(firebaseApp.m().b()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        e(firebaseApp);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp.i(FirebaseInstanceId.class);
        Preconditions.checkNotNull(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    @NonNull
    public static FirebaseInstanceId i() {
        return getInstance(FirebaseApp.k());
    }

    private Task<InstanceIdResult> k(final String str, String str2) {
        final String A = A(str2);
        return Tasks.forResult(null).continueWithTask(this.f16282a, new Continuation(this, str, A) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$0

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f16290a;

            /* renamed from: b  reason: collision with root package name */
            private final String f16291b;

            /* renamed from: c  reason: collision with root package name */
            private final String f16292c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16290a = this;
                this.f16291b = str;
                this.f16292c = A;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task) {
                return this.f16290a.z(this.f16291b, this.f16292c, task);
            }
        });
    }

    private static <T> T l(@NonNull Task<T> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (!task.isCanceled()) {
            if (task.isComplete()) {
                throw new IllegalStateException(task.getException());
            }
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
        throw new CancellationException("Task is already canceled");
    }

    private String m() {
        if ("[DEFAULT]".equals(this.f16283b.l())) {
            return "";
        }
        return this.f16283b.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        if (!Log.isLoggable("FirebaseInstanceId", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseInstanceId", 3))) {
            return false;
        }
        return true;
    }

    static boolean t(@Nonnull String str) {
        return f16279k.matcher(str).matches();
    }

    static boolean u(@Nonnull String str) {
        return str.contains(":");
    }

    synchronized void B() {
        f16278j.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void C(boolean z7) {
        this.f16288g = z7;
    }

    synchronized void D() {
        if (!this.f16288g) {
            E(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void E(long j8) {
        f(new SyncTask(this, Math.min(Math.max(30L, j8 + j8), f16277i)), j8);
        this.f16288g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(Store.Token token) {
        if (token != null && !token.c(this.f16284c.a())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FirebaseInstanceIdInternal.NewTokenListener newTokenListener) {
        this.f16289h.add(newTokenListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() throws IOException {
        return o(Metadata.c(this.f16283b), "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Runnable runnable, long j8) {
        synchronized (FirebaseInstanceId.class) {
            if (f16280l == null) {
                f16280l = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            f16280l.schedule(runnable, j8, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseApp g() {
        return this.f16283b;
    }

    String h() {
        try {
            f16278j.i(this.f16283b.n());
            return (String) c(this.f16287f.getId());
        } catch (InterruptedException e8) {
            throw new IllegalStateException(e8);
        }
    }

    @NonNull
    @Deprecated
    public Task<InstanceIdResult> j() {
        e(this.f16283b);
        return k(Metadata.c(this.f16283b), "*");
    }

    @Deprecated
    public String n() {
        e(this.f16283b);
        Store.Token p8 = p();
        if (F(p8)) {
            D();
        }
        return Store.Token.b(p8);
    }

    @Deprecated
    public String o(@NonNull String str, @NonNull String str2) throws IOException {
        e(this.f16283b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) b(k(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Store.Token p() {
        return q(Metadata.c(this.f16283b), "*");
    }

    @VisibleForTesting
    Store.Token q(String str, String str2) {
        return f16278j.f(m(), str, str2);
    }

    @VisibleForTesting
    public boolean s() {
        return this.f16284c.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task w(String str, String str2, String str3, String str4) throws Exception {
        f16278j.h(m(), str, str2, str4, this.f16284c.a());
        return Tasks.forResult(new InstanceIdResultImpl(str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void x(Store.Token token, InstanceIdResult instanceIdResult) {
        String a8 = instanceIdResult.a();
        if (token == null || !a8.equals(token.f16336a)) {
            for (FirebaseInstanceIdInternal.NewTokenListener newTokenListener : this.f16289h) {
                newTokenListener.a(a8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task y(final String str, final String str2, final String str3, final Store.Token token) {
        return this.f16285d.d(str, str2, str3).onSuccessTask(this.f16282a, new SuccessContinuation(this, str2, str3, str) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$4

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f16300a;

            /* renamed from: b  reason: collision with root package name */
            private final String f16301b;

            /* renamed from: c  reason: collision with root package name */
            private final String f16302c;

            /* renamed from: d  reason: collision with root package name */
            private final String f16303d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16300a = this;
                this.f16301b = str2;
                this.f16302c = str3;
                this.f16303d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task then(Object obj) {
                return this.f16300a.w(this.f16301b, this.f16302c, this.f16303d, (String) obj);
            }
        }).addOnSuccessListener(FirebaseInstanceId$$Lambda$5.f16304f, new OnSuccessListener(this, token) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$6

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f16305a;

            /* renamed from: b  reason: collision with root package name */
            private final Store.Token f16306b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16305a = this;
                this.f16306b = token;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.f16305a.x(this.f16306b, (InstanceIdResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task z(final String str, final String str2, Task task) throws Exception {
        final String h8 = h();
        final Store.Token q8 = q(str, str2);
        if (!F(q8)) {
            return Tasks.forResult(new InstanceIdResultImpl(h8, q8.f16336a));
        }
        return this.f16286e.a(str, str2, new RequestDeduplicator.GetTokenRequest(this, h8, str, str2, q8) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$3

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f16295a;

            /* renamed from: b  reason: collision with root package name */
            private final String f16296b;

            /* renamed from: c  reason: collision with root package name */
            private final String f16297c;

            /* renamed from: d  reason: collision with root package name */
            private final String f16298d;

            /* renamed from: e  reason: collision with root package name */
            private final Store.Token f16299e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16295a = this;
                this.f16296b = h8;
                this.f16297c = str;
                this.f16298d = str2;
                this.f16299e = q8;
            }

            @Override // com.google.firebase.iid.RequestDeduplicator.GetTokenRequest
            public Task start() {
                return this.f16295a.y(this.f16296b, this.f16297c, this.f16298d, this.f16299e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new Metadata(firebaseApp.j()), FirebaseIidExecutors.b(), FirebaseIidExecutors.b(), provider, provider2, firebaseInstallationsApi);
    }
}
