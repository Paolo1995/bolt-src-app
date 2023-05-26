package io.ktor.util;

import io.ktor.util.Attributes;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributesJvm.kt */
/* loaded from: classes5.dex */
abstract class AttributesJvmBase implements Attributes {
    @Override // io.ktor.util.Attributes
    public <T> T a(AttributeKey<T> attributeKey) {
        return (T) Attributes.DefaultImpls.a(this, attributeKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.Attributes
    public final <T> void b(AttributeKey<T> key, T value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        h().put(key, value);
    }

    @Override // io.ktor.util.Attributes
    public final List<AttributeKey<?>> c() {
        List<AttributeKey<?>> H0;
        H0 = CollectionsKt___CollectionsKt.H0(h().keySet());
        return H0;
    }

    @Override // io.ktor.util.Attributes
    public final <T> void d(AttributeKey<T> key) {
        Intrinsics.f(key, "key");
        h().remove(key);
    }

    @Override // io.ktor.util.Attributes
    public final boolean e(AttributeKey<?> key) {
        Intrinsics.f(key, "key");
        return h().containsKey(key);
    }

    @Override // io.ktor.util.Attributes
    public final <T> T f(AttributeKey<T> key) {
        Intrinsics.f(key, "key");
        return (T) h().get(key);
    }

    protected abstract Map<AttributeKey<?>, Object> h();
}
