package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class Options implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<Option<?>, Object> f9929b = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.g(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i8 = 0; i8 < this.f9929b.size(); i8++) {
            f(this.f9929b.j(i8), this.f9929b.n(i8), messageDigest);
        }
    }

    public <T> T c(@NonNull Option<T> option) {
        if (this.f9929b.containsKey(option)) {
            return (T) this.f9929b.get(option);
        }
        return option.c();
    }

    public void d(@NonNull Options options) {
        this.f9929b.k(options.f9929b);
    }

    @NonNull
    public <T> Options e(@NonNull Option<T> option, @NonNull T t7) {
        this.f9929b.put(option, t7);
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f9929b.equals(((Options) obj).f9929b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f9929b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f9929b + '}';
    }
}
