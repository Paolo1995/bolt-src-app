package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory E = new EngineResourceFactory();
    EngineResource<?> A;
    private DecodeJob<R> B;
    private volatile boolean C;
    private boolean D;

    /* renamed from: f  reason: collision with root package name */
    final ResourceCallbacksAndExecutors f10100f;

    /* renamed from: g  reason: collision with root package name */
    private final StateVerifier f10101g;

    /* renamed from: h  reason: collision with root package name */
    private final EngineResource.ResourceListener f10102h;

    /* renamed from: i  reason: collision with root package name */
    private final Pools$Pool<EngineJob<?>> f10103i;

    /* renamed from: j  reason: collision with root package name */
    private final EngineResourceFactory f10104j;

    /* renamed from: k  reason: collision with root package name */
    private final EngineJobListener f10105k;

    /* renamed from: l  reason: collision with root package name */
    private final GlideExecutor f10106l;

    /* renamed from: m  reason: collision with root package name */
    private final GlideExecutor f10107m;

    /* renamed from: n  reason: collision with root package name */
    private final GlideExecutor f10108n;

    /* renamed from: o  reason: collision with root package name */
    private final GlideExecutor f10109o;

    /* renamed from: p  reason: collision with root package name */
    private final AtomicInteger f10110p;

    /* renamed from: q  reason: collision with root package name */
    private Key f10111q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10112r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10113s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10114t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10115u;

    /* renamed from: v  reason: collision with root package name */
    private Resource<?> f10116v;

    /* renamed from: w  reason: collision with root package name */
    DataSource f10117w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10118x;

    /* renamed from: y  reason: collision with root package name */
    GlideException f10119y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10120z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CallLoadFailed implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final ResourceCallback f10121f;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.f10121f = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f10121f.g()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f10100f.d(this.f10121f)) {
                        EngineJob.this.b(this.f10121f);
                    }
                    EngineJob.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CallResourceReady implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final ResourceCallback f10123f;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.f10123f = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f10123f.g()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f10100f.d(this.f10123f)) {
                        EngineJob.this.A.a();
                        EngineJob.this.g(this.f10123f);
                        EngineJob.this.r(this.f10123f);
                    }
                    EngineJob.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> a(Resource<R> resource, boolean z7, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource<>(resource, z7, true, key, resourceListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ResourceCallbackAndExecutor {

        /* renamed from: a  reason: collision with root package name */
        final ResourceCallback f10125a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f10126b;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f10125a = resourceCallback;
            this.f10126b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f10125a.equals(((ResourceCallbackAndExecutor) obj).f10125a);
            }
            return false;
        }

        public int hashCode() {
            return this.f10125a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {

        /* renamed from: f  reason: collision with root package name */
        private final List<ResourceCallbackAndExecutor> f10127f;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor g(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.a());
        }

        void b(ResourceCallback resourceCallback, Executor executor) {
            this.f10127f.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        void clear() {
            this.f10127f.clear();
        }

        boolean d(ResourceCallback resourceCallback) {
            return this.f10127f.contains(g(resourceCallback));
        }

        ResourceCallbacksAndExecutors f() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.f10127f));
        }

        void i(ResourceCallback resourceCallback) {
            this.f10127f.remove(g(resourceCallback));
        }

        boolean isEmpty() {
            return this.f10127f.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.f10127f.iterator();
        }

        int size() {
            return this.f10127f.size();
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.f10127f = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools$Pool<EngineJob<?>> pools$Pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pools$Pool, E);
    }

    private GlideExecutor j() {
        if (this.f10113s) {
            return this.f10108n;
        }
        if (this.f10114t) {
            return this.f10109o;
        }
        return this.f10107m;
    }

    private boolean m() {
        if (!this.f10120z && !this.f10118x && !this.C) {
            return false;
        }
        return true;
    }

    private synchronized void q() {
        if (this.f10111q != null) {
            this.f10100f.clear();
            this.f10111q = null;
            this.A = null;
            this.f10116v = null;
            this.f10120z = false;
            this.C = false;
            this.f10118x = false;
            this.D = false;
            this.B.C(false);
            this.B = null;
            this.f10119y = null;
            this.f10117w = null;
            this.f10103i.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ResourceCallback resourceCallback, Executor executor) {
        this.f10101g.c();
        this.f10100f.b(resourceCallback, executor);
        boolean z7 = true;
        if (this.f10118x) {
            k(1);
            executor.execute(new CallResourceReady(resourceCallback));
        } else if (this.f10120z) {
            k(1);
            executor.execute(new CallLoadFailed(resourceCallback));
        } else {
            if (this.C) {
                z7 = false;
            }
            Preconditions.a(z7, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    void b(ResourceCallback resourceCallback) {
        try {
            resourceCallback.d(this.f10119y);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void c(Resource<R> resource, DataSource dataSource, boolean z7) {
        synchronized (this) {
            this.f10116v = resource;
            this.f10117w = dataSource;
            this.D = z7;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void d(GlideException glideException) {
        synchronized (this) {
            this.f10119y = glideException;
        }
        n();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier e() {
        return this.f10101g;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void f(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    void g(ResourceCallback resourceCallback) {
        try {
            resourceCallback.c(this.A, this.f10117w, this.D);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.C = true;
        this.B.h();
        this.f10105k.c(this, this.f10111q);
    }

    void i() {
        boolean z7;
        EngineResource<?> engineResource;
        synchronized (this) {
            this.f10101g.c();
            Preconditions.a(m(), "Not yet complete!");
            int decrementAndGet = this.f10110p.decrementAndGet();
            if (decrementAndGet >= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.a(z7, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource = this.A;
                q();
            } else {
                engineResource = null;
            }
        }
        if (engineResource != null) {
            engineResource.g();
        }
    }

    synchronized void k(int i8) {
        EngineResource<?> engineResource;
        Preconditions.a(m(), "Not yet complete!");
        if (this.f10110p.getAndAdd(i8) == 0 && (engineResource = this.A) != null) {
            engineResource.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized EngineJob<R> l(Key key, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f10111q = key;
        this.f10112r = z7;
        this.f10113s = z8;
        this.f10114t = z9;
        this.f10115u = z10;
        return this;
    }

    void n() {
        synchronized (this) {
            this.f10101g.c();
            if (this.C) {
                q();
            } else if (!this.f10100f.isEmpty()) {
                if (!this.f10120z) {
                    this.f10120z = true;
                    Key key = this.f10111q;
                    ResourceCallbacksAndExecutors f8 = this.f10100f.f();
                    k(f8.size() + 1);
                    this.f10105k.b(this, key, null);
                    Iterator<ResourceCallbackAndExecutor> it = f8.iterator();
                    while (it.hasNext()) {
                        ResourceCallbackAndExecutor next = it.next();
                        next.f10126b.execute(new CallLoadFailed(next.f10125a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    void o() {
        synchronized (this) {
            this.f10101g.c();
            if (this.C) {
                this.f10116v.c();
                q();
            } else if (!this.f10100f.isEmpty()) {
                if (!this.f10118x) {
                    this.A = this.f10104j.a(this.f10116v, this.f10112r, this.f10111q, this.f10102h);
                    this.f10118x = true;
                    ResourceCallbacksAndExecutors f8 = this.f10100f.f();
                    k(f8.size() + 1);
                    this.f10105k.b(this, this.f10111q, this.A);
                    Iterator<ResourceCallbackAndExecutor> it = f8.iterator();
                    while (it.hasNext()) {
                        ResourceCallbackAndExecutor next = it.next();
                        next.f10126b.execute(new CallResourceReady(next.f10125a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f10115u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(ResourceCallback resourceCallback) {
        boolean z7;
        this.f10101g.c();
        this.f10100f.i(resourceCallback);
        if (this.f10100f.isEmpty()) {
            h();
            if (!this.f10118x && !this.f10120z) {
                z7 = false;
                if (z7 && this.f10110p.get() == 0) {
                    q();
                }
            }
            z7 = true;
            if (z7) {
                q();
            }
        }
    }

    public synchronized void s(DecodeJob<R> decodeJob) {
        GlideExecutor j8;
        this.B = decodeJob;
        if (decodeJob.I()) {
            j8 = this.f10106l;
        } else {
            j8 = j();
        }
        j8.execute(decodeJob);
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools$Pool<EngineJob<?>> pools$Pool, EngineResourceFactory engineResourceFactory) {
        this.f10100f = new ResourceCallbacksAndExecutors();
        this.f10101g = StateVerifier.a();
        this.f10110p = new AtomicInteger();
        this.f10106l = glideExecutor;
        this.f10107m = glideExecutor2;
        this.f10108n = glideExecutor3;
        this.f10109o = glideExecutor4;
        this.f10105k = engineJobListener;
        this.f10102h = resourceListener;
        this.f10103i = pools$Pool;
        this.f10104j = engineResourceFactory;
    }
}
