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
public final class e1 implements Factory<d1> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<d2> f42685a;

    public e1(Provider<d2> provider) {
        this.f42685a = provider;
    }

    public static d1 b(d2 d2Var) {
        return new d1(d2Var);
    }

    public static e1 c(Provider<d2> provider) {
        return new e1(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public d1 get() {
        return b(this.f42685a.get());
    }
}
