package com.bumptech.glide.request;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* loaded from: classes.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    @NonNull
    public static RequestOptions q0(@NonNull Class<?> cls) {
        return new RequestOptions().f(cls);
    }

    @NonNull
    public static RequestOptions r0(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().h(diskCacheStrategy);
    }

    @NonNull
    public static RequestOptions s0(@NonNull Key key) {
        return new RequestOptions().i0(key);
    }
}
