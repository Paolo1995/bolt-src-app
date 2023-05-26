package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes.dex */
public interface DataFetcher<T> {

    /* loaded from: classes.dex */
    public interface DataCallback<T> {
        void c(@NonNull Exception exc);

        void f(T t7);
    }

    @NonNull
    Class<T> a();

    void b();

    void cancel();

    @NonNull
    DataSource d();

    void e(@NonNull Priority priority, @NonNull DataCallback<? super T> dataCallback);
}
