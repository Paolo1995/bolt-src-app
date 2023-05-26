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
public final class pf implements Factory<of> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ip> f44537a;

    public pf(Provider<ip> provider) {
        this.f44537a = provider;
    }

    public static of b(ip ipVar) {
        return new of(ipVar);
    }

    public static pf c(Provider<ip> provider) {
        return new pf(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public of get() {
        return b(this.f44537a.get());
    }
}
