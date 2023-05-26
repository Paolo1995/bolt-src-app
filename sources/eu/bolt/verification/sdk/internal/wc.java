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
public final class wc implements Factory<vc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f45541a;

    public wc(Provider<xn> provider) {
        this.f45541a = provider;
    }

    public static vc b(xn xnVar) {
        return new vc(xnVar);
    }

    public static wc c(Provider<xn> provider) {
        return new wc(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public vc get() {
        return b(this.f45541a.get());
    }
}
