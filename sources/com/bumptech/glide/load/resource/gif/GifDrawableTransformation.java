package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {

    /* renamed from: b  reason: collision with root package name */
    private final Transformation<Bitmap> f10540b;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f10540b = (Transformation) Preconditions.d(transformation);
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<GifDrawable> a(@NonNull Context context, @NonNull Resource<GifDrawable> resource, int i8, int i9) {
        GifDrawable gifDrawable = resource.get();
        Resource<Bitmap> bitmapResource = new BitmapResource(gifDrawable.e(), Glide.c(context).f());
        Resource<Bitmap> a8 = this.f10540b.a(context, bitmapResource, i8, i9);
        if (!bitmapResource.equals(a8)) {
            bitmapResource.c();
        }
        gifDrawable.m(this.f10540b, a8.get());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        this.f10540b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.f10540b.equals(((GifDrawableTransformation) obj).f10540b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f10540b.hashCode();
    }
}
