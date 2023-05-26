package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class SimpleResource<T> implements Resource<T> {

    /* renamed from: f  reason: collision with root package name */
    protected final T f10412f;

    public SimpleResource(@NonNull T t7) {
        this.f10412f = (T) Preconditions.d(t7);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<T> d() {
        return (Class<T>) this.f10412f.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        return this.f10412f;
    }
}
