package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface BitmapPool {
    void a(int i8);

    void b();

    void c(Bitmap bitmap);

    @NonNull
    Bitmap d(int i8, int i9, Bitmap.Config config);

    @NonNull
    Bitmap e(int i8, int i9, Bitmap.Config config);
}
