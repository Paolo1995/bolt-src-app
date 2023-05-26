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
public class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: f  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f10164f;

    /* renamed from: g  reason: collision with root package name */
    private final DecodeHelper<?> f10165g;

    /* renamed from: h  reason: collision with root package name */
    private int f10166h;

    /* renamed from: i  reason: collision with root package name */
    private int f10167i = -1;

    /* renamed from: j  reason: collision with root package name */
    private Key f10168j;

    /* renamed from: k  reason: collision with root package name */
    private List<ModelLoader<File, ?>> f10169k;

    /* renamed from: l  reason: collision with root package name */
    private int f10170l;

    /* renamed from: m  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f10171m;

    /* renamed from: n  reason: collision with root package name */
    private File f10172n;

    /* renamed from: o  reason: collision with root package name */
    private ResourceCacheKey f10173o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f10165g = decodeHelper;
        this.f10164f = fetcherReadyCallback;
    }

    private boolean a() {
        if (this.f10170l < this.f10169k.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean b() {
        List<Key> c8 = this.f10165g.c();
        boolean z7 = false;
        if (c8.isEmpty()) {
            return false;
        }
        List<Class<?>> m8 = this.f10165g.m();
        if (m8.isEmpty()) {
            if (File.class.equals(this.f10165g.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f10165g.i() + " to " + this.f10165g.q());
        }
        while (true) {
            if (this.f10169k != null && a()) {
                this.f10171m = null;
                while (!z7 && a()) {
                    List<ModelLoader<File, ?>> list = this.f10169k;
                    int i8 = this.f10170l;
                    this.f10170l = i8 + 1;
                    this.f10171m = list.get(i8).b(this.f10172n, this.f10165g.s(), this.f10165g.f(), this.f10165g.k());
                    if (this.f10171m != null && this.f10165g.t(this.f10171m.f10337c.a())) {
                        this.f10171m.f10337c.e(this.f10165g.l(), this);
                        z7 = true;
                    }
                }
                return z7;
            }
            int i9 = this.f10167i + 1;
            this.f10167i = i9;
            if (i9 >= m8.size()) {
                int i10 = this.f10166h + 1;
                this.f10166h = i10;
                if (i10 >= c8.size()) {
                    return false;
                }
                this.f10167i = 0;
            }
            Key key = c8.get(this.f10166h);
            Class<?> cls = m8.get(this.f10167i);
            this.f10173o = new ResourceCacheKey(this.f10165g.b(), key, this.f10165g.o(), this.f10165g.s(), this.f10165g.f(), this.f10165g.r(cls), cls, this.f10165g.k());
            File b8 = this.f10165g.d().b(this.f10173o);
            this.f10172n = b8;
            if (b8 != null) {
                this.f10168j = key;
                this.f10169k = this.f10165g.j(b8);
                this.f10170l = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void c(@NonNull Exception exc) {
        this.f10164f.a(this.f10173o, exc, this.f10171m.f10337c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f10171m;
        if (loadData != null) {
            loadData.f10337c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void f(Object obj) {
        this.f10164f.f(this.f10168j, obj, this.f10171m.f10337c, DataSource.RESOURCE_DISK_CACHE, this.f10173o);
    }
}
