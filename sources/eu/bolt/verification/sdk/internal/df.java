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
public final class df implements Factory<cf> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<c0> f42640a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xg> f42641b;

    public df(Provider<c0> provider, Provider<xg> provider2) {
        this.f42640a = provider;
        this.f42641b = provider2;
    }

    public static cf b(c0 c0Var, xg xgVar) {
        return new cf(c0Var, xgVar);
    }

    public static df c(Provider<c0> provider, Provider<xg> provider2) {
        return new df(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public cf get() {
        return b(this.f42640a.get(), this.f42641b.get());
    }
}
