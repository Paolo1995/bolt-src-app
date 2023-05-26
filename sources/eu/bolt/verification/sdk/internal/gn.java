package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.camera.VerificationCameraBuilder.VerificationCameraScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class gn implements Factory<fn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<en> f43156a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<hn> f43157b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<bn> f43158c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<cf> f43159d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<x1> f43160e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<v8> f43161f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<mn> f43162g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<i1> f43163h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<mg> f43164i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<ke> f43165j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<sf> f43166k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<xf> f43167l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<RxActivityEvents> f43168m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<CoActivityEvents> f43169n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<xg> f43170o;

    /* renamed from: p  reason: collision with root package name */
    private final Provider<bg> f43171p;

    /* renamed from: q  reason: collision with root package name */
    private final Provider<o1> f43172q;

    /* renamed from: r  reason: collision with root package name */
    private final Provider<g1> f43173r;

    /* renamed from: s  reason: collision with root package name */
    private final Provider<dl> f43174s;

    public gn(Provider<en> provider, Provider<hn> provider2, Provider<bn> provider3, Provider<cf> provider4, Provider<x1> provider5, Provider<v8> provider6, Provider<mn> provider7, Provider<i1> provider8, Provider<mg> provider9, Provider<ke> provider10, Provider<sf> provider11, Provider<xf> provider12, Provider<RxActivityEvents> provider13, Provider<CoActivityEvents> provider14, Provider<xg> provider15, Provider<bg> provider16, Provider<o1> provider17, Provider<g1> provider18, Provider<dl> provider19) {
        this.f43156a = provider;
        this.f43157b = provider2;
        this.f43158c = provider3;
        this.f43159d = provider4;
        this.f43160e = provider5;
        this.f43161f = provider6;
        this.f43162g = provider7;
        this.f43163h = provider8;
        this.f43164i = provider9;
        this.f43165j = provider10;
        this.f43166k = provider11;
        this.f43167l = provider12;
        this.f43168m = provider13;
        this.f43169n = provider14;
        this.f43170o = provider15;
        this.f43171p = provider16;
        this.f43172q = provider17;
        this.f43173r = provider18;
        this.f43174s = provider19;
    }

    public static fn b(en enVar, hn hnVar, bn bnVar, cf cfVar, x1 x1Var, v8 v8Var, mn mnVar, i1 i1Var, mg mgVar, ke keVar, sf sfVar, xf xfVar, RxActivityEvents rxActivityEvents, CoActivityEvents coActivityEvents, xg xgVar, bg bgVar, o1 o1Var, g1 g1Var, dl dlVar) {
        return new fn(enVar, hnVar, bnVar, cfVar, x1Var, v8Var, mnVar, i1Var, mgVar, keVar, sfVar, xfVar, rxActivityEvents, coActivityEvents, xgVar, bgVar, o1Var, g1Var, dlVar);
    }

    public static gn c(Provider<en> provider, Provider<hn> provider2, Provider<bn> provider3, Provider<cf> provider4, Provider<x1> provider5, Provider<v8> provider6, Provider<mn> provider7, Provider<i1> provider8, Provider<mg> provider9, Provider<ke> provider10, Provider<sf> provider11, Provider<xf> provider12, Provider<RxActivityEvents> provider13, Provider<CoActivityEvents> provider14, Provider<xg> provider15, Provider<bg> provider16, Provider<o1> provider17, Provider<g1> provider18, Provider<dl> provider19) {
        return new gn(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public fn get() {
        return b(this.f43156a.get(), this.f43157b.get(), this.f43158c.get(), this.f43159d.get(), this.f43160e.get(), this.f43161f.get(), this.f43162g.get(), this.f43163h.get(), this.f43164i.get(), this.f43165j.get(), this.f43166k.get(), this.f43167l.get(), this.f43168m.get(), this.f43169n.get(), this.f43170o.get(), this.f43171p.get(), this.f43172q.get(), this.f43173r.get(), this.f43174s.get());
    }
}
