package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class ConfigCacheClient {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, ConfigCacheClient> f17052d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f17053e = ConfigCacheClient$$Lambda$4.a();

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f17054a;

    /* renamed from: b  reason: collision with root package name */
    private final ConfigStorageClient f17055b;

    /* renamed from: c  reason: collision with root package name */
    private Task<ConfigContainer> f17056c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f17064a;

        private AwaitListener() {
            this.f17064a = new CountDownLatch(1);
        }

        public boolean a(long j8, TimeUnit timeUnit) throws InterruptedException {
            return this.f17064a.await(j8, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.f17064a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(@NonNull Exception exc) {
            this.f17064a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            this.f17064a.countDown();
        }
    }

    private ConfigCacheClient(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        this.f17054a = executorService;
        this.f17055b = configStorageClient;
    }

    private static <TResult> TResult a(Task<TResult> task, long j8, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = f17053e;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (awaitListener.a(j8, timeUnit)) {
            if (task.isSuccessful()) {
                return task.getResult();
            }
            throw new ExecutionException(task.getException());
        }
        throw new TimeoutException("Task await timed out.");
    }

    public static synchronized ConfigCacheClient f(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String b8 = configStorageClient.b();
            Map<String, ConfigCacheClient> map = f17052d;
            if (!map.containsKey(b8)) {
                map.put(b8, new ConfigCacheClient(executorService, configStorageClient));
            }
            configCacheClient = map.get(b8);
        }
        return configCacheClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Task h(ConfigCacheClient configCacheClient, boolean z7, ConfigContainer configContainer, Void r32) throws Exception {
        if (z7) {
            configCacheClient.k(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    private synchronized void k(ConfigContainer configContainer) {
        this.f17056c = Tasks.forResult(configContainer);
    }

    public void b() {
        synchronized (this) {
            this.f17056c = Tasks.forResult(null);
        }
        this.f17055b.a();
    }

    public synchronized Task<ConfigContainer> c() {
        Task<ConfigContainer> task = this.f17056c;
        if (task == null || (task.isComplete() && !this.f17056c.isSuccessful())) {
            ExecutorService executorService = this.f17054a;
            ConfigStorageClient configStorageClient = this.f17055b;
            configStorageClient.getClass();
            this.f17056c = Tasks.call(executorService, ConfigCacheClient$$Lambda$3.a(configStorageClient));
        }
        return this.f17056c;
    }

    public ConfigContainer d() {
        return e(5L);
    }

    ConfigContainer e(long j8) {
        synchronized (this) {
            Task<ConfigContainer> task = this.f17056c;
            if (task != null && task.isSuccessful()) {
                return this.f17056c.getResult();
            }
            try {
                return (ConfigContainer) a(c(), j8, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e8) {
                Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e8);
                return null;
            }
        }
    }

    public Task<ConfigContainer> i(ConfigContainer configContainer) {
        return j(configContainer, true);
    }

    public Task<ConfigContainer> j(ConfigContainer configContainer, boolean z7) {
        return Tasks.call(this.f17054a, ConfigCacheClient$$Lambda$1.a(this, configContainer)).onSuccessTask(this.f17054a, ConfigCacheClient$$Lambda$2.a(this, z7, configContainer));
    }
}
