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
public final class vp implements Factory<up> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<po> f45465a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<no> f45466b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<de> f45467c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<gq> f45468d;

    public vp(Provider<po> provider, Provider<no> provider2, Provider<de> provider3, Provider<gq> provider4) {
        this.f45465a = provider;
        this.f45466b = provider2;
        this.f45467c = provider3;
        this.f45468d = provider4;
    }

    public static up b(po poVar, no noVar, de deVar, gq gqVar) {
        return new up(poVar, noVar, deVar, gqVar);
    }

    public static vp c(Provider<po> provider, Provider<no> provider2, Provider<de> provider3, Provider<gq> provider4) {
        return new vp(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public up get() {
        return b(this.f45465a.get(), this.f45466b.get(), this.f45467c.get(), this.f45468d.get());
    }
}
