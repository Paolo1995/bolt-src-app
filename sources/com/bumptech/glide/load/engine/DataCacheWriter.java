package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    private final Encoder<DataType> f10000a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f10001b;

    /* renamed from: c  reason: collision with root package name */
    private final Options f10002c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f10000a = encoder;
        this.f10001b = datatype;
        this.f10002c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean a(@NonNull File file) {
        return this.f10000a.a(this.f10001b, file, this.f10002c);
    }
}
