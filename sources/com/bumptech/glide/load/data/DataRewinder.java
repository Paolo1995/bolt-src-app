package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes.dex */
public interface DataRewinder<T> {

    /* loaded from: classes.dex */
    public interface Factory<T> {
        @NonNull
        Class<T> a();

        @NonNull
        DataRewinder<T> b(@NonNull T t7);
    }

    @NonNull
    T a() throws IOException;

    void b();
}
