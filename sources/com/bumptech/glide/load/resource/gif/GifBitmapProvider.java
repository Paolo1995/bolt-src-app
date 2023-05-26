package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f10526a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f10527b;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f10526a = bitmapPool;
        this.f10527b = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public byte[] a(int i8) {
        ArrayPool arrayPool = this.f10527b;
        if (arrayPool == null) {
            return new byte[i8];
        }
        return (byte[]) arrayPool.c(i8, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public Bitmap b(int i8, int i9, @NonNull Bitmap.Config config) {
        return this.f10526a.e(i8, i9, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    @NonNull
    public int[] c(int i8) {
        ArrayPool arrayPool = this.f10527b;
        if (arrayPool == null) {
            return new int[i8];
        }
        return (int[]) arrayPool.c(i8, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void d(@NonNull Bitmap bitmap) {
        this.f10526a.c(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void e(@NonNull byte[] bArr) {
        ArrayPool arrayPool = this.f10527b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void f(@NonNull int[] iArr) {
        ArrayPool arrayPool = this.f10527b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(iArr);
    }
}
