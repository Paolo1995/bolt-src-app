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
public final class wj implements Factory<vj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<mi> f45557a;

    public wj(Provider<mi> provider) {
        this.f45557a = provider;
    }

    public static vj b(mi miVar) {
        return new vj(miVar);
    }

    public static wj c(Provider<mi> provider) {
        return new wj(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public vj get() {
        return b(this.f45557a.get());
    }
}
