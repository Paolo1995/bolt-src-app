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
public final class k9 implements Factory<j9> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f43839a;

    public k9(Provider<xn> provider) {
        this.f43839a = provider;
    }

    public static j9 b(xn xnVar) {
        return new j9(xnVar);
    }

    public static k9 c(Provider<xn> provider) {
        return new k9(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public j9 get() {
        return b(this.f43839a.get());
    }
}
