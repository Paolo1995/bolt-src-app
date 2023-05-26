package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f10493a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f10494b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclableBufferedInputStream f10495a;

        /* renamed from: b  reason: collision with root package name */
        private final ExceptionPassthroughInputStream f10496b;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
            this.f10495a = recyclableBufferedInputStream;
            this.f10496b = exceptionPassthroughInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException a8 = this.f10496b.a();
            if (a8 != null) {
                if (bitmap != null) {
                    bitmapPool.c(bitmap);
                }
                throw a8;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void b() {
            this.f10495a.c();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f10493a = downsampler;
        this.f10494b = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull InputStream inputStream, int i8, int i9, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z7;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z7 = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f10494b);
            z7 = true;
        }
        ExceptionPassthroughInputStream c8 = ExceptionPassthroughInputStream.c(recyclableBufferedInputStream);
        try {
            return this.f10493a.g(new MarkEnforcingInputStream(c8), i8, i9, options, new UntrustedCallbacks(recyclableBufferedInputStream, c8));
        } finally {
            c8.release();
            if (z7) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.f10493a.p(inputStream);
    }
}
