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
public final class s5 implements Factory<r5> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<q5> f44940a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<y6> f44941b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ib> f44942c;

    public s5(Provider<q5> provider, Provider<y6> provider2, Provider<ib> provider3) {
        this.f44940a = provider;
        this.f44941b = provider2;
        this.f44942c = provider3;
    }

    public static r5 b(q5 q5Var, y6 y6Var, ib ibVar) {
        return new r5(q5Var, y6Var, ibVar);
    }

    public static s5 c(Provider<q5> provider, Provider<y6> provider2, Provider<ib> provider3) {
        return new s5(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public r5 get() {
        return b(this.f44940a.get(), this.f44941b.get(), this.f44942c.get());
    }
}
