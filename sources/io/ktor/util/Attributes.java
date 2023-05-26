package io.ktor.util;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attributes.kt */
/* loaded from: classes5.dex */
public interface Attributes {

    /* compiled from: Attributes.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <T> T a(Attributes attributes, AttributeKey<T> key) {
            Intrinsics.f(key, "key");
            T t7 = (T) attributes.f(key);
            if (t7 != null) {
                return t7;
            }
            throw new IllegalStateException("No instance for key " + key);
        }
    }

    <T> T a(AttributeKey<T> attributeKey);

    <T> void b(AttributeKey<T> attributeKey, T t7);

    List<AttributeKey<?>> c();

    <T> void d(AttributeKey<T> attributeKey);

    boolean e(AttributeKey<?> attributeKey);

    <T> T f(AttributeKey<T> attributeKey);

    <T> T g(AttributeKey<T> attributeKey, Function0<? extends T> function0);
}
