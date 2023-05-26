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
public final class cd implements Factory<bd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f42495a;

    public cd(Provider<xn> provider) {
        this.f42495a = provider;
    }

    public static bd b(xn xnVar) {
        return new bd(xnVar);
    }

    public static cd c(Provider<xn> provider) {
        return new cd(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public bd get() {
        return b(this.f42495a.get());
    }
}
