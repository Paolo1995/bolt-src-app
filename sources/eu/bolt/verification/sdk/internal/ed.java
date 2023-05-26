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
public final class ed implements Factory<dd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f42758a;

    public ed(Provider<xn> provider) {
        this.f42758a = provider;
    }

    public static dd b(xn xnVar) {
        return new dd(xnVar);
    }

    public static ed c(Provider<xn> provider) {
        return new ed(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public dd get() {
        return b(this.f42758a.get());
    }
}
