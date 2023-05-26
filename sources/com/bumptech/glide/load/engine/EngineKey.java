package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
class EngineKey implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Object f10128b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10129c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10130d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f10131e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f10132f;

    /* renamed from: g  reason: collision with root package name */
    private final Key f10133g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, Transformation<?>> f10134h;

    /* renamed from: i  reason: collision with root package name */
    private final Options f10135i;

    /* renamed from: j  reason: collision with root package name */
    private int f10136j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineKey(Object obj, Key key, int i8, int i9, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f10128b = Preconditions.d(obj);
        this.f10133g = (Key) Preconditions.e(key, "Signature must not be null");
        this.f10129c = i8;
        this.f10130d = i9;
        this.f10134h = (Map) Preconditions.d(map);
        this.f10131e = (Class) Preconditions.e(cls, "Resource class must not be null");
        this.f10132f = (Class) Preconditions.e(cls2, "Transcode class must not be null");
        this.f10135i = (Options) Preconditions.d(options);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.f10128b.equals(engineKey.f10128b) || !this.f10133g.equals(engineKey.f10133g) || this.f10130d != engineKey.f10130d || this.f10129c != engineKey.f10129c || !this.f10134h.equals(engineKey.f10134h) || !this.f10131e.equals(engineKey.f10131e) || !this.f10132f.equals(engineKey.f10132f) || !this.f10135i.equals(engineKey.f10135i)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f10136j == 0) {
            int hashCode = this.f10128b.hashCode();
            this.f10136j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f10133g.hashCode()) * 31) + this.f10129c) * 31) + this.f10130d;
            this.f10136j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f10134h.hashCode();
            this.f10136j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f10131e.hashCode();
            this.f10136j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f10132f.hashCode();
            this.f10136j = hashCode5;
            this.f10136j = (hashCode5 * 31) + this.f10135i.hashCode();
        }
        return this.f10136j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f10128b + ", width=" + this.f10129c + ", height=" + this.f10130d + ", resourceClass=" + this.f10131e + ", transcodeClass=" + this.f10132f + ", signature=" + this.f10133g + ", hashCode=" + this.f10136j + ", transformations=" + this.f10134h + ", options=" + this.f10135i + '}';
    }
}
