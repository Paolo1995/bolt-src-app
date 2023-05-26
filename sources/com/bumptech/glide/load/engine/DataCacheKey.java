package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class DataCacheKey implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Key f9998b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f9999c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.f9998b = key;
        this.f9999c = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        this.f9998b.b(messageDigest);
        this.f9999c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        if (!this.f9998b.equals(dataCacheKey.f9998b) || !this.f9999c.equals(dataCacheKey.f9999c)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f9998b.hashCode() * 31) + this.f9999c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f9998b + ", signature=" + this.f9999c + '}';
    }
}
