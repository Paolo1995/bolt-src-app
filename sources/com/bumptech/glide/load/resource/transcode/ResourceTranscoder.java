package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface ResourceTranscoder<Z, R> {
    Resource<R> a(@NonNull Resource<Z> resource, @NonNull Options options);
}
