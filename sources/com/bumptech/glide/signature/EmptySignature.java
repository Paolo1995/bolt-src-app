package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class EmptySignature implements Key {

    /* renamed from: b  reason: collision with root package name */
    private static final EmptySignature f10759b = new EmptySignature();

    private EmptySignature() {
    }

    @NonNull
    public static EmptySignature c() {
        return f10759b;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
