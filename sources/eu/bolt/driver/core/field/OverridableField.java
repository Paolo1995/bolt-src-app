package eu.bolt.driver.core.field;

import eu.bolt.driver.core.field.io.ReadWrite;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: OverridableField.kt */
/* loaded from: classes5.dex */
public final class OverridableField<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f40795a;

    /* renamed from: b  reason: collision with root package name */
    private final T f40796b;

    /* renamed from: c  reason: collision with root package name */
    private final ReadWrite<T> f40797c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40798d;

    public OverridableField(String key, T t7, ReadWrite<T> adapter) {
        Intrinsics.f(key, "key");
        Intrinsics.f(adapter, "adapter");
        this.f40795a = key;
        this.f40796b = t7;
        this.f40797c = adapter;
        this.f40798d = "force_" + key;
    }

    public final T a() {
        return this.f40796b;
    }

    public final String b() {
        return this.f40795a;
    }

    public final T c() {
        if (this.f40797c.c(this.f40798d)) {
            return this.f40797c.a(this.f40798d, this.f40796b);
        }
        return this.f40797c.a(this.f40795a, this.f40796b);
    }

    public T d(Object thisRef, KProperty<?> property) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        return c();
    }

    public void e(Object thisRef, KProperty<?> property, T t7) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        this.f40797c.b(this.f40795a, t7);
    }
}
