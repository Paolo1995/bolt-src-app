package org.koin.core.registry;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: ScopeRegistry.kt */
/* loaded from: classes5.dex */
public final class ScopeRegistry {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f52787e = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private static final StringQualifier f52788f = QualifierKt.a("_root_");

    /* renamed from: a  reason: collision with root package name */
    private final Koin f52789a;

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<Qualifier> f52790b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Scope> f52791c;

    /* renamed from: d  reason: collision with root package name */
    private final Scope f52792d;

    /* compiled from: ScopeRegistry.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StringQualifier a() {
            return ScopeRegistry.f52788f;
        }
    }

    public ScopeRegistry(Koin _koin) {
        Intrinsics.f(_koin, "_koin");
        this.f52789a = _koin;
        HashSet<Qualifier> hashSet = new HashSet<>();
        this.f52790b = hashSet;
        Map<String, Scope> e8 = KoinPlatformTools.f52811a.e();
        this.f52791c = e8;
        Scope scope = new Scope(f52788f, "_root_", true, _koin);
        this.f52792d = scope;
        hashSet.add(scope.j());
        e8.put(scope.h(), scope);
    }

    private final void e(Module module) {
        this.f52790b.addAll(module.d());
    }

    public final Scope b(String scopeId, Qualifier qualifier, Object obj) {
        Intrinsics.f(scopeId, "scopeId");
        Intrinsics.f(qualifier, "qualifier");
        Logger d8 = this.f52789a.d();
        String str = "|- (+) Scope - id:'" + scopeId + "' q:" + qualifier;
        Level level = Level.DEBUG;
        if (d8.b(level)) {
            d8.a(level, str);
        }
        if (!this.f52790b.contains(qualifier)) {
            Logger d9 = this.f52789a.d();
            String str2 = "| Scope '" + qualifier + "' not defined. Creating it ...";
            Level level2 = Level.WARNING;
            if (d9.b(level2)) {
                d9.a(level2, str2);
            }
            this.f52790b.add(qualifier);
        }
        if (!this.f52791c.containsKey(scopeId)) {
            Scope scope = new Scope(qualifier, scopeId, false, this.f52789a, 4, null);
            if (obj != null) {
                scope.q(obj);
            }
            scope.n(this.f52792d);
            this.f52791c.put(scopeId, scope);
            return scope;
        }
        throw new ScopeAlreadyCreatedException("Scope with id '" + scopeId + "' is already created");
    }

    public final void c(Scope scope) {
        Intrinsics.f(scope, "scope");
        this.f52789a.c().c(scope);
        this.f52791c.remove(scope.h());
    }

    public final Scope d() {
        return this.f52792d;
    }

    public final void f(Set<Module> modules) {
        Intrinsics.f(modules, "modules");
        for (Module module : modules) {
            e(module);
        }
    }
}
