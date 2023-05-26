package io.ktor.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Attributes.kt */
/* loaded from: classes5.dex */
public final class AttributesKt {
    public static final void a(Attributes attributes, Attributes other) {
        Intrinsics.f(attributes, "<this>");
        Intrinsics.f(other, "other");
        Iterator<T> it = other.c().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            attributes.b(attributeKey, other.a(attributeKey));
        }
    }
}
