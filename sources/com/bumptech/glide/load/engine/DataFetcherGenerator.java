package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* loaded from: classes.dex */
interface DataFetcherGenerator {

    /* loaded from: classes.dex */
    public interface FetcherReadyCallback {
        void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);

        void c();

        void f(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);
    }

    boolean b();

    void cancel();
}
