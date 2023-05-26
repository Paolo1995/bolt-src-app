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
public final class g9 implements Factory<f9> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f43132a;

    public g9(Provider<xn> provider) {
        this.f43132a = provider;
    }

    public static f9 b(xn xnVar) {
        return new f9(xnVar);
    }

    public static g9 c(Provider<xn> provider) {
        return new g9(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public f9 get() {
        return b(this.f43132a.get());
    }
}
