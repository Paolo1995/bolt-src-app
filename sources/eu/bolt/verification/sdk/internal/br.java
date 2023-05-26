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
public final class br implements Factory<ar> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<dr> f42408a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<td> f42409b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<cr> f42410c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<pd> f42411d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<bg> f42412e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<jc> f42413f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<xf> f42414g;

    public br(Provider<dr> provider, Provider<td> provider2, Provider<cr> provider3, Provider<pd> provider4, Provider<bg> provider5, Provider<jc> provider6, Provider<xf> provider7) {
        this.f42408a = provider;
        this.f42409b = provider2;
        this.f42410c = provider3;
        this.f42411d = provider4;
        this.f42412e = provider5;
        this.f42413f = provider6;
        this.f42414g = provider7;
    }

    public static ar b(dr drVar, td tdVar, cr crVar, pd pdVar, bg bgVar, jc jcVar, xf xfVar) {
        return new ar(drVar, tdVar, crVar, pdVar, bgVar, jcVar, xfVar);
    }

    public static br c(Provider<dr> provider, Provider<td> provider2, Provider<cr> provider3, Provider<pd> provider4, Provider<bg> provider5, Provider<jc> provider6, Provider<xf> provider7) {
        return new br(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ar get() {
        return b(this.f42408a.get(), this.f42409b.get(), this.f42410c.get(), this.f42411d.get(), this.f42412e.get(), this.f42413f.get(), this.f42414g.get());
    }
}
