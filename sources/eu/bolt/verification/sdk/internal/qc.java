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
public final class qc implements Factory<pc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xn> f44643a;

    public qc(Provider<xn> provider) {
        this.f44643a = provider;
    }

    public static pc b(xn xnVar) {
        return new pc(xnVar);
    }

    public static qc c(Provider<xn> provider) {
        return new qc(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public pc get() {
        return b(this.f44643a.get());
    }
}
