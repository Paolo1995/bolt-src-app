package org.koin.core.definition;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.module.Module;

/* compiled from: KoinDefinition.kt */
/* loaded from: classes5.dex */
public final class KoinDefinition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Module f52751a;

    /* renamed from: b  reason: collision with root package name */
    private final InstanceFactory<R> f52752b;

    public KoinDefinition(Module module, InstanceFactory<R> factory) {
        Intrinsics.f(module, "module");
        Intrinsics.f(factory, "factory");
        this.f52751a = module;
        this.f52752b = factory;
    }

    public final InstanceFactory<R> a() {
        return this.f52752b;
    }

    public final Module b() {
        return this.f52751a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KoinDefinition) {
            KoinDefinition koinDefinition = (KoinDefinition) obj;
            return Intrinsics.a(this.f52751a, koinDefinition.f52751a) && Intrinsics.a(this.f52752b, koinDefinition.f52752b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f52751a.hashCode() * 31) + this.f52752b.hashCode();
    }

    public String toString() {
        return "KoinDefinition(module=" + this.f52751a + ", factory=" + this.f52752b + ')';
    }
}
