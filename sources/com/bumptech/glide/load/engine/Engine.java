package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f10074i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final Jobs f10075a;

    /* renamed from: b  reason: collision with root package name */
    private final EngineKeyFactory f10076b;

    /* renamed from: c  reason: collision with root package name */
    private final MemoryCache f10077c;

    /* renamed from: d  reason: collision with root package name */
    private final EngineJobFactory f10078d;

    /* renamed from: e  reason: collision with root package name */
    private final ResourceRecycler f10079e;

    /* renamed from: f  reason: collision with root package name */
    private final LazyDiskCacheProvider f10080f;

    /* renamed from: g  reason: collision with root package name */
    private final DecodeJobFactory f10081g;

    /* renamed from: h  reason: collision with root package name */
    private final ActiveResources f10082h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DecodeJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.DiskCacheProvider f10083a;

        /* renamed from: b  reason: collision with root package name */
        final Pools$Pool<DecodeJob<?>> f10084b = FactoryPools.d(150, new FactoryPools.Factory<DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: b */
            public DecodeJob<?> a() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob<>(decodeJobFactory.f10083a, decodeJobFactory.f10084b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f10085c;

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.f10083a = diskCacheProvider;
        }

        <R> DecodeJob<R> a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i8, int i9, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z7, boolean z8, boolean z9, Options options, DecodeJob.Callback<R> callback) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.d(this.f10084b.b());
            int i10 = this.f10085c;
            this.f10085c = i10 + 1;
            return decodeJob.t(glideContext, obj, engineKey, key, i8, i9, cls, cls2, priority, diskCacheStrategy, map, z7, z8, z9, options, callback, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EngineJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final GlideExecutor f10087a;

        /* renamed from: b  reason: collision with root package name */
        final GlideExecutor f10088b;

        /* renamed from: c  reason: collision with root package name */
        final GlideExecutor f10089c;

        /* renamed from: d  reason: collision with root package name */
        final GlideExecutor f10090d;

        /* renamed from: e  reason: collision with root package name */
        final EngineJobListener f10091e;

        /* renamed from: f  reason: collision with root package name */
        final EngineResource.ResourceListener f10092f;

        /* renamed from: g  reason: collision with root package name */
        final Pools$Pool<EngineJob<?>> f10093g = FactoryPools.d(150, new FactoryPools.Factory<EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: b */
            public EngineJob<?> a() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                return new EngineJob<>(engineJobFactory.f10087a, engineJobFactory.f10088b, engineJobFactory.f10089c, engineJobFactory.f10090d, engineJobFactory.f10091e, engineJobFactory.f10092f, engineJobFactory.f10093g);
            }
        });

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.f10087a = glideExecutor;
            this.f10088b = glideExecutor2;
            this.f10089c = glideExecutor3;
            this.f10090d = glideExecutor4;
            this.f10091e = engineJobListener;
            this.f10092f = resourceListener;
        }

        <R> EngineJob<R> a(Key key, boolean z7, boolean z8, boolean z9, boolean z10) {
            return ((EngineJob) Preconditions.d(this.f10093g.b())).l(key, z7, z8, z9, z10);
        }
    }

    /* loaded from: classes.dex */
    private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* renamed from: a  reason: collision with root package name */
        private final DiskCache.Factory f10095a;

        /* renamed from: b  reason: collision with root package name */
        private volatile DiskCache f10096b;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f10095a = factory;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache a() {
            if (this.f10096b == null) {
                synchronized (this) {
                    if (this.f10096b == null) {
                        this.f10096b = this.f10095a.build();
                    }
                    if (this.f10096b == null) {
                        this.f10096b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f10096b;
        }
    }

    /* loaded from: classes.dex */
    public class LoadStatus {

        /* renamed from: a  reason: collision with root package name */
        private final EngineJob<?> f10097a;

        /* renamed from: b  reason: collision with root package name */
        private final ResourceCallback f10098b;

        LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f10098b = resourceCallback;
            this.f10097a = engineJob;
        }

        public void a() {
            synchronized (Engine.this) {
                this.f10097a.r(this.f10098b);
            }
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z7) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z7);
    }

    private EngineResource<?> e(Key key) {
        Resource<?> d8 = this.f10077c.d(key);
        if (d8 == null) {
            return null;
        }
        if (d8 instanceof EngineResource) {
            return (EngineResource) d8;
        }
        return new EngineResource<>(d8, true, true, key, this);
    }

    private EngineResource<?> g(Key key) {
        EngineResource<?> e8 = this.f10082h.e(key);
        if (e8 != null) {
            e8.a();
        }
        return e8;
    }

    private EngineResource<?> h(Key key) {
        EngineResource<?> e8 = e(key);
        if (e8 != null) {
            e8.a();
            this.f10082h.a(key, e8);
        }
        return e8;
    }

    private EngineResource<?> i(EngineKey engineKey, boolean z7, long j8) {
        if (!z7) {
            return null;
        }
        EngineResource<?> g8 = g(engineKey);
        if (g8 != null) {
            if (f10074i) {
                j("Loaded resource from active resources", j8, engineKey);
            }
            return g8;
        }
        EngineResource<?> h8 = h(engineKey);
        if (h8 == null) {
            return null;
        }
        if (f10074i) {
            j("Loaded resource from cache", j8, engineKey);
        }
        return h8;
    }

    private static void j(String str, long j8, Key key) {
        Log.v("Engine", str + " in " + LogTime.a(j8) + "ms, key: " + key);
    }

    private <R> LoadStatus l(GlideContext glideContext, Object obj, Key key, int i8, int i9, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z7, boolean z8, Options options, boolean z9, boolean z10, boolean z11, boolean z12, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j8) {
        EngineJob<?> a8 = this.f10075a.a(engineKey, z12);
        if (a8 != null) {
            a8.a(resourceCallback, executor);
            if (f10074i) {
                j("Added to existing load", j8, engineKey);
            }
            return new LoadStatus(resourceCallback, a8);
        }
        EngineJob<R> a9 = this.f10078d.a(engineKey, z9, z10, z11, z12);
        DecodeJob<R> a10 = this.f10081g.a(glideContext, obj, engineKey, key, i8, i9, cls, cls2, priority, diskCacheStrategy, map, z7, z8, z12, options, a9);
        this.f10075a.c(engineKey, a9);
        a9.a(resourceCallback, executor);
        a9.s(a10);
        if (f10074i) {
            j("Started new load", j8, engineKey);
        }
        return new LoadStatus(resourceCallback, a9);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void a(@NonNull Resource<?> resource) {
        this.f10079e.a(resource, true);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void b(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        if (engineResource != null) {
            if (engineResource.f()) {
                this.f10082h.a(key, engineResource);
            }
        }
        this.f10075a.d(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void c(EngineJob<?> engineJob, Key key) {
        this.f10075a.d(key, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void d(Key key, EngineResource<?> engineResource) {
        this.f10082h.d(key);
        if (engineResource.f()) {
            this.f10077c.c(key, engineResource);
        } else {
            this.f10079e.a(engineResource, false);
        }
    }

    public <R> LoadStatus f(GlideContext glideContext, Object obj, Key key, int i8, int i9, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z7, boolean z8, Options options, boolean z9, boolean z10, boolean z11, boolean z12, ResourceCallback resourceCallback, Executor executor) {
        long b8 = f10074i ? LogTime.b() : 0L;
        EngineKey a8 = this.f10076b.a(obj, key, i8, i9, map, cls, cls2, options);
        synchronized (this) {
            EngineResource<?> i10 = i(a8, z9, b8);
            if (i10 == null) {
                return l(glideContext, obj, key, i8, i9, cls, cls2, priority, diskCacheStrategy, map, z7, z8, options, z9, z10, z11, z12, resourceCallback, executor, a8, b8);
            }
            resourceCallback.c(i10, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    public void k(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z7) {
        this.f10077c = memoryCache;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(factory);
        this.f10080f = lazyDiskCacheProvider;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z7) : activeResources;
        this.f10082h = activeResources2;
        activeResources2.f(this);
        this.f10076b = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f10075a = jobs == null ? new Jobs() : jobs;
        this.f10078d = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.f10081g = decodeJobFactory == null ? new DecodeJobFactory(lazyDiskCacheProvider) : decodeJobFactory;
        this.f10079e = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.e(this);
    }
}
