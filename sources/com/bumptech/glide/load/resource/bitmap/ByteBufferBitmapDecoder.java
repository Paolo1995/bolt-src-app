package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f10424a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f10424a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i8, int i9, @NonNull Options options) throws IOException {
        return this.f10424a.f(ByteBufferUtil.f(byteBuffer), i8, i9, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return this.f10424a.q(byteBuffer);
    }
}
