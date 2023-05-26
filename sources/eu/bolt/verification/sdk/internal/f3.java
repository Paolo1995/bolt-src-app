package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import eu.bolt.verification.sdk.internal.l7;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class f3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements l7.b.a {

        /* renamed from: a  reason: collision with root package name */
        private v7 f42889a;

        /* renamed from: b  reason: collision with root package name */
        private q7 f42890b;

        /* renamed from: c  reason: collision with root package name */
        private l7.d f42891c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.l7.b.a
        public l7.b build() {
            Preconditions.checkBuilderRequirement(this.f42889a, v7.class);
            Preconditions.checkBuilderRequirement(this.f42890b, q7.class);
            Preconditions.checkBuilderRequirement(this.f42891c, l7.d.class);
            return new b(this.f42891c, this.f42889a, this.f42890b);
        }

        @Override // eu.bolt.verification.sdk.internal.l7.b.a
        /* renamed from: d */
        public a a(l7.d dVar) {
            this.f42891c = (l7.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.l7.b.a
        /* renamed from: e */
        public a c(q7 q7Var) {
            this.f42890b = (q7) Preconditions.checkNotNull(q7Var);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.l7.b.a
        /* renamed from: f */
        public a b(v7 v7Var) {
            this.f42889a = (v7) Preconditions.checkNotNull(v7Var);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements l7.b {
        private Provider<dl> A;
        private Provider<ip> B;
        private Provider<ye> C;
        private Provider<eh> D;
        private Provider<sk> E;
        private Provider<tc> F;
        private Provider<bd> G;
        private Provider<q8> H;
        private Provider<x1> I;
        private Provider<wk> J;
        private Provider<uk> K;
        private Provider<bh> L;
        private Provider<vc> M;
        private Provider<v8> N;
        private Provider<mn> O;
        private Provider<yl> P;
        private Provider<tl> Q;
        private Provider<s> R;
        private Provider<j9> S;
        private Provider<z8> T;
        private Provider<a9> U;
        private Provider<d1> V;
        private Provider<x7> W;
        private Provider<c8> X;
        private Provider<d9> Y;
        private Provider<l9> Z;

        /* renamed from: a  reason: collision with root package name */
        private final l7.d f42892a;

        /* renamed from: a0  reason: collision with root package name */
        private Provider<f9> f42893a0;

        /* renamed from: b  reason: collision with root package name */
        private final b f42894b;

        /* renamed from: b0  reason: collision with root package name */
        private Provider<h9> f42895b0;

        /* renamed from: c  reason: collision with root package name */
        private Provider<v7> f42896c;

        /* renamed from: c0  reason: collision with root package name */
        private Provider<ld> f42897c0;

        /* renamed from: d  reason: collision with root package name */
        private Provider<l7.b> f42898d;

        /* renamed from: d0  reason: collision with root package name */
        private Provider<nd> f42899d0;

        /* renamed from: e  reason: collision with root package name */
        private Provider<q7> f42900e;

        /* renamed from: e0  reason: collision with root package name */
        private Provider<zc> f42901e0;

        /* renamed from: f  reason: collision with root package name */
        private Provider<t7> f42902f;

        /* renamed from: f0  reason: collision with root package name */
        private Provider<mg> f42903f0;

        /* renamed from: g  reason: collision with root package name */
        private Provider<xg> f42904g;

        /* renamed from: g0  reason: collision with root package name */
        private Provider<xf> f42905g0;

        /* renamed from: h  reason: collision with root package name */
        private Provider<db> f42906h;

        /* renamed from: h0  reason: collision with root package name */
        private Provider<CoActivityEvents> f42907h0;

        /* renamed from: i  reason: collision with root package name */
        private Provider<o7> f42908i;

        /* renamed from: i0  reason: collision with root package name */
        private Provider<RxActivityEvents> f42909i0;

        /* renamed from: j  reason: collision with root package name */
        private Provider<xn> f42910j;

        /* renamed from: j0  reason: collision with root package name */
        private Provider<bg> f42911j0;

        /* renamed from: k  reason: collision with root package name */
        private Provider<rc> f42912k;

        /* renamed from: k0  reason: collision with root package name */
        private Provider<r7> f42913k0;

        /* renamed from: l  reason: collision with root package name */
        private Provider<x8> f42914l;

        /* renamed from: l0  reason: collision with root package name */
        private Provider<ViewGroup> f42915l0;

        /* renamed from: m  reason: collision with root package name */
        private Provider<kn> f42916m;

        /* renamed from: m0  reason: collision with root package name */
        private Provider<u7> f42917m0;

        /* renamed from: n  reason: collision with root package name */
        private Provider<f0> f42918n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<jr> f42919o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<Context> f42920p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<a0> f42921q;

        /* renamed from: r  reason: collision with root package name */
        private Provider<rd> f42922r;

        /* renamed from: s  reason: collision with root package name */
        private Provider<cq> f42923s;

        /* renamed from: t  reason: collision with root package name */
        private Provider<qm> f42924t;

        /* renamed from: u  reason: collision with root package name */
        private Provider<um> f42925u;

        /* renamed from: v  reason: collision with root package name */
        private Provider<po> f42926v;

        /* renamed from: w  reason: collision with root package name */
        private Provider<up> f42927w;

        /* renamed from: x  reason: collision with root package name */
        private Provider<wp> f42928x;

        /* renamed from: y  reason: collision with root package name */
        private Provider<vn> f42929y;

        /* renamed from: z  reason: collision with root package name */
        private Provider<oq> f42930z;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42931a;

            a(l7.d dVar) {
                this.f42931a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f42931a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.f3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0052b implements Provider<a0> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42932a;

            C0052b(l7.d dVar) {
                this.f42932a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public a0 get() {
                return (a0) Preconditions.checkNotNullFromComponent(this.f42932a.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<f0> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42933a;

            c(l7.d dVar) {
                this.f42933a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public f0 get() {
                return (f0) Preconditions.checkNotNullFromComponent(this.f42933a.z());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42934a;

            d(l7.d dVar) {
                this.f42934a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f42934a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<Context> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42935a;

            e(l7.d dVar) {
                this.f42935a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.f42935a.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<t7> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42936a;

            f(l7.d dVar) {
                this.f42936a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public t7 get() {
                return (t7) Preconditions.checkNotNullFromComponent(this.f42936a.D());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<ViewGroup> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42937a;

            g(l7.d dVar) {
                this.f42937a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ViewGroup get() {
                return (ViewGroup) Preconditions.checkNotNullFromComponent(this.f42937a.H());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class h implements Provider<db> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42938a;

            h(l7.d dVar) {
                this.f42938a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public db get() {
                return (db) Preconditions.checkNotNullFromComponent(this.f42938a.w());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class i implements Provider<xf> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42939a;

            i(l7.d dVar) {
                this.f42939a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xf get() {
                return (xf) Preconditions.checkNotNullFromComponent(this.f42939a.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class j implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42940a;

            j(l7.d dVar) {
                this.f42940a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f42940a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class k implements Provider<xg> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42941a;

            k(l7.d dVar) {
                this.f42941a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xg get() {
                return (xg) Preconditions.checkNotNullFromComponent(this.f42941a.s());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class l implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42942a;

            l(l7.d dVar) {
                this.f42942a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f42942a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class m implements Provider<kn> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42943a;

            m(l7.d dVar) {
                this.f42943a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public kn get() {
                return (kn) Preconditions.checkNotNullFromComponent(this.f42943a.E());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class n implements Provider<xn> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42944a;

            n(l7.d dVar) {
                this.f42944a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xn get() {
                return (xn) Preconditions.checkNotNullFromComponent(this.f42944a.g());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class o implements Provider<jr> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42945a;

            o(l7.d dVar) {
                this.f42945a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public jr get() {
                return (jr) Preconditions.checkNotNullFromComponent(this.f42945a.v());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class p implements Provider<mg> {

            /* renamed from: a  reason: collision with root package name */
            private final l7.d f42946a;

            p(l7.d dVar) {
                this.f42946a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public mg get() {
                return (mg) Preconditions.checkNotNullFromComponent(this.f42946a.m());
            }
        }

        private b(l7.d dVar, v7 v7Var, q7 q7Var) {
            this.f42894b = this;
            this.f42892a = dVar;
            c(dVar, v7Var, q7Var);
        }

        private void c(l7.d dVar, v7 v7Var, q7 q7Var) {
            this.f42896c = InstanceFactory.create(v7Var);
            this.f42898d = InstanceFactory.create(this.f42894b);
            this.f42900e = InstanceFactory.create(q7Var);
            this.f42902f = new f(dVar);
            this.f42904g = new k(dVar);
            h hVar = new h(dVar);
            this.f42906h = hVar;
            this.f42908i = DoubleCheck.provider(p7.c(this.f42896c, hVar));
            n nVar = new n(dVar);
            this.f42910j = nVar;
            this.f42912k = sc.c(nVar);
            this.f42914l = y8.c(this.f42910j);
            this.f42916m = new m(dVar);
            this.f42918n = new c(dVar);
            this.f42919o = new o(dVar);
            this.f42920p = new e(dVar);
            C0052b c0052b = new C0052b(dVar);
            this.f42921q = c0052b;
            sd c8 = sd.c(c0052b);
            this.f42922r = c8;
            this.f42923s = dq.c(this.f42920p, c8);
            rm c9 = rm.c(this.f42919o, om.a(), mm.a(), this.f42923s, gm.a(), sq.a());
            this.f42924t = c9;
            this.f42925u = vm.c(c9);
            qo c10 = qo.c(jq.a(), this.f42925u, to.a(), hq.a(), this.f42924t);
            this.f42926v = c10;
            this.f42927w = vp.c(c10, oo.a(), ee.a(), hq.a());
            xp c11 = xp.c(aq.a(), this.f42927w, tp.a(), rp.a(), pp.a(), gm.a());
            this.f42928x = c11;
            this.f42929y = wn.c(c11, go.a());
            this.f42930z = pq.c(this.f42928x, go.a());
            this.A = new l(dVar);
            this.B = jp.c(this.f42916m, this.f42918n, this.f42929y, this.f42930z, pn.a(), this.f42904g, ge.a(), this.A, go.a());
            ze c12 = ze.c(this.f42910j);
            this.C = c12;
            fh c13 = fh.c(this.f42910j, c12);
            this.D = c13;
            this.E = tk.c(this.B, c13);
            this.F = uc.c(this.f42912k);
            this.G = cd.c(this.f42910j);
            this.H = r8.c(this.f42910j, this.B, sq.a());
            y1 c14 = y1.c(this.f42910j);
            this.I = c14;
            this.J = xk.c(this.F, this.f42910j, this.D, this.G, this.H, c14);
            this.K = vk.c(this.F, this.B, this.f42910j, sq.a(), this.I);
            this.L = ch.c(this.F, this.B, this.D);
            wc c15 = wc.c(this.f42910j);
            this.M = c15;
            this.N = w8.c(c15, this.f42912k, this.f42910j);
            this.O = nn.c(this.f42920p);
            zl c16 = zl.c(this.f42910j);
            this.P = c16;
            this.Q = ul.c(this.B, this.f42910j, this.H, this.C, c16, this.I);
            this.R = new a(dVar);
            this.S = k9.c(this.f42910j);
            this.T = c9.a(this.f42912k, e2.a(), this.f42914l, this.E, this.J, this.K, this.L, this.f42910j, this.I, this.N, this.O, this.Q, this.R, this.S);
            this.U = b9.c(this.f42912k, e2.a(), this.f42914l, this.E, this.J, this.K, this.L, this.f42910j, this.I, this.N, this.O, this.Q, this.R, this.S);
            e1 c17 = e1.c(e2.a());
            this.V = c17;
            y7 c18 = y7.c(this.O, c17, this.f42920p);
            this.W = c18;
            this.X = d8.c(c18, a8.a());
            this.Y = e9.c(this.f42910j);
            this.Z = m9.c(this.f42910j);
            this.f42893a0 = g9.c(this.f42910j);
            this.f42895b0 = i9.c(this.f42910j);
            this.f42897c0 = md.c(this.f42912k);
            od c19 = od.c(this.f42910j);
            this.f42899d0 = c19;
            this.f42901e0 = ad.a(this.f42912k, this.f42897c0, c19);
            this.f42903f0 = new p(dVar);
            this.f42905g0 = new i(dVar);
            this.f42907h0 = new d(dVar);
            j jVar = new j(dVar);
            this.f42909i0 = jVar;
            cg c20 = cg.c(this.A, this.R, this.f42907h0, jVar);
            this.f42911j0 = c20;
            this.f42913k0 = DoubleCheck.provider(s7.c(this.f42900e, this.f42902f, this.f42904g, this.f42908i, this.T, this.U, this.S, this.X, this.Y, this.Z, this.f42893a0, this.f42895b0, this.I, this.N, this.f42901e0, this.f42903f0, this.f42905g0, c20, this.A));
            g gVar = new g(dVar);
            this.f42915l0 = gVar;
            this.f42917m0 = DoubleCheck.provider(m7.a(this.f42896c, this.f42898d, this.f42913k0, gVar));
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f42892a.B());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public DispatchersBundle G() {
            return (DispatchersBundle) Preconditions.checkNotNullFromComponent(this.f42892a.G());
        }

        @Override // eu.bolt.verification.sdk.internal.p2.d
        public s2 J() {
            return this.f42913k0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.p2.d
        public ib b() {
            return (ib) Preconditions.checkNotNullFromComponent(this.f42892a.b());
        }

        @Override // eu.bolt.verification.sdk.internal.l7.a
        public u7 d() {
            return this.f42917m0.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return (s) Preconditions.checkNotNullFromComponent(this.f42892a.n());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return (dl) Preconditions.checkNotNullFromComponent(this.f42892a.p());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f42892a.x());
        }
    }

    public static l7.b.a a() {
        return new a();
    }
}
