package org.koin.dsl;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;

/* compiled from: ScopeDSL.kt */
/* loaded from: classes5.dex */
public final class ScopeDSL {

    /* renamed from: a  reason: collision with root package name */
    private final Qualifier f52807a;

    /* renamed from: b  reason: collision with root package name */
    private final Module f52808b;

    public ScopeDSL(Qualifier scopeQualifier, Module module) {
        Intrinsics.f(scopeQualifier, "scopeQualifier");
        Intrinsics.f(module, "module");
        this.f52807a = scopeQualifier;
        this.f52808b = module;
    }

    public final Module a() {
        return this.f52808b;
    }

    public final Qualifier b() {
        return this.f52807a;
    }
}
