package org.koin.core.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.instance.InstanceContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: InstanceRegistry.kt */
/* loaded from: classes5.dex */
public final class InstanceRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final Koin f52782a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, InstanceFactory<?>> f52783b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<SingleInstanceFactory<?>> f52784c;

    public InstanceRegistry(Koin _koin) {
        Intrinsics.f(_koin, "_koin");
        this.f52782a = _koin;
        this.f52783b = KoinPlatformTools.f52811a.e();
        this.f52784c = new HashSet<>();
    }

    private final void b(HashSet<SingleInstanceFactory<?>> hashSet) {
        if (!hashSet.isEmpty()) {
            Koin koin = this.f52782a;
            InstanceContext instanceContext = new InstanceContext(koin, koin.e().d(), null, 4, null);
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                ((SingleInstanceFactory) it.next()).b(instanceContext);
            }
        }
    }

    private final void d(Module module, boolean z7) {
        for (Map.Entry<String, InstanceFactory<?>> entry : module.c().entrySet()) {
            i(this, z7, entry.getKey(), entry.getValue(), false, 8, null);
        }
    }

    public static /* synthetic */ void i(InstanceRegistry instanceRegistry, boolean z7, String str, InstanceFactory instanceFactory, boolean z8, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z8 = true;
        }
        instanceRegistry.h(z7, str, instanceFactory, z8);
    }

    public final void a() {
        b(this.f52784c);
        this.f52784c.clear();
    }

    public final void c(Scope scope) {
        Intrinsics.f(scope, "scope");
        Collection<InstanceFactory<?>> values = this.f52783b.values();
        ArrayList<ScopedInstanceFactory> arrayList = new ArrayList();
        for (Object obj : values) {
            if (obj instanceof ScopedInstanceFactory) {
                arrayList.add(obj);
            }
        }
        for (ScopedInstanceFactory scopedInstanceFactory : arrayList) {
            scopedInstanceFactory.e(scope);
        }
    }

    public final void e(Set<Module> modules, boolean z7) {
        Intrinsics.f(modules, "modules");
        for (Module module : modules) {
            d(module, z7);
            this.f52784c.addAll(module.a());
        }
    }

    public final InstanceFactory<?> f(KClass<?> clazz, Qualifier qualifier, Qualifier scopeQualifier) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(scopeQualifier, "scopeQualifier");
        return this.f52783b.get(BeanDefinitionKt.a(clazz, qualifier, scopeQualifier));
    }

    public final <T> T g(Qualifier qualifier, KClass<?> clazz, Qualifier scopeQualifier, InstanceContext instanceContext) {
        Object obj;
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(scopeQualifier, "scopeQualifier");
        Intrinsics.f(instanceContext, "instanceContext");
        InstanceFactory<?> f8 = f(clazz, qualifier, scopeQualifier);
        if (f8 != null) {
            obj = f8.b(instanceContext);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    public final void h(boolean z7, String mapping, InstanceFactory<?> factory, boolean z8) {
        Intrinsics.f(mapping, "mapping");
        Intrinsics.f(factory, "factory");
        if (this.f52783b.containsKey(mapping)) {
            if (!z7) {
                ModuleKt.c(factory, mapping);
            } else if (z8) {
                Logger d8 = this.f52782a.d();
                String str = "(+) override index '" + mapping + "' -> '" + factory.c() + '\'';
                Level level = Level.WARNING;
                if (d8.b(level)) {
                    d8.a(level, str);
                }
            }
        }
        Logger d9 = this.f52782a.d();
        String str2 = "(+) index '" + mapping + "' -> '" + factory.c() + '\'';
        Level level2 = Level.DEBUG;
        if (d9.b(level2)) {
            d9.a(level2, str2);
        }
        this.f52783b.put(mapping, factory);
    }

    public final int j() {
        return this.f52783b.size();
    }
}
