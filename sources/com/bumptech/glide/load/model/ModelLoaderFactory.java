package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface ModelLoaderFactory<T, Y> {
    @NonNull
    ModelLoader<T, Y> b(@NonNull MultiModelLoaderFactory multiModelLoaderFactory);
}
