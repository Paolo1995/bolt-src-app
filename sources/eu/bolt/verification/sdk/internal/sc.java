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
public final class sc implements Factory<rc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f44976a;

    public sc(Provider<xn> provider) {
        this.f44976a = provider;
    }

    public static rc b(xn xnVar) {
        return new rc(xnVar);
    }

    public static sc c(Provider<xn> provider) {
        return new sc(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public rc get() {
        return b(this.f44976a.get());
    }
}
