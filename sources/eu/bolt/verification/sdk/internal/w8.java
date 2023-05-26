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
public final class w8 implements Factory<v8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<vc> f45534a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<rc> f45535b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<xn> f45536c;

    public w8(Provider<vc> provider, Provider<rc> provider2, Provider<xn> provider3) {
        this.f45534a = provider;
        this.f45535b = provider2;
        this.f45536c = provider3;
    }

    public static v8 b(vc vcVar, rc rcVar, xn xnVar) {
        return new v8(vcVar, rcVar, xnVar);
    }

    public static w8 c(Provider<vc> provider, Provider<rc> provider2, Provider<xn> provider3) {
        return new w8(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public v8 get() {
        return b(this.f45534a.get(), this.f45535b.get(), this.f45536c.get());
    }
}
