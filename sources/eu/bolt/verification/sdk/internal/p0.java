package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.o0;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.ribsshared.information.bottomsheet.BottomSheetInformationBuilder.BottomSheetInformationScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class p0 implements Factory<w0> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<x0> f44495a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<t0> f44496b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<qj> f44497c;

    public p0(Provider<x0> provider, Provider<t0> provider2, Provider<qj> provider3) {
        this.f44495a = provider;
        this.f44496b = provider2;
        this.f44497c = provider3;
    }

    public static p0 a(Provider<x0> provider, Provider<t0> provider2, Provider<qj> provider3) {
        return new p0(provider, provider2, provider3);
    }

    public static w0 c(x0 x0Var, t0 t0Var, qj qjVar) {
        return (w0) Preconditions.checkNotNullFromProvides(o0.c.a(x0Var, t0Var, qjVar));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public w0 get() {
        return c(this.f44495a.get(), this.f44496b.get(), this.f44497c.get());
    }
}
