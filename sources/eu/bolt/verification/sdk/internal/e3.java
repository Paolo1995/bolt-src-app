package eu.bolt.verification.sdk.internal;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.n6;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class e3 {

    /* loaded from: classes5.dex */
    private static final class a implements n6.b.a {

        /* renamed from: a  reason: collision with root package name */
        private w6 f42687a;

        /* renamed from: b  reason: collision with root package name */
        private n6.d f42688b;

        /* renamed from: c  reason: collision with root package name */
        private s6 f42689c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.n6.b.a
        public n6.b build() {
            Preconditions.checkBuilderRequirement(this.f42687a, w6.class);
            Preconditions.checkBuilderRequirement(this.f42688b, n6.d.class);
            Preconditions.checkBuilderRequirement(this.f42689c, s6.class);
            return new b(this.f42688b, this.f42687a, this.f42689c);
        }

        @Override // eu.bolt.verification.sdk.internal.n6.b.a
        /* renamed from: d */
        public a b(n6.d dVar) {
            this.f42688b = (n6.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.n6.b.a
        /* renamed from: e */
        public a a(s6 s6Var) {
            this.f42689c = (s6) Preconditions.checkNotNull(s6Var);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.n6.b.a
        /* renamed from: f */
        public a c(w6 w6Var) {
            this.f42687a = (w6) Preconditions.checkNotNull(w6Var);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements n6.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f42690a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<w6> f42691b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<s6> f42692c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<q6> f42693d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<p6> f42694e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<RxActivityEvents> f42695f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<dl> f42696g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<s> f42697h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<CoActivityEvents> f42698i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<bg> f42699j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<Context> f42700k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<v4> f42701l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<ml> f42702m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<y6> f42703n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<t6> f42704o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<qj> f42705p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<v6> f42706q;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<s> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42707a;

            a(n6.d dVar) {
                this.f42707a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public s get() {
                return (s) Preconditions.checkNotNullFromComponent(this.f42707a.n());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.e3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0047b implements Provider<CoActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42708a;

            C0047b(n6.d dVar) {
                this.f42708a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoActivityEvents get() {
                return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f42708a.x());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class c implements Provider<Context> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42709a;

            c(n6.d dVar) {
                this.f42709a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.f42709a.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class d implements Provider<v4> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42710a;

            d(n6.d dVar) {
                this.f42710a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public v4 get() {
                return (v4) Preconditions.checkNotNullFromComponent(this.f42710a.I());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class e implements Provider<y6> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42711a;

            e(n6.d dVar) {
                this.f42711a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public y6 get() {
                return (y6) Preconditions.checkNotNullFromComponent(this.f42711a.c());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class f implements Provider<RxActivityEvents> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42712a;

            f(n6.d dVar) {
                this.f42712a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RxActivityEvents get() {
                return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f42712a.B());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class g implements Provider<qj> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42713a;

            g(n6.d dVar) {
                this.f42713a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public qj get() {
                return (qj) Preconditions.checkNotNullFromComponent(this.f42713a.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class h implements Provider<dl> {

            /* renamed from: a  reason: collision with root package name */
            private final n6.d f42714a;

            h(n6.d dVar) {
                this.f42714a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public dl get() {
                return (dl) Preconditions.checkNotNullFromComponent(this.f42714a.p());
            }
        }

        private b(n6.d dVar, w6 w6Var, s6 s6Var) {
            this.f42690a = this;
            b(dVar, w6Var, s6Var);
        }

        private void b(n6.d dVar, w6 w6Var, s6 s6Var) {
            this.f42691b = InstanceFactory.create(w6Var);
            Factory create = InstanceFactory.create(s6Var);
            this.f42692c = create;
            r6 c8 = r6.c(create, this.f42691b);
            this.f42693d = c8;
            this.f42694e = DoubleCheck.provider(c8);
            this.f42695f = new f(dVar);
            this.f42696g = new h(dVar);
            this.f42697h = new a(dVar);
            C0047b c0047b = new C0047b(dVar);
            this.f42698i = c0047b;
            this.f42699j = cg.c(this.f42696g, this.f42697h, c0047b, this.f42695f);
            this.f42700k = new c(dVar);
            d dVar2 = new d(dVar);
            this.f42701l = dVar2;
            this.f42702m = nl.c(this.f42700k, dVar2);
            e eVar = new e(dVar);
            this.f42703n = eVar;
            Provider<p6> provider = this.f42694e;
            Provider<s6> provider2 = this.f42692c;
            Provider<RxActivityEvents> provider3 = this.f42695f;
            Provider<bg> provider4 = this.f42699j;
            this.f42704o = u6.c(provider, provider2, provider3, provider4, this.f42702m, eVar, provider4);
            g gVar = new g(dVar);
            this.f42705p = gVar;
            this.f42706q = DoubleCheck.provider(o6.a(this.f42691b, this.f42704o, gVar));
        }

        @Override // eu.bolt.verification.sdk.internal.n6.a
        public v6 a() {
            return this.f42706q.get();
        }
    }

    public static n6.b.a a() {
        return new a();
    }
}
