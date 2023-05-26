package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final Transformation<Bitmap> f10461b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10462c;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z7) {
        this.f10461b = transformation;
        this.f10462c = z7;
    }

    private Resource<Drawable> d(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.f(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<Drawable> a(@NonNull Context context, @NonNull Resource<Drawable> resource, int i8, int i9) {
        BitmapPool f8 = Glide.c(context).f();
        Drawable drawable = resource.get();
        Resource<Bitmap> a8 = DrawableToBitmapConverter.a(f8, drawable, i8, i9);
        if (a8 == null) {
            if (!this.f10462c) {
                return resource;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        Resource<Bitmap> a9 = this.f10461b.a(context, a8, i8, i9);
        if (a9.equals(a8)) {
            a9.c();
            return resource;
        }
        return d(context, a9);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        this.f10461b.b(messageDigest);
    }

    public Transformation<BitmapDrawable> c() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f10461b.equals(((DrawableTransformation) obj).f10461b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f10461b.hashCode();
    }
}
