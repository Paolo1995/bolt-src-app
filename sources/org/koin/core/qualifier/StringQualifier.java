package org.koin.core.qualifier;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringQualifier.kt */
/* loaded from: classes5.dex */
public final class StringQualifier implements Qualifier {

    /* renamed from: a  reason: collision with root package name */
    private final String f52779a;

    public StringQualifier(String value) {
        Intrinsics.f(value, "value");
        this.f52779a = value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StringQualifier) && Intrinsics.a(getValue(), ((StringQualifier) obj).getValue());
    }

    @Override // org.koin.core.qualifier.Qualifier
    public String getValue() {
        return this.f52779a;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue();
    }
}
