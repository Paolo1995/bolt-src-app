package eu.bolt.driver.core.field;

import eu.bolt.driver.core.field.io.ReadWrite;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: SimpleField.kt */
/* loaded from: classes5.dex */
public final class SimpleField<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f40799a;

    /* renamed from: b  reason: collision with root package name */
    private final T f40800b;

    /* renamed from: c  reason: collision with root package name */
    private final ReadWrite<T> f40801c;

    public SimpleField(String key, T t7, ReadWrite<T> adapter) {
        Intrinsics.f(key, "key");
        Intrinsics.f(adapter, "adapter");
        this.f40799a = key;
        this.f40800b = t7;
        this.f40801c = adapter;
    }

    public T a(Object thisRef, KProperty<?> property) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        return this.f40801c.a(this.f40799a, this.f40800b);
    }

    public void b(Object thisRef, KProperty<?> property, T t7) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        this.f40801c.b(this.f40799a, t7);
    }
}
