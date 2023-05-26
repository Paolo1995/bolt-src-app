package com.clevertap.android.sdk.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.gif.GifDecoder;

/* loaded from: classes.dex */
public class SimpleBitmapProvider implements GifDecoder.BitmapProvider {
    @Override // com.clevertap.android.sdk.gif.GifDecoder.BitmapProvider
    public byte[] a(int i8) {
        return new byte[i8];
    }

    @Override // com.clevertap.android.sdk.gif.GifDecoder.BitmapProvider
    @NonNull
    public Bitmap b(int i8, int i9, Bitmap.Config config) {
        return Bitmap.createBitmap(i8, i9, config);
    }

    @Override // com.clevertap.android.sdk.gif.GifDecoder.BitmapProvider
    public int[] c(int i8) {
        return new int[i8];
    }
}
