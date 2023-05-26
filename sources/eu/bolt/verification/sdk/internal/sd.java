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
public final class sd implements Factory<rd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<a0> f44977a;

    public sd(Provider<a0> provider) {
        this.f44977a = provider;
    }

    public static rd b(a0 a0Var) {
        return new rd(a0Var);
    }

    public static sd c(Provider<a0> provider) {
        return new sd(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public rd get() {
        return b(this.f44977a.get());
    }
}
