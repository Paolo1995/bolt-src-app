package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.RxActivityEvents;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class mj implements Factory<lj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<kj> f44203a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<fj> f44204b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RxActivityEvents> f44205c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<nj> f44206d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<mg> f44207e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<xf> f44208f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<bg> f44209g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<l5> f44210h;

    public mj(Provider<kj> provider, Provider<fj> provider2, Provider<RxActivityEvents> provider3, Provider<nj> provider4, Provider<mg> provider5, Provider<xf> provider6, Provider<bg> provider7, Provider<l5> provider8) {
        this.f44203a = provider;
        this.f44204b = provider2;
        this.f44205c = provider3;
        this.f44206d = provider4;
        this.f44207e = provider5;
        this.f44208f = provider6;
        this.f44209g = provider7;
        this.f44210h = provider8;
    }

    public static lj b(kj kjVar, fj fjVar, RxActivityEvents rxActivityEvents, nj njVar, mg mgVar, xf xfVar, bg bgVar, l5 l5Var) {
        return new lj(kjVar, fjVar, rxActivityEvents, njVar, mgVar, xfVar, bgVar, l5Var);
    }

    public static mj c(Provider<kj> provider, Provider<fj> provider2, Provider<RxActivityEvents> provider3, Provider<nj> provider4, Provider<mg> provider5, Provider<xf> provider6, Provider<bg> provider7, Provider<l5> provider8) {
        return new mj(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public lj get() {
        return b(this.f44203a.get(), this.f44204b.get(), this.f44205c.get(), this.f44206d.get(), this.f44207e.get(), this.f44208f.get(), this.f44209g.get(), this.f44210h.get());
    }
}
