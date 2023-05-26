package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import eu.bolt.verification.sdk.internal.p2;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class c3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements p2.b.a {

        /* renamed from: a  reason: collision with root package name */
        private y2 f42431a;

        /* renamed from: b  reason: collision with root package name */
        private o2 f42432b;

        /* renamed from: c  reason: collision with root package name */
        private p2.d f42433c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.p2.b.a
        public p2.b build() {
            Preconditions.checkBuilderRequirement(this.f42431a, y2.class);
            Preconditions.checkBuilderRequirement(this.f42432b, o2.class);
            Preconditions.checkBuilderRequirement(this.f42433c, p2.d.class);
            return new b(this.f42433c, this.f42431a, this.f42432b);
        }

        @Override // eu.bolt.verification.sdk.internal.p2.b.a
        /* renamed from: d */
        public a a(o2 o2Var) {
            this.f42432b = (o2) Preconditions.checkNotNull(o2Var);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.p2.b.a
        /* renamed from: e */
        public a c(p2.d dVar) {
            this.f42433c = (p2.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.p2.b.a
        /* renamed from: f */
        public a b(y2 y2Var) {
            this.f42431a = (y2) Preconditions.checkNotNull(y2Var);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements p2.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f42434a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<y2> f42435b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<o2> f42436c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<u2> f42437d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<DispatchersBundle> f42438e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<qe> f42439f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<dl> f42440g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<s> f42441h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<CoActivityEvents> f42442i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<RxActivityEvents> f42443j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<bg> f42444k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<s2> f42445l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<ib> f42446m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<q2> f42447n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<w2> f42448o;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42449a;

            a(p2.d dVar) {
                this.f42449a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f42449a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.c3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0040b implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42450a;

            C0040b(p2.d dVar) {
                this.f42450a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f42450a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<s2> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42451a;

            c(p2.d dVar) {
                this.f42451a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s2 get() {
                return (s2) Preconditions.checkNotNullFromComponent(this.f42451a.J());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<DispatchersBundle> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42452a;

            d(p2.d dVar) {
                this.f42452a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DispatchersBundle get() {
                return (DispatchersBundle) Preconditions.checkNotNullFromComponent(this.f42452a.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<ib> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42453a;

            e(p2.d dVar) {
                this.f42453a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ib get() {
                return (ib) Preconditions.checkNotNullFromComponent(this.f42453a.b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42454a;

            f(p2.d dVar) {
                this.f42454a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f42454a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final p2.d f42455a;

            g(p2.d dVar) {
                this.f42455a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f42455a.p());
            }
        }

        private b(p2.d dVar, y2 y2Var, o2 o2Var) {
            this.f42434a = this;
            b(dVar, y2Var, o2Var);
        }

        private void b(p2.d dVar, y2 y2Var, o2 o2Var) {
            this.f42435b = InstanceFactory.create(y2Var);
            Factory create = InstanceFactory.create(o2Var);
            this.f42436c = create;
            this.f42437d = DoubleCheck.provider(v2.c(this.f42435b, create));
            d dVar2 = new d(dVar);
            this.f42438e = dVar2;
            this.f42439f = re.c(dVar2);
            this.f42440g = new g(dVar);
            this.f42441h = new a(dVar);
            this.f42442i = new C0040b(dVar);
            f fVar = new f(dVar);
            this.f42443j = fVar;
            this.f42444k = cg.c(this.f42440g, this.f42441h, this.f42442i, fVar);
            this.f42445l = new c(dVar);
            e eVar = new e(dVar);
            this.f42446m = eVar;
            Provider<q2> provider = DoubleCheck.provider(r2.c(this.f42436c, this.f42437d, this.f42439f, this.f42444k, this.f42445l, eVar));
            this.f42447n = provider;
            this.f42448o = DoubleCheck.provider(x2.c(this.f42435b, provider));
        }

        @Override // eu.bolt.verification.sdk.internal.p2.a
        public w2 a() {
            return this.f42448o.get();
        }
    }

    public static p2.b.a a() {
        return new a();
    }
}
