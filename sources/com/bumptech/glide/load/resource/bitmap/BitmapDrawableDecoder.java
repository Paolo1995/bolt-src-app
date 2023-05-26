package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

/* loaded from: classes.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final ResourceDecoder<DataType, Bitmap> f10414a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f10415b;

    public BitmapDrawableDecoder(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f10415b = (Resources) Preconditions.d(resources);
        this.f10414a = (ResourceDecoder) Preconditions.d(resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(@NonNull DataType datatype, @NonNull Options options) throws IOException {
        return this.f10414a.a(datatype, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<BitmapDrawable> b(@NonNull DataType datatype, int i8, int i9, @NonNull Options options) throws IOException {
        return LazyBitmapDrawableResource.f(this.f10415b, this.f10414a.b(datatype, i8, i9, options));
    }
}
