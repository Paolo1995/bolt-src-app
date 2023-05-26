package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class ResourceCacheKey implements Key {

    /* renamed from: j  reason: collision with root package name */
    private static final LruCache<Class<?>, byte[]> f10174j = new LruCache<>(50);

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f10175b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f10176c;

    /* renamed from: d  reason: collision with root package name */
    private final Key f10177d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10178e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10179f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f10180g;

    /* renamed from: h  reason: collision with root package name */
    private final Options f10181h;

    /* renamed from: i  reason: collision with root package name */
    private final Transformation<?> f10182i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i8, int i9, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f10175b = arrayPool;
        this.f10176c = key;
        this.f10177d = key2;
        this.f10178e = i8;
        this.f10179f = i9;
        this.f10182i = transformation;
        this.f10180g = cls;
        this.f10181h = options;
    }

    private byte[] c() {
        LruCache<Class<?>, byte[]> lruCache = f10174j;
        byte[] g8 = lruCache.g(this.f10180g);
        if (g8 == null) {
            byte[] bytes = this.f10180g.getName().getBytes(Key.f9923a);
            lruCache.k(this.f10180g, bytes);
            return bytes;
        }
        return g8;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f10175b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f10178e).putInt(this.f10179f).array();
        this.f10177d.b(messageDigest);
        this.f10176c.b(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f10182i;
        if (transformation != null) {
            transformation.b(messageDigest);
        }
        this.f10181h.b(messageDigest);
        messageDigest.update(c());
        this.f10175b.put(bArr);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        if (this.f10179f != resourceCacheKey.f10179f || this.f10178e != resourceCacheKey.f10178e || !Util.d(this.f10182i, resourceCacheKey.f10182i) || !this.f10180g.equals(resourceCacheKey.f10180g) || !this.f10176c.equals(resourceCacheKey.f10176c) || !this.f10177d.equals(resourceCacheKey.f10177d) || !this.f10181h.equals(resourceCacheKey.f10181h)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = (((((this.f10176c.hashCode() * 31) + this.f10177d.hashCode()) * 31) + this.f10178e) * 31) + this.f10179f;
        Transformation<?> transformation = this.f10182i;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f10180g.hashCode()) * 31) + this.f10181h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f10176c + ", signature=" + this.f10177d + ", width=" + this.f10178e + ", height=" + this.f10179f + ", decodedResourceClass=" + this.f10180g + ", transformation='" + this.f10182i + "', options=" + this.f10181h + '}';
    }
}
