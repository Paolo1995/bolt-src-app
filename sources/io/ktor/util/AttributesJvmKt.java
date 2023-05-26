package io.ktor.util;

/* compiled from: AttributesJvm.kt */
/* loaded from: classes5.dex */
public final class AttributesJvmKt {
    public static final Attributes a(boolean z7) {
        if (z7) {
            return new ConcurrentSafeAttributes();
        }
        return new HashMapAttributes();
    }
}
