package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f10422f;

    /* renamed from: g  reason: collision with root package name */
    private final BitmapPool f10423g;

    public BitmapResource(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        this.f10422f = (Bitmap) Preconditions.e(bitmap, "Bitmap must not be null");
        this.f10423g = (BitmapPool) Preconditions.e(bitmapPool, "BitmapPool must not be null");
    }

    public static BitmapResource f(Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void a() {
        this.f10422f.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return Util.h(this.f10422f);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        this.f10423g.c(this.f10422f);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: e */
    public Bitmap get() {
        return this.f10422f;
    }
}
