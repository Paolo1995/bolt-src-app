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
public final class i9 implements Factory<h9> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f43516a;

    public i9(Provider<xn> provider) {
        this.f43516a = provider;
    }

    public static h9 b(xn xnVar) {
        return new h9(xnVar);
    }

    public static i9 c(Provider<xn> provider) {
        return new i9(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public h9 get() {
        return b(this.f43516a.get());
    }
}
