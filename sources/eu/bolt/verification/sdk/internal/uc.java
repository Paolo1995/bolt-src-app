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
public final class uc implements Factory<tc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<rc> f45348a;

    public uc(Provider<rc> provider) {
        this.f45348a = provider;
    }

    public static tc b(rc rcVar) {
        return new tc(rcVar);
    }

    public static uc c(Provider<rc> provider) {
        return new uc(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public tc get() {
        return b(this.f45348a.get());
    }
}
