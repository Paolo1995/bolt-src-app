package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

/* loaded from: classes.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {

    /* renamed from: e  reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f10247e;

    public LruResourceCache(long j8) {
        super(j8);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @SuppressLint({"InlinedApi"})
    public void a(int i8) {
        if (i8 >= 40) {
            b();
        } else if (i8 >= 20 || i8 == 15) {
            m(h() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource c(@NonNull Key key, Resource resource) {
        return (Resource) super.k(key, resource);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource d(@NonNull Key key) {
        return (Resource) super.l(key);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void e(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f10247e = resourceRemovedListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    /* renamed from: n */
    public int i(Resource<?> resource) {
        if (resource == null) {
            return super.i(null);
        }
        return resource.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    /* renamed from: o */
    public void j(@NonNull Key key, Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f10247e;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.a(resource);
        }
    }
}
