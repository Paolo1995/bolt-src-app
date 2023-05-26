package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class FirebaseMessaging {

    /* renamed from: m  reason: collision with root package name */
    private static final long f16480m = TimeUnit.HOURS.toSeconds(8);
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: n  reason: collision with root package name */
    private static Store f16481n;
    @SuppressLint({"FirebaseUnknownNullness"})

    /* renamed from: o  reason: collision with root package name */
    static TransportFactory f16482o;
    @GuardedBy("FirebaseMessaging.class")

    /* renamed from: p  reason: collision with root package name */
    static ScheduledExecutorService f16483p;

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f16484a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstanceIdInternal f16485b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstallationsApi f16486c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f16487d;

    /* renamed from: e  reason: collision with root package name */
    private final GmsRpc f16488e;

    /* renamed from: f  reason: collision with root package name */
    private final RequestDeduplicator f16489f;

    /* renamed from: g  reason: collision with root package name */
    private final AutoInit f16490g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f16491h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f16492i;

    /* renamed from: j  reason: collision with root package name */
    private final Task<TopicsSubscriber> f16493j;

    /* renamed from: k  reason: collision with root package name */
    private final Metadata f16494k;
    @GuardedBy("this")

    /* renamed from: l  reason: collision with root package name */
    private boolean f16495l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public class AutoInit {

        /* renamed from: a  reason: collision with root package name */
        private final Subscriber f16506a;
        @GuardedBy("this")

        /* renamed from: b  reason: collision with root package name */
        private boolean f16507b;
        @GuardedBy("this")

        /* renamed from: c  reason: collision with root package name */
        private EventHandler<DataCollectionDefaultChange> f16508c;
        @GuardedBy("this")

        /* renamed from: d  reason: collision with root package name */
        private Boolean f16509d;

        AutoInit(Subscriber subscriber) {
            this.f16506a = subscriber;
        }

        private Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context j8 = FirebaseMessaging.this.f16484a.j();
            SharedPreferences sharedPreferences = j8.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = j8.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(j8.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void a() {
            if (this.f16507b) {
                return;
            }
            Boolean d8 = d();
            this.f16509d = d8;
            if (d8 == null) {
                EventHandler<DataCollectionDefaultChange> eventHandler = new EventHandler(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$Lambda$0

                    /* renamed from: a  reason: collision with root package name */
                    private final FirebaseMessaging.AutoInit f16505a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f16505a = this;
                    }

                    @Override // com.google.firebase.events.EventHandler
                    public void a(Event event) {
                        this.f16505a.c(event);
                    }
                };
                this.f16508c = eventHandler;
                this.f16506a.a(DataCollectionDefaultChange.class, eventHandler);
            }
            this.f16507b = true;
        }

        synchronized boolean b() {
            boolean s7;
            a();
            Boolean bool = this.f16509d;
            if (bool != null) {
                s7 = bool.booleanValue();
            } else {
                s7 = FirebaseMessaging.this.f16484a.s();
            }
            return s7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void c(Event event) {
            if (b()) {
                FirebaseMessaging.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory, Subscriber subscriber) {
        this(firebaseApp, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, transportFactory, subscriber, new Metadata(firebaseApp.j()));
    }

    @NonNull
    public static synchronized FirebaseMessaging g() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(FirebaseApp.k());
        }
        return firebaseMessaging;
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.i(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    private String h() {
        if ("[DEFAULT]".equals(this.f16484a.l())) {
            return "";
        }
        return this.f16484a.n();
    }

    public static TransportFactory k() {
        return f16482o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void d(String str) {
        String str2;
        if ("[DEFAULT]".equals(this.f16484a.l())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(this.f16484a.l());
                if (valueOf.length() != 0) {
                    str2 = "Invoking onNewToken for app: ".concat(valueOf);
                } else {
                    str2 = new String("Invoking onNewToken for app: ");
                }
                Log.d("FirebaseMessaging", str2);
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.f16487d).g(intent);
        }
    }

    private synchronized void u() {
        if (!this.f16495l) {
            w(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f16485b;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.a();
        } else if (x(j())) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f16485b;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.b());
            } catch (InterruptedException | ExecutionException e8) {
                throw new IOException(e8);
            }
        }
        Store.Token j8 = j();
        if (!x(j8)) {
            return j8.f16585a;
        }
        final String c8 = Metadata.c(this.f16484a);
        try {
            String str = (String) Tasks.await(this.f16486c.getId().continueWithTask(FcmExecutors.d(), new Continuation(this, c8) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$8

                /* renamed from: a  reason: collision with root package name */
                private final FirebaseMessaging f16501a;

                /* renamed from: b  reason: collision with root package name */
                private final String f16502b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f16501a = this;
                    this.f16502b = c8;
                }

                @Override // com.google.android.gms.tasks.Continuation
                public Object then(Task task) {
                    return this.f16501a.p(this.f16502b, task);
                }
            }));
            f16481n.f(h(), c8, str, this.f16494k.a());
            if (j8 == null || !str.equals(j8.f16585a)) {
                d(str);
            }
            return str;
        } catch (InterruptedException | ExecutionException e9) {
            throw new IOException(e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j8) {
        synchronized (FirebaseMessaging.class) {
            if (f16483p == null) {
                f16483p = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            f16483p.schedule(runnable, j8, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f16487d;
    }

    @NonNull
    public Task<String> i() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f16485b;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.b();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f16491h.execute(new Runnable(this, taskCompletionSource) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$3

            /* renamed from: f  reason: collision with root package name */
            private final FirebaseMessaging f16499f;

            /* renamed from: g  reason: collision with root package name */
            private final TaskCompletionSource f16500g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16499f = this;
                this.f16500g = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16499f.q(this.f16500g);
            }
        });
        return taskCompletionSource.getTask();
    }

    Store.Token j() {
        return f16481n.d(h(), Metadata.c(this.f16484a));
    }

    public boolean m() {
        return this.f16490g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f16494k.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task o(Task task) {
        return this.f16488e.d((String) task.getResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task p(String str, final Task task) throws Exception {
        return this.f16489f.a(str, new RequestDeduplicator.GetTokenRequest(this, task) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$9

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseMessaging f16503a;

            /* renamed from: b  reason: collision with root package name */
            private final Task f16504b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16503a = this;
                this.f16504b = task;
            }

            @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
            public Task start() {
                return this.f16503a.o(this.f16504b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(c());
        } catch (Exception e8) {
            taskCompletionSource.setException(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        if (m()) {
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void s(TopicsSubscriber topicsSubscriber) {
        if (m()) {
            topicsSubscriber.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void t(boolean z7) {
        this.f16495l = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void w(long j8) {
        e(new SyncTask(this, Math.min(Math.max(30L, j8 + j8), f16480m)), j8);
        this.f16495l = true;
    }

    boolean x(Store.Token token) {
        if (token != null && !token.b(this.f16494k.a())) {
            return false;
        }
        return true;
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory, Subscriber subscriber, Metadata metadata) {
        this(firebaseApp, firebaseInstanceIdInternal, firebaseInstallationsApi, transportFactory, subscriber, metadata, new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi), FcmExecutors.e(), FcmExecutors.b());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor executor, Executor executor2) {
        this.f16495l = false;
        f16482o = transportFactory;
        this.f16484a = firebaseApp;
        this.f16485b = firebaseInstanceIdInternal;
        this.f16486c = firebaseInstallationsApi;
        this.f16490g = new AutoInit(subscriber);
        Context j8 = firebaseApp.j();
        this.f16487d = j8;
        this.f16494k = metadata;
        this.f16492i = executor;
        this.f16488e = gmsRpc;
        this.f16489f = new RequestDeduplicator(executor);
        this.f16491h = executor2;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.c(new FirebaseInstanceIdInternal.NewTokenListener(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$0

                /* renamed from: a  reason: collision with root package name */
                private final FirebaseMessaging f16496a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f16496a = this;
                }

                @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
                public void a(String str) {
                    this.f16496a.d(str);
                }
            });
        }
        synchronized (FirebaseMessaging.class) {
            if (f16481n == null) {
                f16481n = new Store(j8);
            }
        }
        executor2.execute(new Runnable(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$1

            /* renamed from: f  reason: collision with root package name */
            private final FirebaseMessaging f16497f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16497f = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16497f.r();
            }
        });
        Task<TopicsSubscriber> d8 = TopicsSubscriber.d(this, firebaseInstallationsApi, metadata, gmsRpc, j8, FcmExecutors.f());
        this.f16493j = d8;
        d8.addOnSuccessListener(FcmExecutors.g(), new OnSuccessListener(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$2

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseMessaging f16498a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16498a = this;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.f16498a.s((TopicsSubscriber) obj);
            }
        });
    }
}
