package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface MemoryCache {

    /* loaded from: classes.dex */
    public interface ResourceRemovedListener {
        void a(@NonNull Resource<?> resource);
    }

    void a(int i8);

    void b();

    Resource<?> c(@NonNull Key key, Resource<?> resource);

    Resource<?> d(@NonNull Key key);

    void e(@NonNull ResourceRemovedListener resourceRemovedListener);
}
