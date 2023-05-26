package io.ktor.util;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AttributesJvm.kt */
/* loaded from: classes5.dex */
public final class HashMapAttributes extends AttributesJvmBase {

    /* renamed from: a  reason: collision with root package name */
    private final Map<AttributeKey<?>, Object> f47045a = new HashMap();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.Attributes
    public <T> T g(AttributeKey<T> key, Function0<? extends T> block) {
        Intrinsics.f(key, "key");
        Intrinsics.f(block, "block");
        T t7 = (T) h().get(key);
        if (t7 != null) {
            return t7;
        }
        T invoke = block.invoke();
        T t8 = (T) h().put(key, invoke);
        if (t8 != null) {
            return t8;
        }
        return invoke;
    }

    @Override // io.ktor.util.AttributesJvmBase
    protected Map<AttributeKey<?>, Object> h() {
        return this.f47045a;
    }
}
