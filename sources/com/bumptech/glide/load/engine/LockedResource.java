package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: j  reason: collision with root package name */
    private static final Pools$Pool<LockedResource<?>> f10159j = FactoryPools.d(20, new FactoryPools.Factory<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.LockedResource.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: b */
        public LockedResource<?> a() {
            return new LockedResource<>();
        }
    });

    /* renamed from: f  reason: collision with root package name */
    private final StateVerifier f10160f = StateVerifier.a();

    /* renamed from: g  reason: collision with root package name */
    private Resource<Z> f10161g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10162h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10163i;

    LockedResource() {
    }

    private void a(Resource<Z> resource) {
        this.f10163i = false;
        this.f10162h = true;
        this.f10161g = resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <Z> LockedResource<Z> f(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.d(f10159j.b());
        lockedResource.a(resource);
        return lockedResource;
    }

    private void g() {
        this.f10161g = null;
        f10159j.a(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f10161g.b();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void c() {
        this.f10160f.c();
        this.f10163i = true;
        if (!this.f10162h) {
            this.f10161g.c();
            g();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> d() {
        return this.f10161g.d();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier e() {
        return this.f10160f;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.f10161g.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void h() {
        this.f10160f.c();
        if (this.f10162h) {
            this.f10162h = false;
            if (this.f10163i) {
                c();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
