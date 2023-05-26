package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public final Resource<Bitmap> a(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i8, int i9) {
        if (Util.t(i8, i9)) {
            BitmapPool f8 = Glide.c(context).f();
            Bitmap bitmap = resource.get();
            if (i8 == Integer.MIN_VALUE) {
                i8 = bitmap.getWidth();
            }
            if (i9 == Integer.MIN_VALUE) {
                i9 = bitmap.getHeight();
            }
            Bitmap c8 = c(f8, bitmap, i8, i9);
            if (!bitmap.equals(c8)) {
                return BitmapResource.f(c8, f8);
            }
            return resource;
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i8 + " or height: " + i9 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8, int i9);
}
