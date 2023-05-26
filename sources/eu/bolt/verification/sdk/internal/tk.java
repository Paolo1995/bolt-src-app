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
public final class tk implements Factory<sk> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ip> f45210a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<eh> f45211b;

    public tk(Provider<ip> provider, Provider<eh> provider2) {
        this.f45210a = provider;
        this.f45211b = provider2;
    }

    public static sk b(ip ipVar, eh ehVar) {
        return new sk(ipVar, ehVar);
    }

    public static tk c(Provider<ip> provider, Provider<eh> provider2) {
        return new tk(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public sk get() {
        return b(this.f45210a.get(), this.f45211b.get());
    }
}
