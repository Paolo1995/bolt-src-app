package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10137f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f10138g;

    /* renamed from: h  reason: collision with root package name */
    private final Resource<Z> f10139h;

    /* renamed from: i  reason: collision with root package name */
    private final ResourceListener f10140i;

    /* renamed from: j  reason: collision with root package name */
    private final Key f10141j;

    /* renamed from: k  reason: collision with root package name */
    private int f10142k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10143l;

    /* loaded from: classes.dex */
    interface ResourceListener {
        void d(Key key, EngineResource<?> engineResource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource(Resource<Z> resource, boolean z7, boolean z8, Key key, ResourceListener resourceListener) {
        this.f10139h = (Resource) Preconditions.d(resource);
        this.f10137f = z7;
        this.f10138g = z8;
        this.f10141j = key;
        this.f10140i = (ResourceListener) Preconditions.d(resourceListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.f10143l) {
            this.f10142k++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f10139h.b();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void c() {
        if (this.f10142k <= 0) {
            if (!this.f10143l) {
                this.f10143l = true;
                if (this.f10138g) {
                    this.f10139h.c();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> d() {
        return this.f10139h.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource<Z> e() {
        return this.f10139h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f10137f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        boolean z7;
        synchronized (this) {
            int i8 = this.f10142k;
            if (i8 > 0) {
                z7 = true;
                int i9 = i8 - 1;
                this.f10142k = i9;
                if (i9 != 0) {
                    z7 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z7) {
            this.f10140i.d(this.f10141j, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.f10139h.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f10137f + ", listener=" + this.f10140i + ", key=" + this.f10141j + ", acquired=" + this.f10142k + ", isRecycled=" + this.f10143l + ", resource=" + this.f10139h + '}';
    }
}
