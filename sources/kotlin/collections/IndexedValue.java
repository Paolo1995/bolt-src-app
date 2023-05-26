package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndexedValue.kt */
/* loaded from: classes5.dex */
public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f50882a;

    /* renamed from: b  reason: collision with root package name */
    private final T f50883b;

    public IndexedValue(int i8, T t7) {
        this.f50882a = i8;
        this.f50883b = t7;
    }

    public final int a() {
        return this.f50882a;
    }

    public final T b() {
        return this.f50883b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexedValue) {
            IndexedValue indexedValue = (IndexedValue) obj;
            return this.f50882a == indexedValue.f50882a && Intrinsics.a(this.f50883b, indexedValue.f50883b);
        }
        return false;
    }

    public int hashCode() {
        int i8 = this.f50882a * 31;
        T t7 = this.f50883b;
        return i8 + (t7 == null ? 0 : t7.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f50882a + ", value=" + this.f50883b + ')';
    }
}
