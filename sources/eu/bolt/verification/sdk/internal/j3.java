package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.pi;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class j3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements pi.b.a {

        /* renamed from: a  reason: collision with root package name */
        private oj f43627a;

        /* renamed from: b  reason: collision with root package name */
        private kj f43628b;

        /* renamed from: c  reason: collision with root package name */
        private pi.d f43629c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.pi.b.a
        public pi.b build() {
            Preconditions.checkBuilderRequirement(this.f43627a, oj.class);
            Preconditions.checkBuilderRequirement(this.f43628b, kj.class);
            Preconditions.checkBuilderRequirement(this.f43629c, pi.d.class);
            return new b(this.f43629c, this.f43627a, this.f43628b);
        }

        @Override // eu.bolt.verification.sdk.internal.pi.b.a
        /* renamed from: d */
        public a a(kj kjVar) {
            this.f43628b = (kj) Preconditions.checkNotNull(kjVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.pi.b.a
        /* renamed from: e */
        public a c(oj ojVar) {
            this.f43627a = (oj) Preconditions.checkNotNull(ojVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.pi.b.a
        /* renamed from: f */
        public a b(pi.d dVar) {
            this.f43629c = (pi.d) Preconditions.checkNotNull(dVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements pi.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f43630a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<oj> f43631b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<kj> f43632c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<gj> f43633d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<fj> f43634e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<RxActivityEvents> f43635f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<nj> f43636g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<mg> f43637h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<xf> f43638i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<dl> f43639j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<s> f43640k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<CoActivityEvents> f43641l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<bg> f43642m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<l5> f43643n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<lj> f43644o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<pj> f43645p;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43646a;

            a(pi.d dVar) {
                this.f43646a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f43646a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.j3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0067b implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43647a;

            C0067b(pi.d dVar) {
                this.f43647a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f43647a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<xf> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43648a;

            c(pi.d dVar) {
                this.f43648a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xf get() {
                return (xf) Preconditions.checkNotNullFromComponent(this.f43648a.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43649a;

            d(pi.d dVar) {
                this.f43649a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f43649a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<nj> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43650a;

            e(pi.d dVar) {
                this.f43650a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public nj get() {
                return (nj) Preconditions.checkNotNullFromComponent(this.f43650a.K());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43651a;

            f(pi.d dVar) {
                this.f43651a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f43651a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<mg> {

            /* renamed from: a  reason: collision with root package name */
            private final pi.d f43652a;

            g(pi.d dVar) {
                this.f43652a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public mg get() {
                return (mg) Preconditions.checkNotNullFromComponent(this.f43652a.m());
            }
        }

        private b(pi.d dVar, oj ojVar, kj kjVar) {
            this.f43630a = this;
            b(dVar, ojVar, kjVar);
        }

        private void b(pi.d dVar, oj ojVar, kj kjVar) {
            this.f43631b = InstanceFactory.create(ojVar);
            this.f43632c = InstanceFactory.create(kjVar);
            hj c8 = hj.c(this.f43631b);
            this.f43633d = c8;
            this.f43634e = DoubleCheck.provider(c8);
            this.f43635f = new d(dVar);
            this.f43636g = new e(dVar);
            this.f43637h = new g(dVar);
            this.f43638i = new c(dVar);
            this.f43639j = new f(dVar);
            this.f43640k = new a(dVar);
            C0067b c0067b = new C0067b(dVar);
            this.f43641l = c0067b;
            this.f43642m = cg.c(this.f43639j, this.f43640k, c0067b, this.f43635f);
            m5 c9 = m5.c(this.f43635f, h7.a());
            this.f43643n = c9;
            mj c10 = mj.c(this.f43632c, this.f43634e, this.f43635f, this.f43636g, this.f43637h, this.f43638i, this.f43642m, c9);
            this.f43644o = c10;
            this.f43645p = DoubleCheck.provider(qi.c(this.f43631b, c10));
        }

        @Override // eu.bolt.verification.sdk.internal.pi.a
        public pj a() {
            return this.f43645p.get();
        }
    }

    public static pi.b.a a() {
        return new a();
    }
}
