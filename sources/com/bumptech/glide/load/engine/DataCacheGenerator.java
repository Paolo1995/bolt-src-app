package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: f  reason: collision with root package name */
    private final List<Key> f9989f;

    /* renamed from: g  reason: collision with root package name */
    private final DecodeHelper<?> f9990g;

    /* renamed from: h  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f9991h;

    /* renamed from: i  reason: collision with root package name */
    private int f9992i;

    /* renamed from: j  reason: collision with root package name */
    private Key f9993j;

    /* renamed from: k  reason: collision with root package name */
    private List<ModelLoader<File, ?>> f9994k;

    /* renamed from: l  reason: collision with root package name */
    private int f9995l;

    /* renamed from: m  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f9996m;

    /* renamed from: n  reason: collision with root package name */
    private File f9997n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.c(), decodeHelper, fetcherReadyCallback);
    }

    private boolean a() {
        if (this.f9995l < this.f9994k.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean b() {
        while (true) {
            boolean z7 = false;
            if (this.f9994k != null && a()) {
                this.f9996m = null;
                while (!z7 && a()) {
                    List<ModelLoader<File, ?>> list = this.f9994k;
                    int i8 = this.f9995l;
                    this.f9995l = i8 + 1;
                    this.f9996m = list.get(i8).b(this.f9997n, this.f9990g.s(), this.f9990g.f(), this.f9990g.k());
                    if (this.f9996m != null && this.f9990g.t(this.f9996m.f10337c.a())) {
                        this.f9996m.f10337c.e(this.f9990g.l(), this);
                        z7 = true;
                    }
                }
                return z7;
            }
            int i9 = this.f9992i + 1;
            this.f9992i = i9;
            if (i9 >= this.f9989f.size()) {
                return false;
            }
            Key key = this.f9989f.get(this.f9992i);
            File b8 = this.f9990g.d().b(new DataCacheKey(key, this.f9990g.o()));
            this.f9997n = b8;
            if (b8 != null) {
                this.f9993j = key;
                this.f9994k = this.f9990g.j(b8);
                this.f9995l = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void c(@NonNull Exception exc) {
        this.f9991h.a(this.f9993j, exc, this.f9996m.f10337c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f9996m;
        if (loadData != null) {
            loadData.f10337c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void f(Object obj) {
        this.f9991h.f(this.f9993j, obj, this.f9996m.f10337c, DataSource.DATA_DISK_CACHE, this.f9993j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f9992i = -1;
        this.f9989f = list;
        this.f9990g = decodeHelper;
        this.f9991h = fetcherReadyCallback;
    }
}
