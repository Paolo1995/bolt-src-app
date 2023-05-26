package org.koin.core.qualifier;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.ext.KClassExtKt;

/* compiled from: TypeQualifier.kt */
/* loaded from: classes5.dex */
public final class TypeQualifier implements Qualifier {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<?> f52780a;

    /* renamed from: b  reason: collision with root package name */
    private final String f52781b;

    public TypeQualifier(KClass<?> type) {
        Intrinsics.f(type, "type");
        this.f52780a = type;
        this.f52781b = KClassExtKt.a(type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.a(Reflection.b(TypeQualifier.class), Reflection.b(obj.getClass())) && Intrinsics.a(getValue(), ((TypeQualifier) obj).getValue())) {
            return true;
        }
        return false;
    }

    @Override // org.koin.core.qualifier.Qualifier
    public String getValue() {
        return this.f52781b;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "q:'" + getValue() + '\'';
    }
}
