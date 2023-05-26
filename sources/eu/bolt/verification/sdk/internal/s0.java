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
public final class s0 implements Factory<r0> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<x0> f44923a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<jc> f44924b;

    public s0(Provider<x0> provider, Provider<jc> provider2) {
        this.f44923a = provider;
        this.f44924b = provider2;
    }

    public static r0 b(x0 x0Var, jc jcVar) {
        return new r0(x0Var, jcVar);
    }

    public static s0 c(Provider<x0> provider, Provider<jc> provider2) {
        return new s0(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public r0 get() {
        return b(this.f44923a.get(), this.f44924b.get());
    }
}
