package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f10484a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f10484a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i8, int i9, @NonNull Options options) throws IOException {
        return this.f10484a.d(parcelFileDescriptor, i8, i9, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull Options options) {
        return this.f10484a.o(parcelFileDescriptor);
    }
}
