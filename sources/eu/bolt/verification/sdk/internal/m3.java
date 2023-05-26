package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RibActivity;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import eu.bolt.verification.sdk.VerificationSDKActivity;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import eu.bolt.verification.sdk.internal.ln;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class m3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements ln.a {

        /* renamed from: a  reason: collision with root package name */
        private g f44122a;

        /* renamed from: b  reason: collision with root package name */
        private co f44123b;

        /* renamed from: c  reason: collision with root package name */
        private VerificationSDKConfiguration f44124c;

        /* renamed from: d  reason: collision with root package name */
        private ViewGroup f44125d;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.ln.a
        public ln build() {
            Preconditions.checkBuilderRequirement(this.f44122a, g.class);
            Preconditions.checkBuilderRequirement(this.f44123b, co.class);
            Preconditions.checkBuilderRequirement(this.f44124c, VerificationSDKConfiguration.class);
            Preconditions.checkBuilderRequirement(this.f44125d, ViewGroup.class);
            return new b(this.f44122a, this.f44123b, this.f44124c, this.f44125d);
        }

        @Override // eu.bolt.verification.sdk.internal.ln.a
        /* renamed from: e */
        public a a(ViewGroup viewGroup) {
            this.f44125d = (ViewGroup) Preconditions.checkNotNull(viewGroup);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.ln.a
        /* renamed from: f */
        public a b(VerificationSDKConfiguration verificationSDKConfiguration) {
            this.f44124c = (VerificationSDKConfiguration) Preconditions.checkNotNull(verificationSDKConfiguration);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.ln.a
        /* renamed from: g */
        public a c(co coVar) {
            this.f44123b = (co) Preconditions.checkNotNull(coVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.ln.a
        /* renamed from: h */
        public a d(g gVar) {
            this.f44122a = (g) Preconditions.checkNotNull(gVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements ln {
        private Provider<qf> A;
        private Provider<yg> B;
        private Provider<ne> C;
        private Provider<ke> D;
        private Provider<wb> E;
        private Provider<vb> F;
        private Provider<am> G;
        private Provider<tf> H;
        private Provider<sf> I;
        private Provider<eb> J;
        private Provider<db> K;
        private Provider<vg> L;
        private Provider<Object> M;
        private Provider<ib> N;
        private Provider<y9> O;
        private Provider<x9> P;
        private Provider<jm> Q;
        private Provider<a0> R;
        private Provider<y> S;
        private Provider<f0> T;
        private Provider<kn> U;
        private Provider<mr> V;
        private Provider<lr> W;
        private Provider<jr> X;
        private Provider<Object> Y;

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f44126a;

        /* renamed from: b  reason: collision with root package name */
        private final co f44127b;

        /* renamed from: c  reason: collision with root package name */
        private final b f44128c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<Activity> f44129d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<RibActivity> f44130e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<VerificationSDKConfiguration> f44131f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<VerificationAnalyticsManager> f44132g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<s> f44133h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<eq> f44134i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<dl> f44135j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<xg> f44136k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<DispatchersBundle> f44137l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<lb> f44138m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<kb> f44139n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<kc> f44140o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<jc> f44141p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<ng> f44142q;

        /* renamed from: r  reason: collision with root package name */
        private Provider<mg> f44143r;

        /* renamed from: s  reason: collision with root package name */
        private Provider<yf> f44144s;

        /* renamed from: t  reason: collision with root package name */
        private Provider<xf> f44145t;

        /* renamed from: u  reason: collision with root package name */
        private Provider<v4> f44146u;

        /* renamed from: v  reason: collision with root package name */
        private Provider<VerificationSDKActivity> f44147v;

        /* renamed from: w  reason: collision with root package name */
        private Provider<uo> f44148w;

        /* renamed from: x  reason: collision with root package name */
        private Provider<qj> f44149x;

        /* renamed from: y  reason: collision with root package name */
        private Provider<FragmentActivity> f44150y;

        /* renamed from: z  reason: collision with root package name */
        private Provider<RxPermissions> f44151z;

        private b(g gVar, co coVar, VerificationSDKConfiguration verificationSDKConfiguration, ViewGroup viewGroup) {
            this.f44128c = this;
            this.f44126a = viewGroup;
            this.f44127b = coVar;
            c(gVar, coVar, verificationSDKConfiguration, viewGroup);
        }

        private void c(g gVar, co coVar, VerificationSDKConfiguration verificationSDKConfiguration, ViewGroup viewGroup) {
            this.f44129d = DoubleCheck.provider(j.b(gVar));
            this.f44130e = DoubleCheck.provider(l.b(gVar));
            Factory create = InstanceFactory.create(verificationSDKConfiguration);
            this.f44131f = create;
            Provider<VerificationAnalyticsManager> provider = DoubleCheck.provider(yo.c(create));
            this.f44132g = provider;
            this.f44133h = DoubleCheck.provider(bp.a(provider));
            fq c8 = fq.c(this.f44131f);
            this.f44134i = c8;
            this.f44135j = DoubleCheck.provider(c8);
            this.f44136k = DoubleCheck.provider(Cif.a());
            this.f44137l = DoubleCheck.provider(i.b(gVar));
            mb c9 = mb.c(this.f44129d);
            this.f44138m = c9;
            Provider<kb> provider2 = DoubleCheck.provider(c9);
            this.f44139n = provider2;
            lc c10 = lc.c(this.f44129d, provider2);
            this.f44140o = c10;
            Provider<jc> provider3 = DoubleCheck.provider(c10);
            this.f44141p = provider3;
            og c11 = og.c(this.f44129d, provider3);
            this.f44142q = c11;
            this.f44143r = DoubleCheck.provider(c11);
            zf c12 = zf.c(this.f44129d);
            this.f44144s = c12;
            this.f44145t = DoubleCheck.provider(c12);
            this.f44146u = DoubleCheck.provider(h.a(gVar));
            Provider<VerificationSDKActivity> provider4 = DoubleCheck.provider(m.b(gVar));
            this.f44147v = provider4;
            vo c13 = vo.c(provider4);
            this.f44148w = c13;
            this.f44149x = DoubleCheck.provider(c13);
            Provider<FragmentActivity> provider5 = DoubleCheck.provider(k.b(gVar));
            this.f44150y = provider5;
            Provider<RxPermissions> provider6 = DoubleCheck.provider(hp.c(provider5));
            this.f44151z = provider6;
            this.A = rf.c(provider6, this.f44136k);
            this.B = DoubleCheck.provider(ep.a(this.f44129d));
            this.C = oe.c(this.f44129d);
            Provider<ke> provider7 = DoubleCheck.provider(dp.a(me.a(), this.C));
            this.D = provider7;
            xb c14 = xb.c(provider7, this.f44136k);
            this.E = c14;
            Provider<vb> provider8 = DoubleCheck.provider(c14);
            this.F = provider8;
            bm c15 = bm.c(provider8, this.D);
            this.G = c15;
            uf c16 = uf.c(this.f44150y, this.A, this.B, c15, this.f44130e);
            this.H = c16;
            this.I = DoubleCheck.provider(c16);
            fb c17 = fb.c(this.f44129d);
            this.J = c17;
            Provider<db> provider9 = DoubleCheck.provider(c17);
            this.K = provider9;
            wg c18 = wg.c(this.f44139n, this.f44136k, provider9);
            this.L = c18;
            this.M = DoubleCheck.provider(c18);
            this.N = DoubleCheck.provider(cp.a(this.f44150y));
            Provider<y9> provider10 = SingleCheck.provider(z9.a());
            this.O = provider10;
            this.P = DoubleCheck.provider(provider10);
            km c19 = km.c(this.f44131f);
            this.Q = c19;
            this.R = DoubleCheck.provider(c19);
            this.S = DoubleCheck.provider(zo.c(this.f44131f));
            this.T = DoubleCheck.provider(ap.a(this.f44131f));
            this.U = DoubleCheck.provider(fp.a(w1.a(), this.f44131f));
            nr c20 = nr.c(this.f44141p);
            this.V = c20;
            this.W = DoubleCheck.provider(c20);
            this.X = DoubleCheck.provider(gp.a(this.f44131f));
            this.Y = DoubleCheck.provider(mo.a());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return this.f44130e.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public kn E() {
            return this.U.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public DispatchersBundle G() {
            return this.f44137l.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public ViewGroup H() {
            return this.f44126a;
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public v4 I() {
            return this.f44146u.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public qj a() {
            return this.f44149x.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public ib b() {
            return this.N.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public jc e() {
            return this.f44141p.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public Activity f() {
            return this.f44129d.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public lr h() {
            return this.W.get();
        }

        @Override // eu.bolt.verification.sdk.internal.rn.d
        public ke i() {
            return this.D.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public Context k() {
            return this.f44129d.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public a0 l() {
            return this.R.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public mg m() {
            return this.f44143r.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return this.f44133h.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public sf o() {
            return this.I.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return this.f44135j.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public x9 q() {
            return this.P.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public xf r() {
            return this.f44145t.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public xg s() {
            return this.f44136k.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public jr v() {
            return this.X.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public db w() {
            return this.K.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return this.f44130e.get();
        }

        @Override // eu.bolt.verification.sdk.internal.rn.d
        public co y() {
            return this.f44127b;
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public f0 z() {
            return this.T.get();
        }
    }

    public static ln.a a() {
        return new a();
    }
}
