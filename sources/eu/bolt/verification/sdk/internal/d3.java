package eu.bolt.verification.sdk.internal;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.verification.sdk.internal.o5;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class d3 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a implements o5.b.a {

        /* renamed from: a  reason: collision with root package name */
        private u5 f42579a;

        /* renamed from: b  reason: collision with root package name */
        private q5 f42580b;

        /* renamed from: c  reason: collision with root package name */
        private o5.d f42581c;

        private a() {
        }

        @Override // eu.bolt.verification.sdk.internal.o5.b.a
        public o5.b build() {
            Preconditions.checkBuilderRequirement(this.f42579a, u5.class);
            Preconditions.checkBuilderRequirement(this.f42580b, q5.class);
            Preconditions.checkBuilderRequirement(this.f42581c, o5.d.class);
            return new b(this.f42581c, this.f42579a, this.f42580b);
        }

        @Override // eu.bolt.verification.sdk.internal.o5.b.a
        /* renamed from: d */
        public a b(o5.d dVar) {
            this.f42581c = (o5.d) Preconditions.checkNotNull(dVar);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.o5.b.a
        /* renamed from: e */
        public a c(q5 q5Var) {
            this.f42580b = (q5) Preconditions.checkNotNull(q5Var);
            return this;
        }

        @Override // eu.bolt.verification.sdk.internal.o5.b.a
        /* renamed from: f */
        public a a(u5 u5Var) {
            this.f42579a = (u5) Preconditions.checkNotNull(u5Var);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements o5.b {

        /* renamed from: a  reason: collision with root package name */
        private final o5.d f42582a;

        /* renamed from: b  reason: collision with root package name */
        private final b f42583b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<o5.b> f42584c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<u5> f42585d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<q5> f42586e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<y6> f42587f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<ib> f42588g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<r5> f42589h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<t5> f42590i;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a implements Provider<y6> {

            /* renamed from: a  reason: collision with root package name */
            private final o5.d f42591a;

            a(o5.d dVar) {
                this.f42591a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public y6 get() {
                return (y6) Preconditions.checkNotNullFromComponent(this.f42591a.c());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: eu.bolt.verification.sdk.internal.d3$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0043b implements Provider<ib> {

            /* renamed from: a  reason: collision with root package name */
            private final o5.d f42592a;

            C0043b(o5.d dVar) {
                this.f42592a = dVar;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ib get() {
                return (ib) Preconditions.checkNotNullFromComponent(this.f42592a.b());
            }
        }

        private b(o5.d dVar, u5 u5Var, q5 q5Var) {
            this.f42583b = this;
            this.f42582a = dVar;
            c(dVar, u5Var, q5Var);
        }

        private void c(o5.d dVar, u5 u5Var, q5 q5Var) {
            this.f42584c = InstanceFactory.create(this.f42583b);
            this.f42585d = InstanceFactory.create(u5Var);
            this.f42586e = InstanceFactory.create(q5Var);
            this.f42587f = new a(dVar);
            C0043b c0043b = new C0043b(dVar);
            this.f42588g = c0043b;
            s5 c8 = s5.c(this.f42586e, this.f42587f, c0043b);
            this.f42589h = c8;
            this.f42590i = DoubleCheck.provider(p5.a(this.f42584c, this.f42585d, c8));
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public RxActivityEvents B() {
            return (RxActivityEvents) Preconditions.checkNotNullFromComponent(this.f42582a.B());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public v4 I() {
            return (v4) Preconditions.checkNotNullFromComponent(this.f42582a.I());
        }

        @Override // eu.bolt.verification.sdk.internal.n6.d
        public qj a() {
            return (qj) Preconditions.checkNotNullFromComponent(this.f42582a.a());
        }

        @Override // eu.bolt.verification.sdk.internal.n6.d
        public y6 c() {
            return (y6) Preconditions.checkNotNullFromComponent(this.f42582a.c());
        }

        @Override // eu.bolt.verification.sdk.internal.o5.a
        public t5 d() {
            return this.f42590i.get();
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public Context k() {
            return (Context) Preconditions.checkNotNullFromComponent(this.f42582a.k());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public s n() {
            return (s) Preconditions.checkNotNullFromComponent(this.f42582a.n());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public dl p() {
            return (dl) Preconditions.checkNotNullFromComponent(this.f42582a.p());
        }

        @Override // eu.bolt.verification.sdk.internal.b0
        public CoActivityEvents x() {
            return (CoActivityEvents) Preconditions.checkNotNullFromComponent(this.f42582a.x());
        }
    }

    public static o5.b.a a() {
        return new a();
    }
}
