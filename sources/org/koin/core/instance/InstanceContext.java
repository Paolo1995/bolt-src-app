package org.koin.core.instance;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: InstanceContext.kt */
/* loaded from: classes5.dex */
public final class InstanceContext {

    /* renamed from: a  reason: collision with root package name */
    private final Koin f52753a;

    /* renamed from: b  reason: collision with root package name */
    private final Scope f52754b;

    /* renamed from: c  reason: collision with root package name */
    private final ParametersHolder f52755c;

    public InstanceContext(Koin koin, Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.f(koin, "koin");
        Intrinsics.f(scope, "scope");
        this.f52753a = koin;
        this.f52754b = scope;
        this.f52755c = parametersHolder;
    }

    public final Koin a() {
        return this.f52753a;
    }

    public final ParametersHolder b() {
        return this.f52755c;
    }

    public final Scope c() {
        return this.f52754b;
    }

    public /* synthetic */ InstanceContext(Koin koin, Scope scope, ParametersHolder parametersHolder, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(koin, scope, (i8 & 4) != 0 ? null : parametersHolder);
    }
}
