package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f10574a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceTranscoder<Bitmap, byte[]> f10575b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<GifDrawable, byte[]> f10576c;

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f10574a = bitmapPool;
        this.f10575b = resourceTranscoder;
        this.f10576c = resourceTranscoder2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static Resource<GifDrawable> b(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> a(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f10575b.a(BitmapResource.f(((BitmapDrawable) drawable).getBitmap(), this.f10574a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f10576c.a(b(resource), options);
        }
        return null;
    }
}
