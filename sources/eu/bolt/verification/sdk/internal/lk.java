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
public final class lk implements Factory<kk> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xg> f44090a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<t9> f44091b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bc> f44092c;

    public lk(Provider<xg> provider, Provider<t9> provider2, Provider<bc> provider3) {
        this.f44090a = provider;
        this.f44091b = provider2;
        this.f44092c = provider3;
    }

    public static kk b(xg xgVar, t9 t9Var, bc bcVar) {
        return new kk(xgVar, t9Var, bcVar);
    }

    public static lk c(Provider<xg> provider, Provider<t9> provider2, Provider<bc> provider3) {
        return new lk(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public kk get() {
        return b(this.f44090a.get(), this.f44091b.get(), this.f44092c.get());
    }
}
