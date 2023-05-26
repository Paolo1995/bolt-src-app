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
public final class id implements Factory<hd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f43564a;

    public id(Provider<xn> provider) {
        this.f43564a = provider;
    }

    public static hd b(xn xnVar) {
        return new hd(xnVar);
    }

    public static id c(Provider<xn> provider) {
        return new id(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public hd get() {
        return b(this.f43564a.get());
    }
}
