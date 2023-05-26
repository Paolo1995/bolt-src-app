package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class LottieResult<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f8958a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f8959b;

    public LottieResult(V v7) {
        this.f8958a = v7;
        this.f8959b = null;
    }

    public Throwable a() {
        return this.f8959b;
    }

    public V b() {
        return this.f8958a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (b() != null && b().equals(lottieResult.b())) {
            return true;
        }
        if (a() == null || lottieResult.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public LottieResult(Throwable th) {
        this.f8959b = th;
        this.f8958a = null;
    }
}
