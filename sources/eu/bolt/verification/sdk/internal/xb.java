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
public final class xb implements Factory<wb> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ke> f45642a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xg> f45643b;

    public xb(Provider<ke> provider, Provider<xg> provider2) {
        this.f45642a = provider;
        this.f45643b = provider2;
    }

    public static wb b(ke keVar, xg xgVar) {
        return new wb(keVar, xgVar);
    }

    public static xb c(Provider<ke> provider, Provider<xg> provider2) {
        return new xb(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public wb get() {
        return b(this.f45642a.get(), this.f45643b.get());
    }
}
