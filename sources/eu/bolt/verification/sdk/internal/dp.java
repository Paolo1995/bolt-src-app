package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class dp implements Factory<ke> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<le> f42658a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ne> f42659b;

    public dp(Provider<le> provider, Provider<ne> provider2) {
        this.f42658a = provider;
        this.f42659b = provider2;
    }

    public static dp a(Provider<le> provider, Provider<ne> provider2) {
        return new dp(provider, provider2);
    }

    public static ke c(le leVar, ne neVar) {
        return (ke) Preconditions.checkNotNullFromProvides(xo.c(leVar, neVar));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ke get() {
        return c(this.f42658a.get(), this.f42659b.get());
    }
}
