package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitTranscoder<?> f10581a = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> b() {
        return f10581a;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<Z> a(@NonNull Resource<Z> resource, @NonNull Options options) {
        return resource;
    }
}
