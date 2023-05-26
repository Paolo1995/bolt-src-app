package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import eu.bolt.verification.sdk.internal.rn;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class n3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements rn.b.a {

        /* renamed from: a  reason: collision with root package name */
        private ViewGroup f44240a;

        /* renamed from: b  reason: collision with root package name */
        private yn f44241b;

        /* renamed from: c  reason: collision with root package name */
        private rn.d f44242c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.rn.b.a
        public rn.b build() {
            Preconditions.checkBuilderRequirement(this.f44240a, ViewGroup.class);
            Preconditions.checkBuilderRequirement(this.f44241b, yn.class);
            Preconditions.checkBuilderRequirement(this.f44242c, rn.d.class);
            return new b(this.f44242c, this.f44240a, this.f44241b);
        }

        @Override // eu.bolt.verification.sdk.internal.rn.b.a
        /* renamed from: d */
        public a a(ViewGroup viewGroup) {
            this.f44240a = (ViewGroup) Preconditions.checkNotNull(viewGroup);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.rn.b.a
        /* renamed from: e */
        public a b(rn.d dVar) {
            this.f44242c = (rn.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.rn.b.a
        /* renamed from: f */
        public a c(yn ynVar) {
            this.f44241b = (yn) Preconditions.checkNotNull(ynVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements rn.b {
        private Provider<ip> A;
        private Provider<q8> B;
        private Provider<x1> C;
        private Provider<ia> D;
        private Provider<rc> E;
        private Provider<vc> F;
        private Provider<xc> G;
        private Provider<ld> H;
        private Provider<pc> I;
        private Provider<mn> J;
        private Provider<x8> K;
        private Provider<nc> L;
        private Provider<sk> M;
        private Provider<tc> N;
        private Provider<wk> O;
        private Provider<uk> P;
        private Provider<bh> Q;
        private Provider<v8> R;
        private Provider<yl> S;
        private Provider<tl> T;
        private Provider<s> U;
        private Provider<j9> V;
        private Provider<z8> W;
        private Provider<a9> X;
        private Provider<dd> Y;
        private Provider<fd> Z;

        /* renamed from: a  reason: collision with root package name */
        private final rn.d f44243a;

        /* renamed from: a0  reason: collision with root package name */
        private Provider<db> f44244a0;

        /* renamed from: b  reason: collision with root package name */
        private final b f44245b;

        /* renamed from: b0  reason: collision with root package name */
        private Provider<hd> f44246b0;

        /* renamed from: c  reason: collision with root package name */
        private Provider<ViewGroup> f44247c;

        /* renamed from: c0  reason: collision with root package name */
        private Provider<of> f44248c0;

        /* renamed from: d  reason: collision with root package name */
        private Provider<rn.b> f44249d;

        /* renamed from: d0  reason: collision with root package name */
        private Provider<jd> f44250d0;

        /* renamed from: e  reason: collision with root package name */
        private Provider<yn> f44251e;

        /* renamed from: e0  reason: collision with root package name */
        private Provider<oh> f44252e0;

        /* renamed from: f  reason: collision with root package name */
        private Provider<co> f44253f;

        /* renamed from: f0  reason: collision with root package name */
        private Provider<ao> f44254f0;

        /* renamed from: g  reason: collision with root package name */
        private Provider<xg> f44255g;

        /* renamed from: g0  reason: collision with root package name */
        private Provider<zn<Cdo>> f44256g0;

        /* renamed from: h  reason: collision with root package name */
        private Provider<xn> f44257h;

        /* renamed from: h0  reason: collision with root package name */
        private Provider<ViewGroup> f44258h0;

        /* renamed from: i  reason: collision with root package name */
        private Provider<ye> f44259i;

        /* renamed from: i0  reason: collision with root package name */
        private Provider<Cdo> f44260i0;

        /* renamed from: j  reason: collision with root package name */
        private Provider<eh> f44261j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<bd> f44262k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<kn> f44263l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<f0> f44264m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<jr> f44265n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<Context> f44266o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<a0> f44267p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<rd> f44268q;

        /* renamed from: r  reason: collision with root package name */
        private Provider<cq> f44269r;

        /* renamed from: s  reason: collision with root package name */
        private Provider<qm> f44270s;

        /* renamed from: t  reason: collision with root package name */
        private Provider<um> f44271t;

        /* renamed from: u  reason: collision with root package name */
        private Provider<po> f44272u;

        /* renamed from: v  reason: collision with root package name */
        private Provider<up> f44273v;

        /* renamed from: w  reason: collision with root package name */
        private Provider<wp> f44274w;

        /* renamed from: x  reason: collision with root package name */
        private Provider<vn> f44275x;

        /* renamed from: y  reason: collision with root package name */
        private Provider<oq> f44276y;

        /* renamed from: z  reason: collision with root package name */
        private Provider<dl> f44277z;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44278a;

            a(rn.d dVar) {
                this.f44278a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f44278a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.n3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0074b implements Provider<a0> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44279a;

            C0074b(rn.d dVar) {
                this.f44279a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public a0 get() {
                return (a0) Preconditions.checkNotNullFromComponent(this.f44279a.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<f0> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44280a;

            c(rn.d dVar) {
                this.f44280a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public f0 get() {
                return (f0) Preconditions.checkNotNullFromComponent(this.f44280a.z());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<Context> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44281a;

            d(rn.d dVar) {
                this.f44281a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.f44281a.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<ViewGroup> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44282a;

            e(rn.d dVar) {
                this.f44282a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ViewGroup get() {
                return (ViewGroup) Preconditions.checkNotNullFromComponent(this.f44282a.H());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<db> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44283a;

            f(rn.d dVar) {
                this.f44283a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public db get() {
                return (db) Preconditions.checkNotNullFromComponent(this.f44283a.w());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<xg> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44284a;

            g(rn.d dVar) {
                this.f44284a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xg get() {
                return (xg) Preconditions.checkNotNullFromComponent(this.f44284a.s());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class h implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44285a;

            h(rn.d dVar) {
                this.f44285a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f44285a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class i implements Provider<kn> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44286a;

            i(rn.d dVar) {
                this.f44286a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public kn get() {
                return (kn) Preconditions.checkNotNullFromComponent(this.f44286a.E());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class j implements Provider<co> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44287a;

            j(rn.d dVar) {
                this.f44287a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public co get() {
                return (co) Preconditions.checkNotNullFromComponent(this.f44287a.y());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class k implements Provider<jr> {

            /* renamed from: a  reason: collision with root package name */
            private final rn.d f44288a;

            k(rn.d dVar) {
                this.f44288a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public jr get() {
                return (jr) Preconditions.checkNotNullFromComponent(this.f44288a.v());
            }
        }

        private b(rn.d dVar, ViewGroup viewGroup, yn ynVar) {
            this.f44245b = this;
            this.f44243a = dVar;
            c(dVar, viewGroup, ynVar);
        }

        private void c(rn.d dVar, ViewGroup viewGroup, yn ynVar) {
            this.f44247c = InstanceFactory.create(viewGroup);
            this.f44249d = InstanceFactory.create(this.f44245b);
            this.f44251e = InstanceFactory.create(ynVar);
            this.f44253f = new j(dVar);
            g gVar = new g(dVar);
            this.f44255g = gVar;
            Provider<xn> provider = DoubleCheck.provider(sn.a(gVar));
            this.f44257h = provider;
            ze c8 = ze.c(provider);
            this.f44259i = c8;
            this.f44261j = fh.c(this.f44257h, c8);
            this.f44262k = cd.c(this.f44257h);
            this.f44263l = new i(dVar);
            this.f44264m = new c(dVar);
            this.f44265n = new k(dVar);
            this.f44266o = new d(dVar);
            C0074b c0074b = new C0074b(dVar);
            this.f44267p = c0074b;
            sd c9 = sd.c(c0074b);
            this.f44268q = c9;
            this.f44269r = dq.c(this.f44266o, c9);
            rm c10 = rm.c(this.f44265n, om.a(), mm.a(), this.f44269r, gm.a(), sq.a());
            this.f44270s = c10;
            this.f44271t = vm.c(c10);
            qo c11 = qo.c(jq.a(), this.f44271t, to.a(), hq.a(), this.f44270s);
            this.f44272u = c11;
            this.f44273v = vp.c(c11, oo.a(), ee.a(), hq.a());
            xp c12 = xp.c(aq.a(), this.f44273v, tp.a(), rp.a(), pp.a(), gm.a());
            this.f44274w = c12;
            this.f44275x = wn.c(c12, go.a());
            this.f44276y = pq.c(this.f44274w, go.a());
            this.f44277z = new h(dVar);
            jp c13 = jp.c(this.f44263l, this.f44264m, this.f44275x, this.f44276y, pn.a(), this.f44255g, ge.a(), this.f44277z, go.a());
            this.A = c13;
            this.B = r8.c(this.f44257h, c13, sq.a());
            y1 c14 = y1.c(this.f44257h);
            this.C = c14;
            this.D = ja.c(this.f44261j, this.f44262k, this.B, c14, this.f44257h);
            this.E = sc.c(this.f44257h);
            this.F = wc.c(this.f44257h);
            this.G = yc.c(this.f44257h);
            this.H = md.c(this.E);
            this.I = qc.c(this.f44257h);
            this.J = nn.c(this.f44266o);
            this.K = y8.c(this.f44257h);
            this.L = oc.c(this.f44257h);
            this.M = tk.c(this.A, this.f44261j);
            uc c15 = uc.c(this.E);
            this.N = c15;
            this.O = xk.c(c15, this.f44257h, this.f44261j, this.f44262k, this.B, this.C);
            this.P = vk.c(this.N, this.A, this.f44257h, sq.a(), this.C);
            this.Q = ch.c(this.N, this.A, this.f44261j);
            this.R = w8.c(this.F, this.E, this.f44257h);
            zl c16 = zl.c(this.f44257h);
            this.S = c16;
            this.T = ul.c(this.A, this.f44257h, this.B, this.f44259i, c16, this.C);
            this.U = new a(dVar);
            this.V = k9.c(this.f44257h);
            this.W = c9.a(this.E, e2.a(), this.K, this.M, this.O, this.P, this.Q, this.f44257h, this.C, this.R, this.J, this.T, this.U, this.V);
            this.X = b9.c(this.E, e2.a(), this.K, this.M, this.O, this.P, this.Q, this.f44257h, this.C, this.R, this.J, this.T, this.U, this.V);
            this.Y = ed.c(this.f44257h);
            this.Z = gd.c(this.f44257h);
            this.f44244a0 = new f(dVar);
            this.f44246b0 = id.c(this.f44257h);
            this.f44248c0 = pf.c(this.A);
            this.f44250d0 = kd.c(this.E);
            this.f44252e0 = ph.c(this.N, this.S, this.f44255g, this.f44262k, this.B, this.f44257h, this.C);
            Provider<ao> provider2 = DoubleCheck.provider(bo.c(this.f44251e, this.f44253f, this.f44255g, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.W, this.X, this.Y, this.Z, m0.a(), this.f44244a0, this.f44246b0, this.f44248c0, this.f44277z, this.f44250d0, this.f44252e0));
            this.f44254f0 = provider2;
            this.f44256g0 = DoubleCheck.provider(tn.a(provider2));
            e eVar = new e(dVar);
            this.f44258h0 = eVar;
            this.f44260i0 = DoubleCheck.provider(un.c(this.f44247c, this.f44249d, this.f44256g0, eVar));
        }

        @Override // eu.bolt.verification.sdk.internal.wm.d
        public hn A() {
            return this.f44254f0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f44243a.B());
        }

        @Override // eu.bolt.verification.sdk.internal.rn.a
        public Cdo C() {
            return this.f44260i0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.l7.d
        public t7 D() {
            return this.f44254f0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public kn E() {
            return (kn) Preconditions.checkNotNullFromComponent(this.f44243a.E());
        }

        @Override // eu.bolt.verification.sdk.internal.o0.d
        public v0 F() {
            return this.f44254f0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public DispatchersBundle G() {
            return (DispatchersBundle) Preconditions.checkNotNullFromComponent(this.f44243a.G());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public ViewGroup H() {
            return (ViewGroup) Preconditions.checkNotNullFromComponent(this.f44243a.H());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public v4 I() {
            return (v4) Preconditions.checkNotNullFromComponent(this.f44243a.I());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public qj a() {
            return (qj) Preconditions.checkNotNullFromComponent(this.f44243a.a());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public ib b() {
            return (ib) Preconditions.checkNotNullFromComponent(this.f44243a.b());
        }

        @Override // eu.bolt.verification.sdk.internal.e8.d
        public y6 c() {
            return this.f44254f0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.o0.d
        public jc d() {
            return (jc) Preconditions.checkNotNullFromComponent(this.f44243a.e());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public jc e() {
            return (jc) Preconditions.checkNotNullFromComponent(this.f44243a.e());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public Activity f() {
            return (Activity) Preconditions.checkNotNullFromComponent(this.f44243a.f());
        }

        @Override // eu.bolt.verification.sdk.internal.l7.d, eu.bolt.verification.sdk.internal.wm.d
        public xn g() {
            return this.f44257h.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public lr h() {
            return (lr) Preconditions.checkNotNullFromComponent(this.f44243a.h());
        }

        @Override // eu.bolt.verification.sdk.internal.wm.d
        public ke i() {
            return (ke) Preconditions.checkNotNullFromComponent(this.f44243a.i());
        }

        @Override // eu.bolt.verification.sdk.internal.vi.d
        public aj j() {
            return this.f44254f0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public Context k() {
            return (Context) Preconditions.checkNotNullFromComponent(this.f44243a.k());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public a0 l() {
            return (a0) Preconditions.checkNotNullFromComponent(this.f44243a.l());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public mg m() {
            return (mg) Preconditions.checkNotNullFromComponent(this.f44243a.m());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return (s) Preconditions.checkNotNullFromComponent(this.f44243a.n());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public sf o() {
            return (sf) Preconditions.checkNotNullFromComponent(this.f44243a.o());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return (dl) Preconditions.checkNotNullFromComponent(this.f44243a.p());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public x9 q() {
            return (x9) Preconditions.checkNotNullFromComponent(this.f44243a.q());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public xf r() {
            return (xf) Preconditions.checkNotNullFromComponent(this.f44243a.r());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public xg s() {
            return (xg) Preconditions.checkNotNullFromComponent(this.f44243a.s());
        }

        @Override // eu.bolt.verification.sdk.internal.yq.d
        public cr t() {
            return this.f44254f0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public jr v() {
            return (jr) Preconditions.checkNotNullFromComponent(this.f44243a.v());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public db w() {
            return (db) Preconditions.checkNotNullFromComponent(this.f44243a.w());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f44243a.x());
        }

        @Override // eu.bolt.verification.sdk.internal.mp
        public f0 z() {
            return (f0) Preconditions.checkNotNullFromComponent(this.f44243a.z());
        }
    }

    public static rn.b.a a() {
        return new a();
    }
}
