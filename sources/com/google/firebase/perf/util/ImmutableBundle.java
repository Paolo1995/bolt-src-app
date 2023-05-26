package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

/* loaded from: classes3.dex */
public final class ImmutableBundle {

    /* renamed from: b  reason: collision with root package name */
    private static final AndroidLogger f16888b = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f16889a;

    public ImmutableBundle() {
        this(new Bundle());
    }

    private Optional<Integer> d(String str) {
        if (!a(str)) {
            return Optional.a();
        }
        try {
            return Optional.b((Integer) this.f16889a.get(str));
        } catch (ClassCastException e8) {
            f16888b.b("Metadata key %s contains type other than int: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public boolean a(String str) {
        if (str != null && this.f16889a.containsKey(str)) {
            return true;
        }
        return false;
    }

    public Optional<Boolean> b(String str) {
        if (!a(str)) {
            return Optional.a();
        }
        try {
            return Optional.b((Boolean) this.f16889a.get(str));
        } catch (ClassCastException e8) {
            f16888b.b("Metadata key %s contains type other than boolean: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public Optional<Float> c(String str) {
        if (!a(str)) {
            return Optional.a();
        }
        try {
            return Optional.b((Float) this.f16889a.get(str));
        } catch (ClassCastException e8) {
            f16888b.b("Metadata key %s contains type other than float: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public Optional<Long> e(String str) {
        Optional<Integer> d8 = d(str);
        if (d8.d()) {
            return Optional.e(Long.valueOf(d8.c().intValue()));
        }
        return Optional.a();
    }

    public ImmutableBundle(Bundle bundle) {
        this.f16889a = (Bundle) bundle.clone();
    }
}
