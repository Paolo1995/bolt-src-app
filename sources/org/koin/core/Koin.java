package org.koin.core;

import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTimeTools;

/* compiled from: Koin.kt */
/* loaded from: classes5.dex */
public final class Koin {

    /* renamed from: a  reason: collision with root package name */
    private final ScopeRegistry f52731a = new ScopeRegistry(this);

    /* renamed from: b  reason: collision with root package name */
    private final InstanceRegistry f52732b = new InstanceRegistry(this);

    /* renamed from: c  reason: collision with root package name */
    private final PropertyRegistry f52733c = new PropertyRegistry(this);

    /* renamed from: d  reason: collision with root package name */
    private Logger f52734d = new EmptyLogger();

    public final void a() {
        KoinPlatformTimeTools koinPlatformTimeTools;
        Logger logger = this.f52734d;
        Level level = Level.DEBUG;
        if (logger.b(level)) {
            logger.a(level, "Eager instances ...");
        }
        long a8 = KoinPlatformTimeTools.f52810a.a();
        this.f52732b.a();
        double doubleValue = ((Number) new Pair(Unit.f50853a, Double.valueOf((koinPlatformTimeTools.a() - a8) / 1000000.0d)).e()).doubleValue();
        Logger logger2 = this.f52734d;
        String str = "Eager instances created in " + doubleValue + " ms";
        if (logger2.b(level)) {
            logger2.a(level, str);
        }
    }

    public final Scope b(String scopeId, Qualifier qualifier, Object obj) {
        Intrinsics.f(scopeId, "scopeId");
        Intrinsics.f(qualifier, "qualifier");
        return this.f52731a.b(scopeId, qualifier, obj);
    }

    public final InstanceRegistry c() {
        return this.f52732b;
    }

    public final Logger d() {
        return this.f52734d;
    }

    public final ScopeRegistry e() {
        return this.f52731a;
    }

    public final void f(List<Module> modules, boolean z7) {
        Intrinsics.f(modules, "modules");
        Set<Module> b8 = ModuleKt.b(modules, null, 2, null);
        this.f52732b.e(b8, z7);
        this.f52731a.f(b8);
    }

    public final void g(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f52734d = logger;
    }
}
