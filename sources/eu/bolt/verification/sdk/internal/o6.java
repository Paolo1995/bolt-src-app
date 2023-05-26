package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.n6;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.ribsshared.error.content.ErrorContentBuilder.ErrorContentScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class o6 implements Factory<v6> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<w6> f44413a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<t6> f44414b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<qj> f44415c;

    public o6(Provider<w6> provider, Provider<t6> provider2, Provider<qj> provider3) {
        this.f44413a = provider;
        this.f44414b = provider2;
        this.f44415c = provider3;
    }

    public static o6 a(Provider<w6> provider, Provider<t6> provider2, Provider<qj> provider3) {
        return new o6(provider, provider2, provider3);
    }

    public static v6 c(w6 w6Var, t6 t6Var, qj qjVar) {
        return (v6) Preconditions.checkNotNullFromProvides(n6.c.a(w6Var, t6Var, qjVar));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public v6 get() {
        return c(this.f44413a.get(), this.f44414b.get(), this.f44415c.get());
    }
}
