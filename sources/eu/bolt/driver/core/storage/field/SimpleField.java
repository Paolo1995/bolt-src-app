package eu.bolt.driver.core.storage.field;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: SimpleField.kt */
/* loaded from: classes5.dex */
public final class SimpleField<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f40956a;

    /* renamed from: b  reason: collision with root package name */
    private final T f40957b;

    /* renamed from: c  reason: collision with root package name */
    private final ReadWrite<T> f40958c;

    public SimpleField(String key, T t7, ReadWrite<T> adapter) {
        Intrinsics.f(key, "key");
        Intrinsics.f(adapter, "adapter");
        this.f40956a = key;
        this.f40957b = t7;
        this.f40958c = adapter;
    }

    public T a(Object thisRef, KProperty<?> property) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        return this.f40958c.a(this.f40956a, this.f40957b);
    }

    public void b(Object thisRef, KProperty<?> property, T t7) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        this.f40958c.b(this.f40956a, t7);
    }
}
