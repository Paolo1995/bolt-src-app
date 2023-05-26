package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: f  reason: collision with root package name */
    private final Resources f10482f;

    /* renamed from: g  reason: collision with root package name */
    private final Resource<Bitmap> f10483g;

    private LazyBitmapDrawableResource(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        this.f10482f = (Resources) Preconditions.d(resources);
        this.f10483g = (Resource) Preconditions.d(resource);
    }

    public static Resource<BitmapDrawable> f(@NonNull Resources resources, Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void a() {
        Resource<Bitmap> resource = this.f10483g;
        if (resource instanceof Initializable) {
            ((Initializable) resource).a();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f10483g.b();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        this.f10483g.c();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: e */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f10482f, this.f10483g.get());
    }
}
