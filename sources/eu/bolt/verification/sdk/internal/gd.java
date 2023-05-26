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
public final class gd implements Factory<fd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f43137a;

    public gd(Provider<xn> provider) {
        this.f43137a = provider;
    }

    public static fd b(xn xnVar) {
        return new fd(xnVar);
    }

    public static gd c(Provider<xn> provider) {
        return new gd(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public fd get() {
        return b(this.f43137a.get());
    }
}
