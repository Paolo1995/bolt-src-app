package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class Optional<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f16890a;

    private Optional() {
        this.f16890a = null;
    }

    public static <T> Optional<T> a() {
        return new Optional<>();
    }

    public static <T> Optional<T> b(T t7) {
        if (t7 == null) {
            return a();
        }
        return e(t7);
    }

    public static <T> Optional<T> e(T t7) {
        return new Optional<>(t7);
    }

    public T c() {
        T t7 = this.f16890a;
        if (t7 != null) {
            return t7;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean d() {
        if (this.f16890a != null) {
            return true;
        }
        return false;
    }

    private Optional(T t7) {
        if (t7 != null) {
            this.f16890a = t7;
            return;
        }
        throw new NullPointerException("value for optional is empty.");
    }
}
