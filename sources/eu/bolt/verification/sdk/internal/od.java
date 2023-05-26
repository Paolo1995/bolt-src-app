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
public final class od implements Factory<nd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f44453a;

    public od(Provider<xn> provider) {
        this.f44453a = provider;
    }

    public static nd b(xn xnVar) {
        return new nd(xnVar);
    }

    public static od c(Provider<xn> provider) {
        return new od(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public nd get() {
        return b(this.f44453a.get());
    }
}
