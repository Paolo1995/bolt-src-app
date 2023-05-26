package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final long f10238a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheDirectoryGetter f10239b;

    /* loaded from: classes.dex */
    public interface CacheDirectoryGetter {
        File a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j8) {
        this.f10238a = j8;
        this.f10239b = cacheDirectoryGetter;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File a8 = this.f10239b.a();
        if (a8 == null) {
            return null;
        }
        if (!a8.isDirectory() && !a8.mkdirs()) {
            return null;
        }
        return DiskLruCacheWrapper.c(a8, this.f10238a);
    }
}
