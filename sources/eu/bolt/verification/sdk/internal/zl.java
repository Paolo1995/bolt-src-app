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
public final class zl implements Factory<yl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f45871a;

    public zl(Provider<xn> provider) {
        this.f45871a = provider;
    }

    public static yl b(xn xnVar) {
        return new yl(xnVar);
    }

    public static zl c(Provider<xn> provider) {
        return new zl(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public yl get() {
        return b(this.f45871a.get());
    }
}
