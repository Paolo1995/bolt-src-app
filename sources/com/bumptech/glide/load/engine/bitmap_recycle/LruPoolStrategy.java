package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
interface LruPoolStrategy {
    String a(Bitmap bitmap);

    String b(int i8, int i9, Bitmap.Config config);

    void c(Bitmap bitmap);

    Bitmap d(int i8, int i9, Bitmap.Config config);

    int e(Bitmap bitmap);

    Bitmap removeLast();
}
