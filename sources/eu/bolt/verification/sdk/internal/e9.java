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
public final class e9 implements Factory<d9> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f42751a;

    public e9(Provider<xn> provider) {
        this.f42751a = provider;
    }

    public static d9 b(xn xnVar) {
        return new d9(xnVar);
    }

    public static e9 c(Provider<xn> provider) {
        return new e9(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public d9 get() {
        return b(this.f42751a.get());
    }
}
