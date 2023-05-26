package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.camera.VerificationCameraBuilder.VerificationCameraScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class dn implements Factory<cn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<jn> f42655a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<z7> f42656b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<x9> f42657c;

    public dn(Provider<jn> provider, Provider<z7> provider2, Provider<x9> provider3) {
        this.f42655a = provider;
        this.f42656b = provider2;
        this.f42657c = provider3;
    }

    public static cn b(jn jnVar, z7 z7Var, x9 x9Var) {
        return new cn(jnVar, z7Var, x9Var);
    }

    public static dn c(Provider<jn> provider, Provider<z7> provider2, Provider<x9> provider3) {
        return new dn(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public cn get() {
        return b(this.f42655a.get(), this.f42656b.get(), this.f42657c.get());
    }
}
