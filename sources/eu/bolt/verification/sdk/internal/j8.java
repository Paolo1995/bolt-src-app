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
public final class j8 implements Factory<i8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<g8> f43669a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<h8> f43670b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<y6> f43671c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ib> f43672d;

    public j8(Provider<g8> provider, Provider<h8> provider2, Provider<y6> provider3, Provider<ib> provider4) {
        this.f43669a = provider;
        this.f43670b = provider2;
        this.f43671c = provider3;
        this.f43672d = provider4;
    }

    public static i8 b(g8 g8Var, h8 h8Var, y6 y6Var, ib ibVar) {
        return new i8(g8Var, h8Var, y6Var, ibVar);
    }

    public static j8 c(Provider<g8> provider, Provider<h8> provider2, Provider<y6> provider3, Provider<ib> provider4) {
        return new j8(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public i8 get() {
        return b(this.f43669a.get(), this.f43670b.get(), this.f43671c.get(), this.f43672d.get());
    }
}
