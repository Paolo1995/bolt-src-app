package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.ribsshared.information.bottomsheet.BottomSheetInformationBuilder.BottomSheetInformationScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class u0 implements Factory<t0> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<q0> f45240a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ga> f45241b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<v0> f45242c;

    public u0(Provider<q0> provider, Provider<ga> provider2, Provider<v0> provider3) {
        this.f45240a = provider;
        this.f45241b = provider2;
        this.f45242c = provider3;
    }

    public static t0 b(q0 q0Var, ga gaVar, v0 v0Var) {
        return new t0(q0Var, gaVar, v0Var);
    }

    public static u0 c(Provider<q0> provider, Provider<ga> provider2, Provider<v0> provider3) {
        return new u0(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public t0 get() {
        return b(this.f45240a.get(), this.f45241b.get(), this.f45242c.get());
    }
}
