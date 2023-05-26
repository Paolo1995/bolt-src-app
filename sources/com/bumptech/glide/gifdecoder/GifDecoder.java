package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface GifDecoder {

    /* loaded from: classes.dex */
    public interface BitmapProvider {
        @NonNull
        byte[] a(int i8);

        @NonNull
        Bitmap b(int i8, int i9, @NonNull Bitmap.Config config);

        @NonNull
        int[] c(int i8);

        void d(@NonNull Bitmap bitmap);

        void e(@NonNull byte[] bArr);

        void f(@NonNull int[] iArr);
    }

    void a();

    int b();

    void c(@NonNull Bitmap.Config config);

    void clear();

    int d();

    void e();

    int f();

    int g();

    @NonNull
    ByteBuffer getData();

    Bitmap getNextFrame();
}
