package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: Type.kt */
/* loaded from: classes5.dex */
public final class TypeInfo {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<?> f47144a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f47145b;

    /* renamed from: c  reason: collision with root package name */
    private final KType f47146c;

    public TypeInfo(KClass<?> type, Type reifiedType, KType kType) {
        Intrinsics.f(type, "type");
        Intrinsics.f(reifiedType, "reifiedType");
        this.f47144a = type;
        this.f47145b = reifiedType;
        this.f47146c = kType;
    }

    public final KType a() {
        return this.f47146c;
    }

    public final KClass<?> b() {
        return this.f47144a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeInfo) {
            TypeInfo typeInfo = (TypeInfo) obj;
            return Intrinsics.a(this.f47144a, typeInfo.f47144a) && Intrinsics.a(this.f47145b, typeInfo.f47145b) && Intrinsics.a(this.f47146c, typeInfo.f47146c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f47144a.hashCode() * 31) + this.f47145b.hashCode()) * 31;
        KType kType = this.f47146c;
        return hashCode + (kType == null ? 0 : kType.hashCode());
    }

    public String toString() {
        return "TypeInfo(type=" + this.f47144a + ", reifiedType=" + this.f47145b + ", kotlinType=" + this.f47146c + ')';
    }
}
