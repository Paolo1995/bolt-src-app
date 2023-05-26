package com.google.android.datatransport;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class Encoding {

    /* renamed from: a  reason: collision with root package name */
    private final String f11854a;

    private Encoding(@NonNull String str) {
        if (str != null) {
            this.f11854a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static Encoding b(@NonNull String str) {
        return new Encoding(str);
    }

    public String a() {
        return this.f11854a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f11854a.equals(((Encoding) obj).f11854a);
    }

    public int hashCode() {
        return this.f11854a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f11854a + "\"}";
    }
}
