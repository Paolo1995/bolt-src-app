package eu.bolt.chat.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SensitiveString.kt */
/* loaded from: classes5.dex */
public final class SensitiveString implements CharSequence {

    /* renamed from: f  reason: collision with root package name */
    private final String f39702f;

    public SensitiveString(String value) {
        Intrinsics.f(value, "value");
        this.f39702f = value;
    }

    public char a(int i8) {
        return this.f39702f.charAt(i8);
    }

    public int b() {
        return this.f39702f.length();
    }

    public final String c() {
        return this.f39702f;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i8) {
        return a(i8);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return b();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i8, int i9) {
        return this.f39702f.subSequence(i8, i9);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        boolean z7;
        if (this.f39702f.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "***";
        }
        return "";
    }
}
