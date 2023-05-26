package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import eu.bolt.verification.sdk.internal.uh;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class i3 {

    /* loaded from: classes5.dex */
    private static final class a implements uh.a {

        /* renamed from: a  reason: collision with root package name */
        private xh f43448a;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.uh.a
        /* renamed from: b */
        public a a(xh xhVar) {
            this.f43448a = (xh) Preconditions.checkNotNull(xhVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.uh.a
        public uh build() {
            Preconditions.checkBuilderRequirement(this.f43448a, xh.class);
            return new b(this.f43448a);
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements uh {

        /* renamed from: a  reason: collision with root package name */
        private final xh f43449a;

        /* renamed from: b  reason: collision with root package name */
        private final b f43450b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<f0> f43451c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<ub> f43452d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<xg> f43453e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<s8> f43454f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<vj> f43455g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<ck> f43456h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<ek> f43457i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<dj> f43458j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<t9> f43459k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<bc> f43460l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<kk> f43461m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<bi> f43462n;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<f0> {

            /* renamed from: a  reason: collision with root package name */
            private final xh f43463a;

            a(xh xhVar) {
                this.f43463a = xhVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public f0 get() {
                return (f0) Preconditions.checkNotNullFromComponent(this.f43463a.b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.i3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0060b implements Provider<t9> {

            /* renamed from: a  reason: collision with root package name */
            private final xh f43464a;

            C0060b(xh xhVar) {
                this.f43464a = xhVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public t9 get() {
                return (t9) Preconditions.checkNotNullFromComponent(this.f43464a.d());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<ub> {

            /* renamed from: a  reason: collision with root package name */
            private final xh f43465a;

            c(xh xhVar) {
                this.f43465a = xhVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ub get() {
                return (ub) Preconditions.checkNotNullFromComponent(this.f43465a.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<bc> {

            /* renamed from: a  reason: collision with root package name */
            private final xh f43466a;

            d(xh xhVar) {
                this.f43466a = xhVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public bc get() {
                return (bc) Preconditions.checkNotNullFromComponent(this.f43466a.g());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<xg> {

            /* renamed from: a  reason: collision with root package name */
            private final xh f43467a;

            e(xh xhVar) {
                this.f43467a = xhVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public xg get() {
                return (xg) Preconditions.checkNotNullFromComponent(this.f43467a.h());
            }
        }

        private b(xh xhVar) {
            this.f43450b = this;
            this.f43449a = xhVar;
            c(xhVar);
        }

        private rj b() {
            return new rj((pa) Preconditions.checkNotNullFromComponent(this.f43449a.e()), (y5) Preconditions.checkNotNullFromComponent(this.f43449a.c()));
        }

        private void c(xh xhVar) {
            this.f43451c = new a(xhVar);
            this.f43452d = new c(xhVar);
            e eVar = new e(xhVar);
            this.f43453e = eVar;
            this.f43454f = t8.c(this.f43452d, eVar);
            wj c8 = wj.c(ni.a());
            this.f43455g = c8;
            dk c9 = dk.c(c8);
            this.f43456h = c9;
            this.f43457i = fk.c(c9);
            this.f43458j = ej.c(this.f43455g, ti.a(), this.f43457i);
            this.f43459k = new C0060b(xhVar);
            d dVar = new d(xhVar);
            this.f43460l = dVar;
            lk c10 = lk.c(this.f43453e, this.f43459k, dVar);
            this.f43461m = c10;
            this.f43462n = DoubleCheck.provider(ci.c(this.f43451c, this.f43454f, this.f43453e, this.f43458j, c10));
        }

        private eu.bolt.client.stories.view.singlestory.a d(eu.bolt.client.stories.view.singlestory.a aVar) {
            pk.a(aVar, this.f43462n.get());
            pk.d(aVar, (xg) Preconditions.checkNotNullFromComponent(this.f43449a.h()));
            pk.b(aVar, b());
            pk.c(aVar, (s) Preconditions.checkNotNullFromComponent(this.f43449a.a()));
            return aVar;
        }

        @Override // eu.bolt.verification.sdk.internal.uh
        public void a(eu.bolt.client.stories.view.singlestory.a aVar) {
            d(aVar);
        }
    }

    public static uh.a a() {
        return new a();
    }
}
