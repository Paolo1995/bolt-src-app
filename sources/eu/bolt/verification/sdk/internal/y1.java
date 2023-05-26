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
public final class y1 implements Factory<x1> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f45715a;

    public y1(Provider<xn> provider) {
        this.f45715a = provider;
    }

    public static x1 b(xn xnVar) {
        return new x1(xnVar);
    }

    public static y1 c(Provider<xn> provider) {
        return new y1(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public x1 get() {
        return b(this.f45715a.get());
    }
}
