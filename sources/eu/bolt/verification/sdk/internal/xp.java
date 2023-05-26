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
public final class xp implements Factory<wp> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<zp> f45689a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<up> f45690b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<sp> f45691c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<qp> f45692d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<op> f45693e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<fm> f45694f;

    public xp(Provider<zp> provider, Provider<up> provider2, Provider<sp> provider3, Provider<qp> provider4, Provider<op> provider5, Provider<fm> provider6) {
        this.f45689a = provider;
        this.f45690b = provider2;
        this.f45691c = provider3;
        this.f45692d = provider4;
        this.f45693e = provider5;
        this.f45694f = provider6;
    }

    public static wp b(zp zpVar, up upVar, sp spVar, qp qpVar, op opVar, fm fmVar) {
        return new wp(zpVar, upVar, spVar, qpVar, opVar, fmVar);
    }

    public static xp c(Provider<zp> provider, Provider<up> provider2, Provider<sp> provider3, Provider<qp> provider4, Provider<op> provider5, Provider<fm> provider6) {
        return new xp(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public wp get() {
        return b(this.f45689a.get(), this.f45690b.get(), this.f45691c.get(), this.f45692d.get(), this.f45693e.get(), this.f45694f.get());
    }
}
