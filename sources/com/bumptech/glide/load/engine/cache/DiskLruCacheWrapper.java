package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: b  reason: collision with root package name */
    private final File f10241b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10242c;

    /* renamed from: e  reason: collision with root package name */
    private DiskLruCache f10244e;

    /* renamed from: d  reason: collision with root package name */
    private final DiskCacheWriteLocker f10243d = new DiskCacheWriteLocker();

    /* renamed from: a  reason: collision with root package name */
    private final SafeKeyGenerator f10240a = new SafeKeyGenerator();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j8) {
        this.f10241b = file;
        this.f10242c = j8;
    }

    public static DiskCache c(File file, long j8) {
        return new DiskLruCacheWrapper(file, j8);
    }

    private synchronized DiskLruCache d() throws IOException {
        if (this.f10244e == null) {
            this.f10244e = DiskLruCache.Y(this.f10241b, 1, 1, this.f10242c);
        }
        return this.f10244e;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a(Key key, DiskCache.Writer writer) {
        DiskLruCache d8;
        String b8 = this.f10240a.b(key);
        this.f10243d.a(b8);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b8 + " for for Key: " + key);
            }
            try {
                d8 = d();
            } catch (IOException e8) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e8);
                }
            }
            if (d8.O(b8) != null) {
                return;
            }
            DiskLruCache.Editor F = d8.F(b8);
            if (F != null) {
                try {
                    if (writer.a(F.f(0))) {
                        F.e();
                    }
                    F.b();
                    return;
                } catch (Throwable th) {
                    F.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b8);
        } finally {
            this.f10243d.b(b8);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File b(Key key) {
        String b8 = this.f10240a.b(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b8 + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value O = d().O(b8);
            if (O == null) {
                return null;
            }
            return O.a(0);
        } catch (IOException e8) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e8);
            return null;
        }
    }
}
