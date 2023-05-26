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
public final class m9 implements Factory<l9> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f44163a;

    public m9(Provider<xn> provider) {
        this.f44163a = provider;
    }

    public static l9 b(xn xnVar) {
        return new l9(xnVar);
    }

    public static m9 c(Provider<xn> provider) {
        return new m9(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public l9 get() {
        return b(this.f44163a.get());
    }
}
