package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Attributes.kt */
/* loaded from: classes5.dex */
public final class AttributeKey<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f46997a;

    public AttributeKey(String name) {
        boolean z7;
        Intrinsics.f(name, "name");
        this.f46997a = name;
        if (name.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return;
        }
        throw new IllegalStateException("Name can't be blank");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.a(Reflection.b(AttributeKey.class), Reflection.b(obj.getClass())) && Intrinsics.a(this.f46997a, ((AttributeKey) obj).f46997a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f46997a.hashCode();
    }

    public String toString() {
        return "AttributeKey: " + this.f46997a;
    }
}
