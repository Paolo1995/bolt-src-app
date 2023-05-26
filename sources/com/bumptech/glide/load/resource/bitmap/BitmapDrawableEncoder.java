package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* loaded from: classes.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f10416a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceEncoder<Bitmap> f10417b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f10416a = bitmapPool;
        this.f10417b = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy b(@NonNull Options options) {
        return this.f10417b.b(options);
    }

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: c */
    public boolean a(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull Options options) {
        return this.f10417b.a(new BitmapResource(resource.get().getBitmap(), this.f10416a), file, options);
    }
}
