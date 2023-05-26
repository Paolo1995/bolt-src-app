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
public final class yc implements Factory<xc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f45741a;

    public yc(Provider<xn> provider) {
        this.f45741a = provider;
    }

    public static xc b(xn xnVar) {
        return new xc(xnVar);
    }

    public static yc c(Provider<xn> provider) {
        return new yc(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public xc get() {
        return b(this.f45741a.get());
    }
}
