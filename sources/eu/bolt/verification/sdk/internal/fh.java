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
public final class fh implements Factory<eh> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f42991a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ye> f42992b;

    public fh(Provider<xn> provider, Provider<ye> provider2) {
        this.f42991a = provider;
        this.f42992b = provider2;
    }

    public static eh b(xn xnVar, ye yeVar) {
        return new eh(xnVar, yeVar);
    }

    public static fh c(Provider<xn> provider, Provider<ye> provider2) {
        return new fh(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public eh get() {
        return b(this.f42991a.get(), this.f42992b.get());
    }
}
