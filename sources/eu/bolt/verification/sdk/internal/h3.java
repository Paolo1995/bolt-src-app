package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.sh;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class h3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements sh.b.a {

        /* renamed from: a  reason: collision with root package name */
        private hi f43314a;

        /* renamed from: b  reason: collision with root package name */
        private di f43315b;

        /* renamed from: c  reason: collision with root package name */
        private sh.d f43316c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.sh.b.a
        public sh.b build() {
            Preconditions.checkBuilderRequirement(this.f43314a, hi.class);
            Preconditions.checkBuilderRequirement(this.f43315b, di.class);
            Preconditions.checkBuilderRequirement(this.f43316c, sh.d.class);
            return new b(this.f43316c, this.f43314a, this.f43315b);
        }

        @Override // eu.bolt.verification.sdk.internal.sh.b.a
        /* renamed from: d */
        public a a(di diVar) {
            this.f43315b = (di) Preconditions.checkNotNull(diVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.sh.b.a
        /* renamed from: e */
        public a c(hi hiVar) {
            this.f43314a = (hi) Preconditions.checkNotNull(hiVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.sh.b.a
        /* renamed from: f */
        public a b(sh.d dVar) {
            this.f43316c = (sh.d) Preconditions.checkNotNull(dVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements sh.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f43317a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<hi> f43318b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<di> f43319c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<zh> f43320d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<yh> f43321e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<RxActivityEvents> f43322f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<mg> f43323g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<gi> f43324h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<dl> f43325i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<s> f43326j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<CoActivityEvents> f43327k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<bg> f43328l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<ei> f43329m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<ii> f43330n;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final sh.d f43331a;

            a(sh.d dVar) {
                this.f43331a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f43331a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.h3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0057b implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final sh.d f43332a;

            C0057b(sh.d dVar) {
                this.f43332a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f43332a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final sh.d f43333a;

            c(sh.d dVar) {
                this.f43333a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f43333a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<gi> {

            /* renamed from: a  reason: collision with root package name */
            private final sh.d f43334a;

            d(sh.d dVar) {
                this.f43334a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public gi get() {
                return (gi) Preconditions.checkNotNullFromComponent(this.f43334a.u());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final sh.d f43335a;

            e(sh.d dVar) {
                this.f43335a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f43335a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<mg> {

            /* renamed from: a  reason: collision with root package name */
            private final sh.d f43336a;

            f(sh.d dVar) {
                this.f43336a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public mg get() {
                return (mg) Preconditions.checkNotNullFromComponent(this.f43336a.m());
            }
        }

        private b(sh.d dVar, hi hiVar, di diVar) {
            this.f43317a = this;
            b(dVar, hiVar, diVar);
        }

        private void b(sh.d dVar, hi hiVar, di diVar) {
            this.f43318b = InstanceFactory.create(hiVar);
            this.f43319c = InstanceFactory.create(diVar);
            ai a8 = ai.a(this.f43318b);
            this.f43320d = a8;
            this.f43321e = DoubleCheck.provider(a8);
            this.f43322f = new c(dVar);
            this.f43323g = new f(dVar);
            this.f43324h = new d(dVar);
            this.f43325i = new e(dVar);
            this.f43326j = new a(dVar);
            C0057b c0057b = new C0057b(dVar);
            this.f43327k = c0057b;
            cg c8 = cg.c(this.f43325i, this.f43326j, c0057b, this.f43322f);
            this.f43328l = c8;
            fi c9 = fi.c(this.f43319c, this.f43321e, this.f43322f, this.f43323g, this.f43324h, c8);
            this.f43329m = c9;
            this.f43330n = DoubleCheck.provider(th.c(this.f43318b, c9));
        }

        @Override // eu.bolt.verification.sdk.internal.sh.a
        public ii a() {
            return this.f43330n.get();
        }
    }

    public static sh.b.a a() {
        return new a();
    }
}
