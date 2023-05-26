package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: f  reason: collision with root package name */
    private final DecodeHelper<?> f10185f;

    /* renamed from: g  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f10186g;

    /* renamed from: h  reason: collision with root package name */
    private int f10187h;

    /* renamed from: i  reason: collision with root package name */
    private DataCacheGenerator f10188i;

    /* renamed from: j  reason: collision with root package name */
    private Object f10189j;

    /* renamed from: k  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f10190k;

    /* renamed from: l  reason: collision with root package name */
    private DataCacheKey f10191l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f10185f = decodeHelper;
        this.f10186g = fetcherReadyCallback;
    }

    private void d(Object obj) {
        long b8 = LogTime.b();
        try {
            Encoder<X> p8 = this.f10185f.p(obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(p8, obj, this.f10185f.k());
            this.f10191l = new DataCacheKey(this.f10190k.f10335a, this.f10185f.o());
            this.f10185f.d().a(this.f10191l, dataCacheWriter);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f10191l + ", data: " + obj + ", encoder: " + p8 + ", duration: " + LogTime.a(b8));
            }
            this.f10190k.f10337c.b();
            this.f10188i = new DataCacheGenerator(Collections.singletonList(this.f10190k.f10335a), this.f10185f, this);
        } catch (Throwable th) {
            this.f10190k.f10337c.b();
            throw th;
        }
    }

    private boolean e() {
        if (this.f10187h < this.f10185f.g().size()) {
            return true;
        }
        return false;
    }

    private void j(final ModelLoader.LoadData<?> loadData) {
        this.f10190k.f10337c.e(this.f10185f.l(), new DataFetcher.DataCallback<Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void c(@NonNull Exception exc) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.i(loadData, exc);
                }
            }

            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void f(Object obj) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.h(loadData, obj);
                }
            }
        });
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f10186g.a(key, exc, dataFetcher, this.f10190k.f10337c.d());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean b() {
        Object obj = this.f10189j;
        if (obj != null) {
            this.f10189j = null;
            d(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.f10188i;
        if (dataCacheGenerator != null && dataCacheGenerator.b()) {
            return true;
        }
        this.f10188i = null;
        this.f10190k = null;
        boolean z7 = false;
        while (!z7 && e()) {
            List<ModelLoader.LoadData<?>> g8 = this.f10185f.g();
            int i8 = this.f10187h;
            this.f10187h = i8 + 1;
            this.f10190k = g8.get(i8);
            if (this.f10190k != null && (this.f10185f.e().c(this.f10190k.f10337c.d()) || this.f10185f.t(this.f10190k.f10337c.a()))) {
                j(this.f10190k);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f10190k;
        if (loadData != null) {
            loadData.f10337c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void f(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f10186g.f(key, obj, dataFetcher, this.f10190k.f10337c.d(), key);
    }

    boolean g(ModelLoader.LoadData<?> loadData) {
        ModelLoader.LoadData<?> loadData2 = this.f10190k;
        if (loadData2 != null && loadData2 == loadData) {
            return true;
        }
        return false;
    }

    void h(ModelLoader.LoadData<?> loadData, Object obj) {
        DiskCacheStrategy e8 = this.f10185f.e();
        if (obj != null && e8.c(loadData.f10337c.d())) {
            this.f10189j = obj;
            this.f10186g.c();
            return;
        }
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f10186g;
        Key key = loadData.f10335a;
        DataFetcher<?> dataFetcher = loadData.f10337c;
        fetcherReadyCallback.f(key, obj, dataFetcher, dataFetcher.d(), this.f10191l);
    }

    void i(ModelLoader.LoadData<?> loadData, @NonNull Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f10186g;
        DataCacheKey dataCacheKey = this.f10191l;
        DataFetcher<?> dataFetcher = loadData.f10337c;
        fetcherReadyCallback.a(dataCacheKey, exc, dataFetcher, dataFetcher.d());
    }
}
