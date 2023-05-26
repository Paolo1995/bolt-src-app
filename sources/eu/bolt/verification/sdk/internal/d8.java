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
public final class d8 implements Factory<c8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<x7> f42624a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<z7> f42625b;

    public d8(Provider<x7> provider, Provider<z7> provider2) {
        this.f42624a = provider;
        this.f42625b = provider2;
    }

    public static c8 b(x7 x7Var, z7 z7Var) {
        return new c8(x7Var, z7Var);
    }

    public static d8 c(Provider<x7> provider, Provider<z7> provider2) {
        return new d8(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public c8 get() {
        return b(this.f42624a.get(), this.f42625b.get());
    }
}
