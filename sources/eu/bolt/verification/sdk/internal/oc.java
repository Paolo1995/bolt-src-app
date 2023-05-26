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
public final class oc implements Factory<nc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f44452a;

    public oc(Provider<xn> provider) {
        this.f44452a = provider;
    }

    public static nc b(xn xnVar) {
        return new nc(xnVar);
    }

    public static oc c(Provider<xn> provider) {
        return new oc(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public nc get() {
        return b(this.f44452a.get());
    }
}
