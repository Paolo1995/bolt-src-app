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
public final class hj implements Factory<gj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<oj> f43409a;

    public hj(Provider<oj> provider) {
        this.f43409a = provider;
    }

    public static gj b(oj ojVar) {
        return new gj(ojVar);
    }

    public static hj c(Provider<oj> provider) {
        return new hj(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public gj get() {
        return b(this.f43409a.get());
    }
}
