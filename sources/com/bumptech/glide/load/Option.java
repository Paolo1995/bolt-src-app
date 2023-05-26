package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class Option<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final CacheKeyUpdater<Object> f9924e = new CacheKeyUpdater<Object>() { // from class: com.bumptech.glide.load.Option.1
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final T f9925a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheKeyUpdater<T> f9926b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9927c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f9928d;

    /* loaded from: classes.dex */
    public interface CacheKeyUpdater<T> {
        void a(@NonNull byte[] bArr, @NonNull T t7, @NonNull MessageDigest messageDigest);
    }

    private Option(@NonNull String str, T t7, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        this.f9927c = Preconditions.b(str);
        this.f9925a = t7;
        this.f9926b = (CacheKeyUpdater) Preconditions.d(cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> a(@NonNull String str, T t7, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t7, cacheKeyUpdater);
    }

    @NonNull
    private static <T> CacheKeyUpdater<T> b() {
        return (CacheKeyUpdater<T>) f9924e;
    }

    @NonNull
    private byte[] d() {
        if (this.f9928d == null) {
            this.f9928d = this.f9927c.getBytes(Key.f9923a);
        }
        return this.f9928d;
    }

    @NonNull
    public static <T> Option<T> e(@NonNull String str) {
        return new Option<>(str, null, b());
    }

    @NonNull
    public static <T> Option<T> f(@NonNull String str, @NonNull T t7) {
        return new Option<>(str, t7, b());
    }

    public T c() {
        return this.f9925a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f9927c.equals(((Option) obj).f9927c);
        }
        return false;
    }

    public void g(@NonNull T t7, @NonNull MessageDigest messageDigest) {
        this.f9926b.a(d(), t7, messageDigest);
    }

    public int hashCode() {
        return this.f9927c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f9927c + "'}";
    }
}
