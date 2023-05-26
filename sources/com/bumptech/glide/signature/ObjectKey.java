package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class ObjectKey implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Object f10760b;

    public ObjectKey(@NonNull Object obj) {
        this.f10760b = Preconditions.d(obj);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f10760b.toString().getBytes(Key.f9923a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f10760b.equals(((ObjectKey) obj).f10760b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f10760b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f10760b + '}';
    }
}
