package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class TopicsSubscriber {

    /* renamed from: j  reason: collision with root package name */
    private static final long f16601j = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    private final Context f16602a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f16603b;

    /* renamed from: c  reason: collision with root package name */
    private final GmsRpc f16604c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseMessaging f16605d;

    /* renamed from: e  reason: collision with root package name */
    private final FirebaseInstallationsApi f16606e;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f16608g;

    /* renamed from: i  reason: collision with root package name */
    private final TopicsStore f16610i;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f16607f = new ArrayMap();

    /* renamed from: h  reason: collision with root package name */
    private boolean f16609h = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, FirebaseInstallationsApi firebaseInstallationsApi, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f16605d = firebaseMessaging;
        this.f16606e = firebaseInstallationsApi;
        this.f16603b = metadata;
        this.f16610i = topicsStore;
        this.f16604c = gmsRpc;
        this.f16602a = context;
        this.f16608g = scheduledExecutorService;
    }

    private static <T> T a(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e8) {
            e = e8;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e9) {
            Throwable cause = e9.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e9);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e10) {
            e = e10;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void b(String str) throws IOException {
        a(this.f16604c.j((String) a(this.f16606e.getId()), this.f16605d.c(), str));
    }

    private void c(String str) throws IOException {
        a(this.f16604c.k((String) a(this.f16606e.getId()), this.f16605d.c(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task<TopicsSubscriber> d(final FirebaseMessaging firebaseMessaging, final FirebaseInstallationsApi firebaseInstallationsApi, final Metadata metadata, final GmsRpc gmsRpc, final Context context, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable(context, scheduledExecutorService, firebaseMessaging, firebaseInstallationsApi, metadata, gmsRpc) { // from class: com.google.firebase.messaging.TopicsSubscriber$$Lambda$0

            /* renamed from: f  reason: collision with root package name */
            private final Context f16611f;

            /* renamed from: g  reason: collision with root package name */
            private final ScheduledExecutorService f16612g;

            /* renamed from: h  reason: collision with root package name */
            private final FirebaseMessaging f16613h;

            /* renamed from: i  reason: collision with root package name */
            private final FirebaseInstallationsApi f16614i;

            /* renamed from: j  reason: collision with root package name */
            private final Metadata f16615j;

            /* renamed from: k  reason: collision with root package name */
            private final GmsRpc f16616k;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16611f = context;
                this.f16612g = scheduledExecutorService;
                this.f16613h = firebaseMessaging;
                this.f16614i = firebaseInstallationsApi;
                this.f16615j = metadata;
                this.f16616k = gmsRpc;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return TopicsSubscriber.h(this.f16611f, this.f16612g, this.f16613h, this.f16614i, this.f16615j, this.f16616k);
            }
        });
    }

    static boolean f() {
        if (!Log.isLoggable("FirebaseMessaging", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ TopicsSubscriber h(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, FirebaseInstallationsApi firebaseInstallationsApi, Metadata metadata, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging, firebaseInstallationsApi, metadata, TopicsStore.a(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private void i(TopicOperation topicOperation) {
        synchronized (this.f16607f) {
            String e8 = topicOperation.e();
            if (!this.f16607f.containsKey(e8)) {
                return;
            }
            ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.f16607f.get(e8);
            TaskCompletionSource<Void> poll = arrayDeque.poll();
            if (poll != null) {
                poll.setResult(null);
            }
            if (arrayDeque.isEmpty()) {
                this.f16607f.remove(e8);
            }
        }
    }

    private void m() {
        if (!g()) {
            p(0L);
        }
    }

    boolean e() {
        if (this.f16610i.b() != null) {
            return true;
        }
        return false;
    }

    synchronized boolean g() {
        return this.f16609h;
    }

    boolean j(TopicOperation topicOperation) throws IOException {
        char c8;
        try {
            String b8 = topicOperation.b();
            int hashCode = b8.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85 && b8.equals("U")) {
                    c8 = 1;
                }
                c8 = 65535;
            } else {
                if (b8.equals("S")) {
                    c8 = 0;
                }
                c8 = 65535;
            }
            if (c8 != 0) {
                if (c8 != 1) {
                    if (f()) {
                        String valueOf = String.valueOf(topicOperation);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 24);
                        sb.append("Unknown topic operation");
                        sb.append(valueOf);
                        sb.append(".");
                        Log.d("FirebaseMessaging", sb.toString());
                    }
                } else {
                    c(topicOperation.c());
                    if (f()) {
                        String c9 = topicOperation.c();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c9).length() + 35);
                        sb2.append("Unsubscribe from topic: ");
                        sb2.append(c9);
                        sb2.append(" succeeded.");
                        Log.d("FirebaseMessaging", sb2.toString());
                    }
                }
            } else {
                b(topicOperation.c());
                if (f()) {
                    String c10 = topicOperation.c();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(c10).length() + 31);
                    sb3.append("Subscribe to topic: ");
                    sb3.append(c10);
                    sb3.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb3.toString());
                }
            }
            return true;
        } catch (IOException e8) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e8.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e8.getMessage())) {
                if (e8.getMessage() == null) {
                    Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                }
                throw e8;
            }
            String message = e8.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
            sb4.append("Topic operation failed: ");
            sb4.append(message);
            sb4.append(". Will retry Topic operation.");
            Log.e("FirebaseMessaging", sb4.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable, long j8) {
        this.f16608g.schedule(runnable, j8, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void l(boolean z7) {
        this.f16609h = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (e()) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (f() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean o() throws java.io.IOException {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.f16610i     // Catch: java.lang.Throwable -> L2b
            com.google.firebase.messaging.TopicOperation r0 = r0.b()     // Catch: java.lang.Throwable -> L2b
            if (r0 != 0) goto L19
            boolean r0 = f()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L16
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L2b
        L16:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            r0 = 1
            return r0
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r1 = r2.j(r0)
            if (r1 != 0) goto L22
            r0 = 0
            return r0
        L22:
            com.google.firebase.messaging.TopicsStore r1 = r2.f16610i
            r1.d(r0)
            r2.i(r0)
            goto L0
        L2b:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.o():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(long j8) {
        k(new TopicsSyncTask(this, this.f16602a, this.f16603b, Math.min(Math.max(30L, j8 + j8), f16601j)), j8);
        l(true);
    }
}
