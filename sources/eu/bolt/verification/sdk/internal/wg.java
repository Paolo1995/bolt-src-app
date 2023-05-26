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
public final class wg implements Factory<vg> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<kb> f45551a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xg> f45552b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<db> f45553c;

    public wg(Provider<kb> provider, Provider<xg> provider2, Provider<db> provider3) {
        this.f45551a = provider;
        this.f45552b = provider2;
        this.f45553c = provider3;
    }

    public static vg b(kb kbVar, xg xgVar, db dbVar) {
        return new vg(kbVar, xgVar, dbVar);
    }

    public static wg c(Provider<kb> provider, Provider<xg> provider2, Provider<db> provider3) {
        return new wg(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public vg get() {
        return b(this.f45551a.get(), this.f45552b.get(), this.f45553c.get());
    }
}
