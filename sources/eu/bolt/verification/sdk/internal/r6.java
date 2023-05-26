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
public final class r6 implements Factory<q6> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<s6> f44729a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<w6> f44730b;

    public r6(Provider<s6> provider, Provider<w6> provider2) {
        this.f44729a = provider;
        this.f44730b = provider2;
    }

    public static q6 b(s6 s6Var, w6 w6Var) {
        return new q6(s6Var, w6Var);
    }

    public static r6 c(Provider<s6> provider, Provider<w6> provider2) {
        return new r6(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public q6 get() {
        return b(this.f44729a.get(), this.f44730b.get());
    }
}
