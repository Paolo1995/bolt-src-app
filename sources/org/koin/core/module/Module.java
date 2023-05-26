package org.koin.core.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: Module.kt */
/* loaded from: classes5.dex */
public final class Module {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f52771a;

    /* renamed from: b  reason: collision with root package name */
    private final String f52772b;

    /* renamed from: c  reason: collision with root package name */
    private HashSet<SingleInstanceFactory<?>> f52773c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, InstanceFactory<?>> f52774d;

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<Qualifier> f52775e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Module> f52776f;

    public Module() {
        this(false, 1, null);
    }

    public Module(boolean z7) {
        this.f52771a = z7;
        this.f52772b = KoinPlatformTools.f52811a.b();
        this.f52773c = new HashSet<>();
        this.f52774d = new HashMap<>();
        this.f52775e = new HashSet<>();
        this.f52776f = new ArrayList();
    }

    public final HashSet<SingleInstanceFactory<?>> a() {
        return this.f52773c;
    }

    public final List<Module> b() {
        return this.f52776f;
    }

    public final HashMap<String, InstanceFactory<?>> c() {
        return this.f52774d;
    }

    public final HashSet<Qualifier> d() {
        return this.f52775e;
    }

    public final boolean e() {
        return this.f52771a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.a(Reflection.b(Module.class), Reflection.b(obj.getClass())) && Intrinsics.a(this.f52772b, ((Module) obj).f52772b)) {
            return true;
        }
        return false;
    }

    public final void f(Module... module) {
        Intrinsics.f(module, "module");
        CollectionsKt__MutableCollectionsKt.C(this.f52776f, module);
    }

    public final void g(InstanceFactory<?> instanceFactory) {
        Intrinsics.f(instanceFactory, "instanceFactory");
        BeanDefinition<?> c8 = instanceFactory.c();
        i(BeanDefinitionKt.a(c8.c(), c8.d(), c8.e()), instanceFactory);
    }

    public final void h(SingleInstanceFactory<?> instanceFactory) {
        Intrinsics.f(instanceFactory, "instanceFactory");
        this.f52773c.add(instanceFactory);
    }

    public int hashCode() {
        return this.f52772b.hashCode();
    }

    public final void i(String mapping, InstanceFactory<?> factory) {
        Intrinsics.f(mapping, "mapping");
        Intrinsics.f(factory, "factory");
        this.f52774d.put(mapping, factory);
    }

    public /* synthetic */ Module(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7);
    }
}
