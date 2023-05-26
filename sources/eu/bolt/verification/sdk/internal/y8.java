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
public final class y8 implements Factory<x8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f45739a;

    public y8(Provider<xn> provider) {
        this.f45739a = provider;
    }

    public static x8 b(xn xnVar) {
        return new x8(xnVar);
    }

    public static y8 c(Provider<xn> provider) {
        return new y8(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public x8 get() {
        return b(this.f45739a.get());
    }
}
