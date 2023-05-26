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
public final class r8 implements Factory<q8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f44796a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ip> f44797b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<rq> f44798c;

    public r8(Provider<xn> provider, Provider<ip> provider2, Provider<rq> provider3) {
        this.f44796a = provider;
        this.f44797b = provider2;
        this.f44798c = provider3;
    }

    public static q8 b(xn xnVar, ip ipVar, rq rqVar) {
        return new q8(xnVar, ipVar, rqVar);
    }

    public static r8 c(Provider<xn> provider, Provider<ip> provider2, Provider<rq> provider3) {
        return new r8(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public q8 get() {
        return b(this.f44796a.get(), this.f44797b.get(), this.f44798c.get());
    }
}
