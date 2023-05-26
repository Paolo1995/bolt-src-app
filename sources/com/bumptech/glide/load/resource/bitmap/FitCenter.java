package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class FitCenter extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10463b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(Key.f9923a);

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f10463b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8, int i9) {
        return TransformationUtils.f(bitmapPool, bitmap, i8, i9);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1572326941;
    }
}
