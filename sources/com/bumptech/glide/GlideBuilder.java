package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class GlideBuilder {

    /* renamed from: c  reason: collision with root package name */
    private Engine f9741c;

    /* renamed from: d  reason: collision with root package name */
    private BitmapPool f9742d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayPool f9743e;

    /* renamed from: f  reason: collision with root package name */
    private MemoryCache f9744f;

    /* renamed from: g  reason: collision with root package name */
    private GlideExecutor f9745g;

    /* renamed from: h  reason: collision with root package name */
    private GlideExecutor f9746h;

    /* renamed from: i  reason: collision with root package name */
    private DiskCache.Factory f9747i;

    /* renamed from: j  reason: collision with root package name */
    private MemorySizeCalculator f9748j;

    /* renamed from: k  reason: collision with root package name */
    private ConnectivityMonitorFactory f9749k;

    /* renamed from: n  reason: collision with root package name */
    private RequestManagerRetriever.RequestManagerFactory f9752n;

    /* renamed from: o  reason: collision with root package name */
    private GlideExecutor f9753o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9754p;

    /* renamed from: q  reason: collision with root package name */
    private List<RequestListener<Object>> f9755q;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f9739a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private final GlideExperiments.Builder f9740b = new GlideExperiments.Builder();

    /* renamed from: l  reason: collision with root package name */
    private int f9750l = 4;

    /* renamed from: m  reason: collision with root package name */
    private Glide.RequestOptionsFactory f9751m = new Glide.RequestOptionsFactory() { // from class: com.bumptech.glide.GlideBuilder.1
        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        @NonNull
        public RequestOptions build() {
            return new RequestOptions();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class EnableImageDecoderForBitmaps {
        EnableImageDecoderForBitmaps() {
        }
    }

    /* loaded from: classes.dex */
    public static final class LogRequestOrigins {
    }

    /* loaded from: classes.dex */
    public static final class WaitForFramesAfterTrimMemory {
        private WaitForFramesAfterTrimMemory() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Glide a(@NonNull Context context) {
        if (this.f9745g == null) {
            this.f9745g = GlideExecutor.g();
        }
        if (this.f9746h == null) {
            this.f9746h = GlideExecutor.e();
        }
        if (this.f9753o == null) {
            this.f9753o = GlideExecutor.c();
        }
        if (this.f9748j == null) {
            this.f9748j = new MemorySizeCalculator.Builder(context).a();
        }
        if (this.f9749k == null) {
            this.f9749k = new DefaultConnectivityMonitorFactory();
        }
        if (this.f9742d == null) {
            int b8 = this.f9748j.b();
            if (b8 > 0) {
                this.f9742d = new LruBitmapPool(b8);
            } else {
                this.f9742d = new BitmapPoolAdapter();
            }
        }
        if (this.f9743e == null) {
            this.f9743e = new LruArrayPool(this.f9748j.a());
        }
        if (this.f9744f == null) {
            this.f9744f = new LruResourceCache(this.f9748j.d());
        }
        if (this.f9747i == null) {
            this.f9747i = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f9741c == null) {
            this.f9741c = new Engine(this.f9744f, this.f9747i, this.f9746h, this.f9745g, GlideExecutor.h(), this.f9753o, this.f9754p);
        }
        List<RequestListener<Object>> list = this.f9755q;
        if (list == null) {
            this.f9755q = Collections.emptyList();
        } else {
            this.f9755q = Collections.unmodifiableList(list);
        }
        GlideExperiments b9 = this.f9740b.b();
        return new Glide(context, this.f9741c, this.f9744f, this.f9742d, this.f9743e, new RequestManagerRetriever(this.f9752n, b9), this.f9749k, this.f9750l, this.f9751m, this.f9739a, this.f9755q, b9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f9752n = requestManagerFactory;
    }
}
