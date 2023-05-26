package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.wm;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class l3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements wm.b.a {

        /* renamed from: a  reason: collision with root package name */
        private jn f43947a;

        /* renamed from: b  reason: collision with root package name */
        private en f43948b;

        /* renamed from: c  reason: collision with root package name */
        private wm.d f43949c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.wm.b.a
        public wm.b build() {
            Preconditions.checkBuilderRequirement(this.f43947a, jn.class);
            Preconditions.checkBuilderRequirement(this.f43948b, en.class);
            Preconditions.checkBuilderRequirement(this.f43949c, wm.d.class);
            return new b(this.f43949c, this.f43947a, this.f43948b);
        }

        @Override // eu.bolt.verification.sdk.internal.wm.b.a
        /* renamed from: d */
        public a b(en enVar) {
            this.f43948b = (en) Preconditions.checkNotNull(enVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.wm.b.a
        /* renamed from: e */
        public a a(jn jnVar) {
            this.f43947a = (jn) Preconditions.checkNotNull(jnVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.wm.b.a
        /* renamed from: f */
        public a c(wm.d dVar) {
            this.f43949c = (wm.d) Preconditions.checkNotNull(dVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements wm.b {
        private Provider<CoActivityEvents> A;
        private Provider<dl> B;
        private Provider<s> C;
        private Provider<bg> D;
        private Provider<g1> E;
        private Provider<fn> F;
        private Provider<ViewGroup> G;
        private Provider<in> H;

        /* renamed from: a  reason: collision with root package name */
        private final wm.d f43950a;

        /* renamed from: b  reason: collision with root package name */
        private final b f43951b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<jn> f43952c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<wm.b> f43953d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<en> f43954e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<hn> f43955f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<x9> f43956g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<cn> f43957h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<xg> f43958i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<cf> f43959j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<xn> f43960k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<x1> f43961l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<vc> f43962m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<rc> f43963n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<v8> f43964o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<Context> f43965p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<mn> f43966q;

        /* renamed from: r  reason: collision with root package name */
        private Provider<Activity> f43967r;

        /* renamed from: s  reason: collision with root package name */
        private Provider<AppCompatActivity> f43968s;

        /* renamed from: t  reason: collision with root package name */
        private Provider<PreviewView> f43969t;

        /* renamed from: u  reason: collision with root package name */
        private Provider<i1> f43970u;

        /* renamed from: v  reason: collision with root package name */
        private Provider<mg> f43971v;

        /* renamed from: w  reason: collision with root package name */
        private Provider<ke> f43972w;

        /* renamed from: x  reason: collision with root package name */
        private Provider<sf> f43973x;

        /* renamed from: y  reason: collision with root package name */
        private Provider<xf> f43974y;

        /* renamed from: z  reason: collision with root package name */
        private Provider<RxActivityEvents> f43975z;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<Activity> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43976a;

            a(wm.d dVar) {
                this.f43976a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Activity get() {
                return (Activity) Preconditions.checkNotNullFromComponent(this.f43976a.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.l3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0070b implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43977a;

            C0070b(wm.d dVar) {
                this.f43977a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f43977a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43978a;

            c(wm.d dVar) {
                this.f43978a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f43978a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<Context> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43979a;

            d(wm.d dVar) {
                this.f43979a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.f43979a.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<ViewGroup> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43980a;

            e(wm.d dVar) {
                this.f43980a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ViewGroup get() {
                return (ViewGroup) Preconditions.checkNotNullFromComponent(this.f43980a.H());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<x9> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43981a;

            f(wm.d dVar) {
                this.f43981a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public x9 get() {
                return (x9) Preconditions.checkNotNullFromComponent(this.f43981a.q());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<ke> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43982a;

            g(wm.d dVar) {
                this.f43982a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ke get() {
                return (ke) Preconditions.checkNotNullFromComponent(this.f43982a.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class h implements Provider<sf> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43983a;

            h(wm.d dVar) {
                this.f43983a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public sf get() {
                return (sf) Preconditions.checkNotNullFromComponent(this.f43983a.o());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class i implements Provider<xf> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43984a;

            i(wm.d dVar) {
                this.f43984a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xf get() {
                return (xf) Preconditions.checkNotNullFromComponent(this.f43984a.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class j implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43985a;

            j(wm.d dVar) {
                this.f43985a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f43985a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class k implements Provider<xg> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43986a;

            k(wm.d dVar) {
                this.f43986a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xg get() {
                return (xg) Preconditions.checkNotNullFromComponent(this.f43986a.s());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class l implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43987a;

            l(wm.d dVar) {
                this.f43987a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f43987a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class m implements Provider<hn> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43988a;

            m(wm.d dVar) {
                this.f43988a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public hn get() {
                return (hn) Preconditions.checkNotNullFromComponent(this.f43988a.A());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class n implements Provider<xn> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43989a;

            n(wm.d dVar) {
                this.f43989a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xn get() {
                return (xn) Preconditions.checkNotNullFromComponent(this.f43989a.g());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class o implements Provider<mg> {

            /* renamed from: a  reason: collision with root package name */
            private final wm.d f43990a;

            o(wm.d dVar) {
                this.f43990a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public mg get() {
                return (mg) Preconditions.checkNotNullFromComponent(this.f43990a.m());
            }
        }

        private b(wm.d dVar, jn jnVar, en enVar) {
            this.f43951b = this;
            this.f43950a = dVar;
            c(dVar, jnVar, enVar);
        }

        private void c(wm.d dVar, jn jnVar, en enVar) {
            this.f43952c = InstanceFactory.create(jnVar);
            this.f43953d = InstanceFactory.create(this.f43951b);
            this.f43954e = InstanceFactory.create(enVar);
            this.f43955f = new m(dVar);
            this.f43956g = new f(dVar);
            this.f43957h = DoubleCheck.provider(dn.c(this.f43952c, a8.a(), this.f43956g));
            this.f43958i = new k(dVar);
            this.f43959j = df.c(d0.a(), this.f43958i);
            n nVar = new n(dVar);
            this.f43960k = nVar;
            this.f43961l = y1.c(nVar);
            this.f43962m = wc.c(this.f43960k);
            sc c8 = sc.c(this.f43960k);
            this.f43963n = c8;
            this.f43964o = w8.c(this.f43962m, c8, this.f43960k);
            d dVar2 = new d(dVar);
            this.f43965p = dVar2;
            this.f43966q = nn.c(dVar2);
            a aVar = new a(dVar);
            this.f43967r = aVar;
            this.f43968s = DoubleCheck.provider(xm.c(aVar));
            Provider<PreviewView> provider = DoubleCheck.provider(ym.c(this.f43952c));
            this.f43969t = provider;
            this.f43970u = j1.c(this.f43968s, provider, this.f43958i);
            this.f43971v = new o(dVar);
            this.f43972w = new g(dVar);
            this.f43973x = new h(dVar);
            this.f43974y = new i(dVar);
            this.f43975z = new j(dVar);
            this.A = new c(dVar);
            this.B = new l(dVar);
            C0070b c0070b = new C0070b(dVar);
            this.C = c0070b;
            this.D = cg.c(this.B, c0070b, this.A, this.f43975z);
            this.E = h1.c(this.f43965p);
            this.F = DoubleCheck.provider(gn.c(this.f43954e, this.f43955f, this.f43957h, this.f43959j, this.f43961l, this.f43964o, this.f43966q, this.f43970u, this.f43971v, this.f43972w, this.f43973x, this.f43974y, this.f43975z, this.A, this.f43958i, this.D, p1.a(), this.E, this.B));
            e eVar = new e(dVar);
            this.G = eVar;
            this.H = DoubleCheck.provider(zm.c(this.f43952c, this.f43953d, this.F, eVar));
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f43950a.B());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public v4 I() {
            return (v4) Preconditions.checkNotNullFromComponent(this.f43950a.I());
        }

        @Override // eu.bolt.verification.sdk.internal.o5.d
        public qj a() {
            return (qj) Preconditions.checkNotNullFromComponent(this.f43950a.a());
        }

        @Override // eu.bolt.verification.sdk.internal.o5.d
        public ib b() {
            return (ib) Preconditions.checkNotNullFromComponent(this.f43950a.b());
        }

        @Override // eu.bolt.verification.sdk.internal.o5.d
        public y6 c() {
            return this.F.get();
        }

        @Override // eu.bolt.verification.sdk.internal.wm.a
        public in d() {
            return this.H.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public Context k() {
            return (Context) Preconditions.checkNotNullFromComponent(this.f43950a.k());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return (s) Preconditions.checkNotNullFromComponent(this.f43950a.n());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return (dl) Preconditions.checkNotNullFromComponent(this.f43950a.p());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f43950a.x());
        }
    }

    public static wm.b.a a() {
        return new a();
    }
}
