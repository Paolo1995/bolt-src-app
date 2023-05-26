package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class t8 implements Factory<s8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ub> f45151a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xg> f45152b;

    public t8(Provider<ub> provider, Provider<xg> provider2) {
        this.f45151a = provider;
        this.f45152b = provider2;
    }

    public static s8 b(ub ubVar, xg xgVar) {
        return new s8(ubVar, xgVar);
    }

    public static t8 c(Provider<ub> provider, Provider<xg> provider2) {
        return new t8(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public s8 get() {
        return b(this.f45151a.get(), this.f45152b.get());
    }
}
