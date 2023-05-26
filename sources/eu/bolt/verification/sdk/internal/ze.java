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
public final class ze implements Factory<ye> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f45857a;

    public ze(Provider<xn> provider) {
        this.f45857a = provider;
    }

    public static ye b(xn xnVar) {
        return new ye(xnVar);
    }

    public static ze c(Provider<xn> provider) {
        return new ze(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ye get() {
        return b(this.f45857a.get());
    }
}
