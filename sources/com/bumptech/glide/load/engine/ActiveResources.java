package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class ActiveResources {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9976a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f9977b;

    /* renamed from: c  reason: collision with root package name */
    final Map<Key, ResourceWeakReference> f9978c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<EngineResource<?>> f9979d;

    /* renamed from: e  reason: collision with root package name */
    private EngineResource.ResourceListener f9980e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9981f;

    /* renamed from: g  reason: collision with root package name */
    private volatile DequeuedResourceCallback f9982g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface DequeuedResourceCallback {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* renamed from: a  reason: collision with root package name */
        final Key f9986a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f9987b;

        /* renamed from: c  reason: collision with root package name */
        Resource<?> f9988c;

        ResourceWeakReference(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z7) {
            super(engineResource, referenceQueue);
            Resource<?> resource;
            this.f9986a = (Key) Preconditions.d(key);
            if (engineResource.f() && z7) {
                resource = (Resource) Preconditions.d(engineResource.e());
            } else {
                resource = null;
            }
            this.f9988c = resource;
            this.f9987b = engineResource.f();
        }

        void a() {
            this.f9988c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveResources(boolean z7) {
        this(z7, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bumptech.glide.load.engine.ActiveResources.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Key key, EngineResource<?> engineResource) {
        ResourceWeakReference put = this.f9978c.put(key, new ResourceWeakReference(key, engineResource, this.f9979d, this.f9976a));
        if (put != null) {
            put.a();
        }
    }

    void b() {
        while (!this.f9981f) {
            try {
                c((ResourceWeakReference) this.f9979d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.f9982g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(@NonNull ResourceWeakReference resourceWeakReference) {
        Resource<?> resource;
        synchronized (this) {
            this.f9978c.remove(resourceWeakReference.f9986a);
            if (resourceWeakReference.f9987b && (resource = resourceWeakReference.f9988c) != null) {
                this.f9980e.d(resourceWeakReference.f9986a, new EngineResource<>(resource, true, false, resourceWeakReference.f9986a, this.f9980e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(Key key) {
        ResourceWeakReference remove = this.f9978c.remove(key);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized EngineResource<?> e(Key key) {
        ResourceWeakReference resourceWeakReference = this.f9978c.get(key);
        if (resourceWeakReference == null) {
            return null;
        }
        EngineResource<?> engineResource = resourceWeakReference.get();
        if (engineResource == null) {
            c(resourceWeakReference);
        }
        return engineResource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.f9980e = resourceListener;
            }
        }
    }

    ActiveResources(boolean z7, Executor executor) {
        this.f9978c = new HashMap();
        this.f9979d = new ReferenceQueue<>();
        this.f9976a = z7;
        this.f9977b = executor;
        executor.execute(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            @Override // java.lang.Runnable
            public void run() {
                ActiveResources.this.b();
            }
        });
    }
}
