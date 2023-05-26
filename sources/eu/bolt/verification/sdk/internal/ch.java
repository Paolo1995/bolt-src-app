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
public final class ch implements Factory<bh> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<tc> f42514a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ip> f42515b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<eh> f42516c;

    public ch(Provider<tc> provider, Provider<ip> provider2, Provider<eh> provider3) {
        this.f42514a = provider;
        this.f42515b = provider2;
        this.f42516c = provider3;
    }

    public static bh b(tc tcVar, ip ipVar, eh ehVar) {
        return new bh(tcVar, ipVar, ehVar);
    }

    public static ch c(Provider<tc> provider, Provider<ip> provider2, Provider<eh> provider3) {
        return new ch(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public bh get() {
        return b(this.f42514a.get(), this.f42515b.get(), this.f42516c.get());
    }
}
